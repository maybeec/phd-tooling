package grammarExtensionTool;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr4Parser.ANTLRv4Parser.BlockContext;
import antlr4Parser.ANTLRv4Parser.EbnfContext;
import antlr4Parser.ANTLRv4Parser.GrammarSpecContext;
import antlr4Parser.ANTLRv4ParserBaseListener;

/**
 * A class to introduce conditions and loops of a given meta language into an object language grammar
 *
 * @author fkreis (20.01.2016)
 */
public class ConditionAndLoopIncluderListener extends ANTLRv4ParserBaseListener {

    private TokenStreamRewriter rewriter;

    private Map<String, String[]> oneRuleMap;

    private Map<String, String[]> questionRuleMap;

    private Map<String, String[]> starRuleMap;

    private Map<String, String[]> ifLoopRuleMap;

    private int nameSuffix;

    private GrammarSpec grammarSpec;

    /**
     * @param tokens
     * @param grammarSpec
     * @author fkreis (06.05.2016)
     */
    public ConditionAndLoopIncluderListener(CommonTokenStream tokens, GrammarSpec grammarSpec) {
        rewriter = new TokenStreamRewriter(tokens);
        oneRuleMap = new HashMap<String, String[]>();
        questionRuleMap = new HashMap<String, String[]>();
        starRuleMap = new HashMap<String, String[]>();
        ifLoopRuleMap = new HashMap<String, String[]>();
        nameSuffix = 0;

        this.grammarSpec = grammarSpec;

    }

    /**
     * {@inheritDoc}
     * @author fkreis (20.01.2016)
     */
    @Override
    public void exitGrammarSpec(GrammarSpecContext ctx) {
        // rename grammar
        rewriter.replace(ctx.id().stop, grammarSpec.getNewGrammarName());

        // insert new Rules
        for (String key : oneRuleMap.keySet()) {
            rewriter.insertAfter(ctx.stop, "\n" + oneRuleMap.get(key)[0] + ": " + oneRuleMap.get(key)[1]
                + ";");
        }
        for (String key : questionRuleMap.keySet()) {
            rewriter.insertAfter(ctx.stop,
                "\n" + questionRuleMap.get(key)[0] + ": " + questionRuleMap.get(key)[1] + ";");
        }
        for (String key : starRuleMap.keySet()) {
            rewriter.insertAfter(ctx.stop, "\n" + starRuleMap.get(key)[0] + ": " + starRuleMap.get(key)[1]
                + ";");
        }
        for (String key : ifLoopRuleMap.keySet()) {
            rewriter.insertAfter(ctx.stop, "\n" + ifLoopRuleMap.get(key)[0] + ": "
                + ifLoopRuleMap.get(key)[1] + ";");
        }

    }

    /**
     * {@inheritDoc}
     * @author fkreis (01.03.2016)
     */
    @Override
    public void exitBlock(BlockContext ctx) {

        String originalBlock = retrieveBlockWithSpaces(ctx);

        ParserRuleContext ebnfParent = ctx.getParent();

        if (ebnfParent instanceof EbnfContext) {

            if (((EbnfContext) ebnfParent).blockSuffix() == null) {

                String[] rule = oneRuleMap.get(originalBlock);
                String ruleName;

                // if there is no existing rule create new rule
                if (rule == null) {
                    ruleName = createRuleName(originalBlock, "One");
                    String body = "(" + originalBlock + " | " + ruleName + ")";
                    String newRuleContent = createOneRuleContent(body);
                    oneRuleMap.put(originalBlock, new String[] { ruleName, newRuleContent });
                } else {
                    ruleName = rule[0];
                }

                rewriter.insertBefore(ctx.start, "(");
                rewriter.insertAfter(ctx.stop, " | " + ruleName + ")");

            } else if (((EbnfContext) ebnfParent).blockSuffix().getText().equals("?")) {

                String[] rule = questionRuleMap.get(originalBlock);
                String ruleName;

                // if there is no existing rule create new rule
                if (rule == null) {
                    ruleName = createRuleName(originalBlock, "Question");
                    String body = "(" + originalBlock + "? | " + ruleName + "?)";
                    String newRuleContent = createQuestionRuleContent(body);

                    questionRuleMap.put(originalBlock, new String[] { ruleName, newRuleContent });
                } else {
                    ruleName = rule[0];
                }

                rewriter.insertBefore(ctx.start, "(");
                rewriter.insertAfter(ctx.stop, " | " + ruleName + ")");

            } else if (((EbnfContext) ebnfParent).blockSuffix().getText().equals("*")) {

                String[] rule = starRuleMap.get(originalBlock);
                String ruleName;

                // if there is no existing rule create new rule
                if (rule == null) {
                    ruleName = createRuleName(originalBlock, "Star");
                    String body = "(" + originalBlock + "* | " + ruleName + "*)";
                    String newRuleContent = createStarRuleContent(body);

                    starRuleMap.put(originalBlock, new String[] { ruleName, newRuleContent });
                } else {
                    ruleName = rule[0];
                }

                rewriter.insertBefore(ctx.start, "(");
                rewriter.insertAfter(ctx.stop, " | " + ruleName + ")");

            } else if (((EbnfContext) ebnfParent).blockSuffix().getText().equals("+")) {

                // first part
                String[] ifLoopRule = ifLoopRuleMap.get(originalBlock);
                String ifLoopRuleName;
                // if there is no existing rule create new rule
                if (ifLoopRule == null) {
                    ifLoopRuleName = createRuleName(originalBlock, "IfLoop");
                    String body = "(" + originalBlock + "* | " + ifLoopRuleName + "*)";
                    String newRuleContent = createIfLoopRuleContent(body);

                    ifLoopRuleMap.put(originalBlock, new String[] { ifLoopRuleName, newRuleContent });
                } else {
                    ifLoopRuleName = ifLoopRule[0];
                }

                // second part
                String[] oneRule = oneRuleMap.get(originalBlock + "Plus");
                String oneRuleName;
                // if there is no existing rule create new rule
                if (oneRule == null) {
                    oneRuleName = createRuleName(originalBlock, "OnePlus");
                    String body = "(" + originalBlock + " | " + oneRuleName + "+)";
                    String newRuleContent = createOneRuleContent(body);

                    oneRuleMap.put(originalBlock + "Plus", new String[] { oneRuleName, newRuleContent });
                } else {
                    oneRuleName = oneRule[0];
                }

                // third part
                String[] starRule = starRuleMap.get(originalBlock);
                String starRuleName;
                // if there is no existing rule create new rule
                if (starRule == null) {
                    starRuleName = createRuleName(originalBlock, "Star");
                    String body = "(" + originalBlock + "* | " + starRuleName + "*)";
                    String newRuleContent = createStarRuleContent(body);

                    starRuleMap.put(originalBlock, new String[] { starRuleName, newRuleContent });
                } else {
                    starRuleName = starRule[0];
                }

                rewriter.insertBefore(ctx.start, "(" + ifLoopRuleName + "* (");
                rewriter.insertAfter(ctx.stop, " | " + oneRuleName + ") (" + originalBlock + " | "
                    + starRuleName + ")*)");

                // remove original '+'-Symbol
                rewriter.replace(((EbnfContext) ebnfParent).blockSuffix().stop, "");

            } else {
                System.out.println("Found strange Block Suffix: "
                    + ((EbnfContext) ebnfParent).blockSuffix().getText());
            }
        } else {
            System.out.println("Found Block element without ebfn parent: -" + originalBlock + "-");
        }

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
    private String retrieveBlockWithSpaces(ParseTree ctx) {
        String blockWithSpaces = "";
        if (ctx.getChildCount() == 0) {
            blockWithSpaces = ctx.getText();
        } else {
            for (int i = 0; i < ctx.getChildCount(); i++) {
                ParseTree child = ctx.getChild(i);
                blockWithSpaces += retrieveBlockWithSpaces(child) + " ";
            }
        }
        return blockWithSpaces;
    }

    /**
     * @param body
     * @return
     * @author fkreis (07.03.2016)
     */
    private String createIfLoopRuleContent(String body) {
        // String content =
        // ifStartOpen + booleanExpression + ifStartClose + ifBodyStart + body + ifBodyEnd
        //
        // + "(" + elseIfStartOpen + booleanExpression + elseIfStartClose + elseifBodyStart + body
        // + elseifBodyEnd + ")*"
        //
        // + ifEnd
        //
        // + "| " + loopStartOpen + loopCollection + loopSeparator + loopVariable + loopStartClose
        // + loopBodyStart + body + loopBodyEnd + loopEnd;

        String content =
            grammarSpec.getIfRuleDef().replaceAll("body", body) + " | "
                + grammarSpec.getLoopRuleDef().replaceAll("body", body);
        return content;
    }

    /**
     * @param body
     * @return
     * @author fkreis (07.03.2016)
     */
    private String createStarRuleContent(String body) {
        // String content =
        // ifStartOpen + booleanExpression + ifStartClose + ifBodyStart + body + ifBodyEnd
        //
        // + "(" + elseIfStartOpen + booleanExpression + elseIfStartClose + elseifBodyStart + body
        // + elseifBodyEnd + ")*"
        //
        // + "(" + elseToken + elseifBodyStart + body + elseifBodyEnd + ")?"
        //
        // + ifEnd
        //
        // + "| " + loopStartOpen + loopCollection + loopSeparator + loopVariable + loopStartClose
        // + loopBodyStart + body + loopBodyEnd + loopEnd;

        String content =
            grammarSpec.getIfRuleDef().replaceAll("body", body) + " | "
                + grammarSpec.getIfElseRuleDef().replaceAll("body", body) + " | "
                + grammarSpec.getLoopRuleDef().replaceAll("body", body);
        return content;
    }

    /**
     * @param body
     * @return
     * @author fkreis (07.03.2016)
     */
    private String createQuestionRuleContent(String body) {
        // String content =
        // ifStartOpen + booleanExpression + ifStartClose + ifBodyStart + body + ifBodyEnd
        //
        // + "(" + elseIfStartOpen + booleanExpression + elseIfStartClose + elseifBodyStart + body
        // + elseifBodyEnd + ")*"
        //
        // + "(" + elseToken + elseifBodyStart + body + elseifBodyEnd + ")?"
        //
        // + ifEnd;

        String content =
            grammarSpec.getIfRuleDef().replaceAll("body", body) + " | "
                + grammarSpec.getIfElseRuleDef().replaceAll("body", body);

        return content;
    }

    /**
     * @param body
     * @return
     * @author fkreis (07.03.2016)
     */
    private String createOneRuleContent(String body) {
        // String content =
        // ifStartOpen + booleanExpression + ifStartClose + ifBodyStart + body + ifBodyEnd
        //
        // + "(" + elseIfStartOpen + booleanExpression + elseIfStartClose + elseifBodyStart + body
        // + elseifBodyEnd + ")*"
        //
        // + elseToken + elseifBodyStart + body + elseifBodyEnd
        //
        // + ifEnd;
        String content = grammarSpec.getIfElseRuleDef().replaceAll("body", body);
        return content;
    }

    /**
     *
     * @return
     * @author fkreis (04.03.2016)
     * @param originalRule
     * @param suffix
     */
    private String createRuleName(String originalRule, String suffix) {

        String ruleName =
            grammarSpec.getUniqueStart()
                + originalRule.replaceAll("\\|", "Or").replaceAll(" ", "").replaceAll("\\(", "LParen")
                    .replaceAll("\\)", "RParen").replaceAll("\\?", "Question").replaceAll("\\*", "Star")
                    .replaceAll("\\+", "Plus") + suffix;

        if (ruleName.length() > 130) {
            System.out.println("Name too long: " + ruleName.length() + ruleName);
            ruleName = grammarSpec.getUniqueStart() + "newRulexXXx" + nameSuffix;
            nameSuffix++;
        }

        return ruleName;
    }
}
