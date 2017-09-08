package io.github.maybeec.patterndetection.matcher;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import io.github.maybeec.patterndetection.entity.AstPath;
import io.github.maybeec.patterndetection.entity.AstPathCollection;
import io.github.maybeec.patterndetection.entity.AstPathList;

/**
 *
 */
public class AstToPathTransformer implements ParseTreeListener {

    /** Non ordered productions. Might be served as input later on */
    private static final Set<String> _nonOrderedNodes = new HashSet<>(Arrays.asList(new String[] { "ImportDeclaration",
        "InterfaceMemberDeclaration", "ClassMemberDeclaration", "TypeDeclaration" }));

    /** Non ordered node class names, prepared on the basis of {@value #_nonOrderedNodes} */
    private static Set<String> nonOrderedNodes;

    static {
        nonOrderedNodes = new HashSet<>();
        for (String production : _nonOrderedNodes) {
            nonOrderedNodes.add(production + "Context");
            nonOrderedNodes.add("Fm_" + production + "Context");
            nonOrderedNodes.add("Fm_" + production + "OptContext");
            nonOrderedNodes.add("Fm_" + production + "StarContext");
            nonOrderedNodes.add("Fm_" + production + "PlusContext");
        }
    }

    private AstPathList paths;

    private Stack<AstPathCollection> current = new Stack<>();

    private Stack<AstPath> lastNode = new Stack<>();

    private Stack<Boolean> toPop = new Stack<>();

    private Vocabulary vocabulary;

    /**
     *
     */
    public AstToPathTransformer(Vocabulary vocabulary) {
        this.vocabulary = vocabulary;
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        current.peek()
            .add(new AstPath(vocabulary.getSymbolicName(node.getSymbol().getType()), node.getText(), lastNode.peek()));
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        throw new IllegalStateException("Ast contains an error node: " + node.getText());
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        String simpleName = ctx.getClass().getSimpleName();

        if (lastNode.isEmpty()) {
            lastNode.push(new AstPath(simpleName, ctx.getText(), null));
            paths = new AstPathList(simpleName, true);
            current.push(paths);
            toPop.push(true);
        } else {
            lastNode.push(new AstPath(simpleName, ctx.getText(), lastNode.peek()));
        }

        if (nonOrderedNodes.contains(simpleName)) {
            AstPathList unorderedPaths = new AstPathList(simpleName, false);
            current.peek().add(unorderedPaths);
            current.push(unorderedPaths);
            toPop.push(true);
        } else {
            toPop.push(false);
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        lastNode.pop();
        if (toPop.pop()) {
            current.pop();
        }
    }

    public AstPathList getPaths() {
        return paths;
    }

}
