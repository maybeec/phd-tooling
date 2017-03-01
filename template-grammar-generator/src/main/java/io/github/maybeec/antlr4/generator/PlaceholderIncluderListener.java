package io.github.maybeec.antlr4.generator;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    private String placeHolderName;

    private String placeHolderDef;

    private String newGrammarName;

    private HashSet<String> selectedRules;

    private List<String> multiLexerRules;

    private String uniqueStart;

    private String uniquePlaceholderStart;

    private int uniqueNameCounter;

    private List<String> createdLexerRuleList = new LinkedList<>();

    /**
     * @author fkreis (06.05.2016)
     * @param tokenNames
     * @param tokens
     * @param grammarSpec
     * @param selectedRules
     * @param multiLexerRules
     * @param metaLanguageRuleSet
     */
    public PlaceholderIncluderListener(CommonTokenStream tokens, Map<String, String> tokenNames,
        HashSet<String> selectedRules, List<String> multiLexerRules, GrammarSpec grammarSpec) {
        rewriter = new TokenStreamRewriter(tokens);
        this.tokenNames = tokenNames;
        this.selectedRules = selectedRules;
        this.multiLexerRules = multiLexerRules;

        placeHolderName = grammarSpec.getPlaceHolderName();
        placeHolderDef = grammarSpec.getPlaceHolderDef();
        newGrammarName = grammarSpec.getNewGrammarName();
        uniquePlaceholderStart = grammarSpec.getUniquePlaceholderStart();
        uniqueStart = grammarSpec.getUniqueStart();
    }

    /**
     * Adds a typed Placeholder for originalRule
     *
     * @param originalRule
     *            The rule to create a type placeholder for
     * @param placeholderType
     *            The name of the original rule
     * @author fkreis (28.04.2016)
     */
    private void addTypedPlaceholder(ParserRuleContext originalRule, String placeholderType) {
        rewriter.insertAfter(originalRule.stop, "\n" + uniqueStart + placeholderType + placeHolderName + ": "
            + uniquePlaceholderStart + placeHolderName + "; //language extension");
    }

    @Override
    public void exitGrammarSpec(GrammarSpecContext ctx) {

        // insert Placeholder
        rewriter.insertAfter(ctx.stop, "\n" + uniquePlaceholderStart + placeHolderName + ": " + placeHolderDef + ";");

        // insert implicit tokens
        for (String s : createdLexerRuleList) {
            rewriter.insertAfter(ctx.stop, "\n" + s);
        }

        // rename grammar
        rewriter.replace(ctx.identifier().stop, newGrammarName);
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
     * @author fkreis (08.02.2016)
     */
    @Override
    public void exitRuleref(RulerefContext ctx) {
        String referencedRuleName = ctx.getText();

        if (!isRecursive(ctx) && selectedRules.contains(referencedRuleName)) {
            extendRuleRef(ctx);
        } else if (!isRecursive(ctx) && !selectedRules.contains(referencedRuleName)) {
            // add () to allow condition and loop extension
            rewriter.insertBefore(ctx.start, "(");
            rewriter.insertAfter(ctx.stop, ")");
        }

    }

    /**
     * {@inheritDoc}
     * @author fkreis (08.02.2016)
     */
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
                        String newLexerRuleName = uniquePlaceholderStart + "ImplicitToken" + uniqueNameCounter;
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

    /**
     * @param ctx
     * @author fkreis (28.04.2016)
     */
    private void extendRuleRef(RulerefContext ctx) {
        String ruleName = ctx.getText();
        rewriter.insertBefore(ctx.start, "(" + uniqueStart + ruleName + placeHolderName + " | ");
        rewriter.insertAfter(ctx.stop, ")");
    }

    private void extendTerminal(TerminalContext ctx, String tokenName) {
        rewriter.insertBefore(ctx.start, "(" + uniqueStart + tokenName + placeHolderName + " | ");
        rewriter.insertAfter(ctx.stop, ")");
    }

    /**
     * Returns the field 'rewriter'
     * @return value of rewriter
     * @author fkreis (08.02.2016)
     */
    public TokenStreamRewriter getRewriter() {
        return rewriter;
    }

    /**
     * @param ctx
     * @return
     * @author fkreis (28.04.2016)
     */
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
