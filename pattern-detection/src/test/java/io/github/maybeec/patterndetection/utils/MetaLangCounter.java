package io.github.maybeec.patterndetection.utils;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MetaLangCounter implements ParseTreeListener {

    private Vocabulary vocabulary;

    private int placeholderCount = 0;

    private int ifCount = 0;

    private int loopCount = 0;

    public MetaLangCounter(Vocabulary vocabulary) {
        this.vocabulary = vocabulary;
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        String tokenName = vocabulary.getSymbolicName(node.getSymbol().getType());
        if (tokenName != null && tokenName.equals("FM_PLACEHOLDER")) {
            placeholderCount++;
        } else if (tokenName != null && tokenName.equals("FM_IF")) {
            ifCount++;
        } else if (tokenName != null && tokenName.equals("FM_LIST")) {
            loopCount++;
        }
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        // TODO Auto-generated method stub

    }

    public int getPlaceholderCount() {
        return placeholderCount;
    }

    public int getIfCount() {
        return ifCount;
    }

    public int getLoopCount() {
        return loopCount;
    }
}
