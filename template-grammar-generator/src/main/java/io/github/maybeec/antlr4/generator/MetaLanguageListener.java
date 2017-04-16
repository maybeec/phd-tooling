package io.github.maybeec.antlr4.generator;

import org.antlr.parser.antlr4.ANTLRv4Parser.LexerRuleSpecContext;
import org.antlr.parser.antlr4.ANTLRv4Parser.ParserRuleSpecContext;
import org.antlr.parser.antlr4.ANTLRv4ParserBaseListener;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

/**
 * A class to collect information about a certain meta language
 */
public class MetaLanguageListener extends ANTLRv4ParserBaseListener {

    private TokenStream token;

    private String placeHolderRule;

    private String ifRule;

    private String ifElseRule;

    private String loopRule;

    public MetaLanguageListener(TokenStream token) {
        this.token = token;
    }

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
     */
    public String getPlaceHolderRule() {
        return placeHolderRule;
    }

    /**
     * Returns the field 'ifRule'
     * @return value of ifRule
     */
    public String getIfRule() {
        return ifRule;
    }

    /**
     * Returns the field 'ifElseRule'
     * @return value of ifElseRule
     */
    public String getIfElseRule() {
        return ifElseRule;
    }

    /**
     * Returns the field 'loop'
     * @return value of loop
     */
    public String getLoopRule() {
        return loopRule;
    }

}
