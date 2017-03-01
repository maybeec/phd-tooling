package io.github.maybeec.antlr4.generator;

import org.antlr.parser.antlr4.ANTLRv4Parser.LexerRuleSpecContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.ParserRuleSpecContext;
import org.antlr.parser.antlr4.ANTLRv4ParserBaseListener;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

/**
 * A class to collect information about a certain meta language
 *
 * @author fkreis (30.06.2016)
 */
public class MetaLanguageListener extends ANTLRv4ParserBaseListener {

    /**
     *
     */
    private TokenStream token;

    /**
     *
     */
    private String placeHolderRule;

    /**
     *
     */
    private String ifRule;

    /**
     *
     */
    private String ifElseRule;

    /**
     *
     */
    private String loopRule;

    /**
     *
     * @author fkreis (30.06.2016)
     * @param token
     */
    public MetaLanguageListener(TokenStream token) {
        this.token = token;
    }

    /**
     * {@inheritDoc}
     * @author fkreis (30.06.2016)
     */
    @Override
    public void exitLexerRuleSpec(LexerRuleSpecContext ctx) {

        // derive Placeholder Rule
        if (ctx.TOKEN_REF().getText().equals("PlaceHolder")) {
            TokenStreamRewriter rewriter = new TokenStreamRewriter(token);
            rewriter.delete(0, ctx.lexerRuleBlock().start.getTokenIndex() - 1);
            rewriter.delete(ctx.stop.getTokenIndex(), token.size() - 1);
            placeHolderRule = rewriter.getText();
        }

    }

    /**
     * {@inheritDoc}
     * @author fkreis (30.06.2016)
     */
    @Override
    public void exitParserRuleSpec(ParserRuleSpecContext ctx) {

        // derive If Rule
        if (ctx.RULE_REF().getText().equals("if")) {
            TokenStreamRewriter rewriter = new TokenStreamRewriter(token);
            rewriter.delete(0, ctx.ruleBlock().start.getTokenIndex() - 1);
            rewriter.delete(ctx.stop.getTokenIndex(), token.size() - 1);
            ifRule = rewriter.getText();
        }

        // derive If Else Rule
        if (ctx.RULE_REF().getText().equals("ifElse")) {
            TokenStreamRewriter rewriter = new TokenStreamRewriter(token);
            rewriter.delete(0, ctx.ruleBlock().start.getTokenIndex() - 1);
            rewriter.delete(ctx.stop.getTokenIndex(), token.size() - 1);
            ifElseRule = rewriter.getText();
        }

        // derive Loop Rule
        if (ctx.RULE_REF().getText().equals("loop")) {
            TokenStreamRewriter rewriter = new TokenStreamRewriter(token);
            rewriter.delete(0, ctx.ruleBlock().start.getTokenIndex() - 1);
            rewriter.delete(ctx.stop.getTokenIndex(), token.size() - 1);
            loopRule = rewriter.getText();
        }

    }

    /**
     * Returns the field 'completePlaceHolderRule'
     * @return value of completePlaceHolderRule
     * @author fkreis (30.06.2016)
     */
    public String getPlaceHolderRule() {
        return placeHolderRule;
    }

    /**
     * Returns the field 'ifRule'
     * @return value of ifRule
     * @author fkreis (30.06.2016)
     */
    public String getIfRule() {
        return ifRule;
    }

    /**
     * Returns the field 'ifElseRule'
     * @return value of ifElseRule
     * @author fkreis (30.06.2016)
     */
    public String getIfElseRule() {
        return ifElseRule;
    }

    /**
     * Returns the field 'loop'
     * @return value of loop
     * @author fkreis (30.06.2016)
     */
    public String getLoopRule() {
        return loopRule;
    }

}
