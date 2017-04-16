package io.github.maybeec.antlr4.generator;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.parser.antlr4.ANTLRv4Parser.EbnfSuffixContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.ElementContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.GrammarSpecContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.LexerRuleSpecContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.ParserRuleSpecContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.RulerefContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.TerminalContext;
import org.antlr.parser.antlr4.ANTLRv4ParserBaseListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStreamRewriter;

/**
 * A class to introduce placeholders of a given meta language into an object language grammar
 */
public class PlaceholderIncluderListener extends ANTLRv4ParserBaseListener {

    private TokenStreamRewriter rewriter;

    private Map<String, String> tokenNames;

    private HashSet<String> selectedRules;

    private List<String> multiLexerRules;

    private GrammarSpec grammarSpec;

    private final String phTokenName;

    private int uniqueNameCounter;

    private Set<String> rewrittenPlaceholderBlocks = new HashSet<>();

    private List<String> createdLexerRuleList = new LinkedList<>();

    public PlaceholderIncluderListener(CommonTokenStream tokens, Map<String, String> tokenNames,
        HashSet<String> selectedRules, List<String> multiLexerRules, GrammarSpec grammarSpec) {
        rewriter = new TokenStreamRewriter(tokens);
        this.tokenNames = tokenNames;
        this.selectedRules = selectedRules;
        this.multiLexerRules = multiLexerRules;
        this.grammarSpec = grammarSpec;
        phTokenName = grammarSpec.getMetaLangPlaceholderPrefix() + grammarSpec.getPlaceHolderSuffix();
    }

    /**
     * Adds a typed Placeholder for originalRule
     *
     * @param originalRule
     *            The rule to create a type placeholder for
     * @param placeholderType
     *            The name of the original rule
     */
    private void addTypedPlaceholder(ParserRuleContext originalRule, String placeholderType) {

        String placeHolderSuffix = grammarSpec.getPlaceHolderSuffix();
        String metaLangRulePrefix = grammarSpec.getMetaLangRulePrefix();

        String optPhRuleName = getOptPhRuleName(placeholderType);

        rewriter.insertAfter(originalRule.stop,
            "\n//language extension\n" //
                + metaLangRulePrefix + placeholderType + ": " + phTokenName + ";\n" //
                + optPhRuleName + ": " + phTokenName + " | "
                + (createQuestionRuleContent("(" + optPhRuleName + " | " + placeholderType + ")") + ";")//
        );
    }

    private String getOptPhRuleName(String atomName) {
        return grammarSpec.getMetaLangRulePrefix() + atomName + "Opt";
    }

    private String createIfLoopRuleContent(String body) {
        String content = grammarSpec.getIfRuleDef().replace("body", body) + " | "
            + grammarSpec.getLoopRuleDef().replace("body", body);
        return content;
    }

    private String createStarRuleContent(String body) {
        String content = grammarSpec.getIfRuleDef().replaceAll("body", body) + " | "
            + grammarSpec.getIfElseRuleDef().replaceAll("body", body) + " | "
            + grammarSpec.getLoopRuleDef().replaceAll("body", body);
        return content;
    }

    private String createQuestionRuleContent(String body) {
        String content = grammarSpec.getIfRuleDef().replaceAll("body", body) + " | "
            + grammarSpec.getIfElseRuleDef().replaceAll("body", body);

        return content;
    }

    private String createOneRuleContent(String body) {
        String content = grammarSpec.getIfElseRuleDef().replaceAll("body", body);
        return content;
    }

    @Override
    public void exitGrammarSpec(GrammarSpecContext ctx) {

        // insert Placeholder
        rewriter.insertAfter(ctx.stop, "\n" + phTokenName + ": " + grammarSpec.getPlaceHolderDef() + ";");

        // insert implicit tokens
        for (String s : createdLexerRuleList) {
            rewriter.insertAfter(ctx.stop, "\n" + s);
        }

        // rename grammar
        rewriter.replace(ctx.identifier().stop, grammarSpec.getNewGrammarName());
    }

    @Override
    public void exitLexerRuleSpec(LexerRuleSpecContext ctx) {
        String lexerRuleName = ctx.TOKEN_REF().getText();

        if (selectedRules.contains(lexerRuleName)) {
            addTypedPlaceholder(ctx, lexerRuleName);
        }
    }

    @Override
    public void exitParserRuleSpec(ParserRuleSpecContext ctx) {
        String parserRuleName = ctx.RULE_REF().getText();

        if (selectedRules.contains(parserRuleName)) {
            addTypedPlaceholder(ctx, parserRuleName);
        }
    }

    /**
     * Extend a reference to rule with the respective placeholder type accordingly to the tactic. Recursive
     * references are ignored in general.
     */
    @Override
    public void exitRuleref(RulerefContext ctx) {
        String referencedRuleName = ctx.getText();

        if (!isRecursive(ctx) && selectedRules.contains(referencedRuleName)) {
            EbnfSuffixContext ebnfSuffixContext = ((ElementContext) ctx.parent.parent).ebnfSuffix();
            String ebnfSuffix = ebnfSuffixContext != null ? ebnfSuffixContext.getText() : "";
            extendRuleRef(ctx, ebnfSuffix);
        } else if (!isRecursive(ctx) && !selectedRules.contains(referencedRuleName)) {
            // add () to allow condition and loop extension
            rewriter.insertBefore(ctx.start, "(");
            rewriter.insertAfter(ctx.stop, ")");
        }
    }

    @Override
    public void exitTerminal(TerminalContext ctx) {
        // change lexer token to extended rule (add "OrPlaceholder")
        // check for correct rules of manual written words (' ')
        // ignore predefined Token EOF which is without ' '

        String terminal = ctx.getText();
        String tokenName;
        boolean isInParserRule;

        if (terminal.startsWith("'") && terminal.endsWith("'")) {
            // lookup token name (might become null)
            tokenName = tokenNames.get(terminal);

            // check whether terminal occurs in a parser rule
            ParserRuleContext currentParent = ctx.getParent();
            isInParserRule = false;
            while (currentParent != null) {
                if (currentParent instanceof ParserRuleSpecContext) {
                    isInParserRule = true;
                    if (tokenName == null) {
                        System.out
                            .println("Did not find appropriate Tokenname for clean text in a parser rule: " + terminal);
                        uniqueNameCounter++;
                        String newLexerRuleName =
                            grammarSpec.getMetaLangPlaceholderPrefix() + "ImplicitToken" + uniqueNameCounter;
                        tokenName = newLexerRuleName;
                        createdLexerRuleList.add(newLexerRuleName + ":" + ctx.getText() + ";");
                    }
                    rewriter.replace(ctx.stop, tokenName + " "); // normalize
                                                                 // grammar

                    break;
                } else {
                    currentParent = currentParent.getParent();
                }
            }

        } else {
            tokenName = terminal;

            // check whether terminal occurs in a parser rule
            ParserRuleContext currentParent = ctx.getParent();
            isInParserRule = false;
            while (currentParent != null) {
                if (currentParent instanceof ParserRuleSpecContext) {
                    isInParserRule = true;
                    break;
                } else {
                    currentParent = currentParent.getParent();
                }
            }
        }

        if (tokenName != null && isInParserRule && selectedRules.contains(tokenName)) {

            extendTerminal(ctx, tokenName);

        } else if (tokenName != null && isInParserRule && !selectedRules.contains(tokenName)
            && multiLexerRules.contains(tokenName)) {
            // add () to allow condition and loop extension if not fixed token
            rewriter.insertBefore(ctx.start, "(");
            rewriter.insertAfter(ctx.stop, ")");
        }

    }

    private void extendRuleRef(RulerefContext ctx, String cardinality) {
        String ruleName = ctx.getText();
        rewriteRule(ctx, cardinality, ruleName);
    }

    private void rewriteRule(ParserRuleContext ctx, String cardinality, String ruleName) {
        switch (cardinality) {
        case "":
            rewriter.insertBefore(ctx.start, "(" + grammarSpec.getMetaLangRulePrefix() + ruleName + " | ");
            rewriter.insertAfter(ctx.stop, ")");
            break;
        case "?":
            rewriter.insertBefore(ctx.start, "(" + getOptPhRuleName(ruleName) + " | ");
            rewriter.insertAfter(ctx.stop, ")");
            break;
        default:
            break;
        }
    }

    private void extendTerminal(TerminalContext ctx, String tokenName) {
        EbnfSuffixContext ebnfSuffixContext = ((ElementContext) ctx.parent.parent).ebnfSuffix();
        String ebnfSuffix = ebnfSuffixContext != null ? ebnfSuffixContext.getText() : "";
        rewriteRule(ctx, ebnfSuffix, tokenName);
    }

    /**
     * Returns the field 'rewriter'
     * @return value of rewriter
     */
    public TokenStreamRewriter getRewriter() {
        return rewriter;
    }

    private boolean isRecursive(RulerefContext ctx) {
        String ruleName = ctx.getText();
        ParserRuleContext currentParent = ctx.getParent();
        boolean isRecursive = false;
        while (currentParent != null) {
            if (currentParent instanceof ParserRuleSpecContext) {
                ParserRuleSpecContext parentRule = (ParserRuleSpecContext) currentParent;
                if (ruleName.equals(parentRule.RULE_REF().getText())) {
                    isRecursive = true;
                }
                break;
            } else {
                currentParent = currentParent.getParent();
            }
        }
        return isRecursive;
    }
}
