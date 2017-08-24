package io.github.maybeec.antlr4.generator;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.parser.antlr4.ANTLRv4Parser.AltListContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.AlternativeContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.AtomContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.BlockContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.EbnfContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.EbnfSuffixContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.ElementContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.IdentifierContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.LabeledElementContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.ParserRuleSpecContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.RulerefContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.TerminalContext;
import org.antlr.parser.antlr4.ANTLRv4ParserBaseListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * A class to introduce placeholders of a given meta language into an object language grammar
 */
public class RulePlaceholderRewriter extends ANTLRv4ParserBaseListener {

    public static final boolean TRANSFORM_POTENTIAL_CHAIN_RULES = true;

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

        if (!GrammarUtil.isLeftRecursive(ctx)) {
            if (selectedRules.contains(referencedRuleName)) {
                EbnfSuffixContext ebnfSuffixContext = getParent(ctx, ElementContext.class).ebnfSuffix();
                // ignore chain productions of max occurrence 1
                if (!isChainRule(ctx, ebnfSuffixContext)) {
                    String ebnfSuffix = ebnfSuffixContext != null ? ebnfSuffixContext.getText() : "";
                    extendRuleRef(ctx, ebnfSuffix);
                }
            }
            // else {
            // // add () to allow condition and loop extension
            // rewriter.insertBefore(ctx.start, "(");
            // rewriter.insertAfter(ctx.stop, ")");
            // }
        }
    }

    /**
     * @param ctx
     * @param ebnfSuffixContext
     * @return
     */
    private boolean isChainRule(ParseTree ctx, EbnfSuffixContext ebnfSuffixContext) {
        // if (ctx.getText().equals("IDENTIFIER")
        // && getParent(ctx, ParserRuleSpecContext.class).RULE_REF().getText().equals("qualifiedName")) {
        // System.out.println("asdf");
        // }

        if (ebnfSuffixContext == null || ebnfSuffixContext.equals("")) {
            // simple case
            AltListContext parentAltList = getParent(ctx, AltListContext.class);
            // just in case of top level alternative list. The top level alternatives are indicated by
            // RuleListContext rather than AltListContext. AltListContexts are just intermediate alternative
            // lists
            if (countSiblings(ctx) == 1 && parentAltList == null) {
                return true;
            }

            if (!TRANSFORM_POTENTIAL_CHAIN_RULES) {
                boolean isPotentialChainRule = true;
                ElementContext elem = getParent((RuleContext) ctx, ElementContext.class);

                do {
                    for (ParseTree sibling : elem.getParent().children) {
                        if (!elem.equals(sibling)) {
                            ebnfSuffixContext = getEbnfSuffix(sibling);
                            isPotentialChainRule = isPotentialChainRule && ebnfSuffixContext != null
                                && ebnfSuffixContext.getText().matches("\\?|\\*");
                        }
                    }

                    elem = getParent(elem, ElementContext.class);
                } while (elem != null);

                if (isPotentialChainRule) {
                    // check if it is not first elem of list pattern: elem (SEP elem)*
                    elem = getParent((RuleContext) ctx, ElementContext.class);
                    List<ParseTree> children = elem.getParent().children;
                    if (children.size() == 2) {
                        String elemName = children.get(0).getText();
                        ParseTree blockElem = children.get(1);
                        EbnfSuffixContext suffix = getEbnfSuffix(blockElem);
                        if (suffix != null && suffix.getText().equals("*")) {
                            if (blockElem.getChild(0) instanceof EbnfContext
                                && blockElem.getChild(0).getChild(0) instanceof BlockContext
                                && blockElem.getChild(0).getChild(0).getChildCount() == 3
                                && blockElem.getChild(0).getChild(0).getChild(1) instanceof AltListContext) {
                                // ( AltListContext )
                                AltListContext altList = (AltListContext) blockElem.getChild(0).getChild(0).getChild(1);
                                if (altList.getChild(0) instanceof AlternativeContext
                                    && altList.getChild(0).getChildCount() == 2) {
                                    if (altList.getChild(0).getChild(1).getText().equals(elemName)) {
                                        // ignore this case to allow also the first element of a list to be
                                        // replaced by a placeholder
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
                return isPotentialChainRule;
            }
        }

        return false;

    }

    /**
     * @param sibling
     * @return
     */
    private EbnfSuffixContext getEbnfSuffix(ParseTree sibling) {
        EbnfSuffixContext ebnfSuffixContext;
        if (sibling instanceof ElementContext) {
            ElementContext siblingElement = (ElementContext) sibling;
            ebnfSuffixContext = siblingElement.ebnfSuffix();
            if (ebnfSuffixContext == null && siblingElement.ebnf() != null
                && siblingElement.ebnf().blockSuffix() != null) {
                ebnfSuffixContext = siblingElement.ebnf().blockSuffix().ebnfSuffix();
            }
        } else {
            ebnfSuffixContext = null;
        }
        return ebnfSuffixContext;
    }

    private int countSiblings(ParseTree ctx) {
        int elementCount = 0;
        ElementContext elementCtx = getParent(ctx, ElementContext.class);
        for (ParseTree sibling : elementCtx.getParent().children) {
            if (sibling instanceof ElementContext) {
                for (ParseTree elementChild : ((ElementContext) sibling).children) {
                    if (elementChild instanceof AtomContext || elementChild instanceof LabeledElementContext
                        || elementChild instanceof EbnfContext) {
                        elementCount++;
                    }
                }
            }
        }
        return elementCount;
    }

    private <PARENT extends ParserRuleContext> PARENT getParent(ParseTree ctx, Class<PARENT> parentClass) {

        ParseTree parent = ctx.getParent();
        while (parent != null) {
            if (parentClass.isAssignableFrom(parent.getClass())) {
                return (PARENT) parent;
            }
            parent = parent.getParent();
        }
        return null;
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
                    rewriter.replace(ctx.stop, tokenName + " "); // normalize grammar

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
            EbnfSuffixContext ebnfSuffixContext = getParent(ctx, ElementContext.class).ebnfSuffix();
            if (!isChainRule(ctx, ebnfSuffixContext)) {
                extendTerminal(ctx, tokenName);
            }
        } else if (tokenName != null && isInParserRule && !selectedRules.contains(tokenName)
            && multiLexerRules.contains(tokenName)) {
            // add () to allow condition and loop extension if not fixed token
            // rewriter.insertBefore(ctx.start, "(");
            // rewriter.insertAfter(ctx.stop, ")");
        }

    }

    private void extendRuleRef(RulerefContext ctx, String cardinality) {
        String ruleName = ctx.getText();
        rewriteRuleRef(ctx, cardinality, ruleName);
    }

    private void rewriteRuleRef(ParserRuleContext ctx, String cardinality, String ruleName) {
        String phRuleName;
        switch (cardinality) {
        case "":
            phRuleName = grammarSpec.getMetaLangParserRulePrefix() + ruleName;
            break;
        case "?":
            phRuleName = grammarSpec.getOptPhParserRuleName(ruleName);
            break;
        case "*":
            phRuleName = grammarSpec.getStarPhParserRuleName(ruleName);
            break;
        case "+":
            phRuleName = grammarSpec.getPlusPhParserRuleName(ruleName);
            break;
        default:
            throw new IllegalArgumentException("Unkown EBNF cardinality '" + cardinality + "'");
        }

        // remove labels as they cannot be duplicated. Might be interesting if we start to introduce
        // placeholder rules again.
        if (ctx.getParent().getParent() instanceof LabeledElementContext) {
            LabeledElementContext labeledElement = (LabeledElementContext) ctx.getParent().getParent();
            for (int i = 0; i < labeledElement.getChildCount(); i++) {
                ParseTree c = labeledElement.getChild(i);
                if (c instanceof IdentifierContext && i + 2 < labeledElement.getChildCount()
                    && labeledElement.getChild(i + 1).getText().equals("=")
                    && labeledElement.getChild(i + 2).equals(ctx.getParent())) {
                    rewriter.replace(labeledElement.start, labeledElement.stop,
                        "(" + phRuleName + " | " + ruleName + ")");
                    // rewriter.insertBefore(labeledElement.start, "(" + c.getText() + "=" + phRuleName + " |
                    // ");
                    // rewriter.insertAfter(labeledElement.stop, ")");
                }
            }
        } else {
            rewriter.insertBefore(ctx.start, "(" + phRuleName + " | ");
            rewriter.insertAfter(ctx.stop, ")");
        }
        usedPlaceholderRules.add(phRuleName);
    }

    private void extendTerminal(TerminalContext ctx, String tokenName) {
        EbnfSuffixContext ebnfSuffixContext;
        if (ctx.parent.parent instanceof ElementContext) {
            ebnfSuffixContext = ((ElementContext) ctx.parent.parent).ebnfSuffix();
        } else {
            ebnfSuffixContext = ((ElementContext) ctx.parent.parent.parent).ebnfSuffix();
        }
        String ebnfSuffix = ebnfSuffixContext != null ? ebnfSuffixContext.getText() : "";
        rewriteRuleRef(ctx, ebnfSuffix, tokenName);
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

}
