package io.github.maybeec.antlr4.generator;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.parser.antlr4.ANTLRv4Parser.EbnfSuffixContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.ElementContext;
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
public class RulePlaceholderRewriter extends ANTLRv4ParserBaseListener {

    private TokenStreamRewriter rewriter;

    private Map<String, String> tokenNames;

    private HashSet<String> selectedRules;

    private List<String> multiLexerRules;

    private GrammarSpec grammarSpec;

    private int uniqueNameCounter;

    private List<String> createdLexerRuleList = new LinkedList<>();

    private Set<String> usedPlaceholderRules = new HashSet<>();

    public RulePlaceholderRewriter(CommonTokenStream tokens, Map<String, String> tokenNames,
        HashSet<String> selectedRules, List<String> multiLexerRules, GrammarSpec grammarSpec) {
        rewriter = new TokenStreamRewriter(tokens);
        this.tokenNames = tokenNames;
        this.selectedRules = selectedRules;
        this.multiLexerRules = multiLexerRules;
        this.grammarSpec = grammarSpec;
    }

    /**
     * Extend a reference to rule with the respective placeholder type accordingly to the tactics. Recursive
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
                            grammarSpec.getMetaLangLexerRulePrefix() + "ImplicitToken" + uniqueNameCounter;
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
        String phRuleName;
        switch (cardinality) {
        case "":
            phRuleName = grammarSpec.getMetaLangParserRulePrefix() + ruleName;
            usedPlaceholderRules.add(phRuleName);
            rewriter.insertBefore(ctx.start, "(" + phRuleName + " | ");
            rewriter.insertAfter(ctx.stop, ")");
            break;
        case "?":
            phRuleName = grammarSpec.getOptPhParserRuleName(ruleName);
            usedPlaceholderRules.add(phRuleName);
            rewriter.insertBefore(ctx.start, "(" + phRuleName + " | ");
            rewriter.insertAfter(ctx.stop, ")");
            break;
        case "*":
            phRuleName = grammarSpec.getStarPhParserRuleName(ruleName);
            usedPlaceholderRules.add(phRuleName);
            rewriter.insertBefore(ctx.start, "(" + phRuleName + " | ");
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

    public Set<String> getUsedPlaceholderRules() {
        return usedPlaceholderRules;
    }

    public List<String> getCreatedLexerRuleList() {
        return createdLexerRuleList;
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
