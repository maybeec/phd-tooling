package io.github.maybeec.patterndetection.matcher;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.misc.MultiMap;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import io.github.maybeec.patterndetection.entity.AstElem;
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

    private AstPathList<AstElem> paths;

    private Stack<AstPathCollection<AstElem>> currentCollection = new Stack<>();

    private Stack<AstPath> lastNode = new Stack<>();

    private Stack<Boolean> toPop = new Stack<>();

    private Vocabulary vocabulary;

    /** Terminal symbols of the smallest entry to be detected. */
    private Set<String> detectionTerminals;

    private boolean withinAtomarPathSet = false;

    private boolean withinListPattern = false;

    /** Found list pattern occurrences mapping list element and separator to list parent rule name */
    private MultiMap<String, String> listPatternRules;

    /**
     *
     */
    public AstToPathTransformer(Vocabulary vocabulary, Set<String> detectionTerminals,
        MultiMap<String, String> listPatternRules) {
        this.vocabulary = vocabulary;
        this.detectionTerminals = detectionTerminals;
        this.listPatternRules = listPatternRules;
    }

    @Override
    public void visitTerminal(TerminalNode node) {

        String symbolicName = vocabulary.getSymbolicName(node.getSymbol().getType());
        if (!withinAtomarPathSet) {
            AstPathList<AstElem> orderedPaths = new AstPathList<>("<Atom>", true);
            orderedPaths.setAtomic(true);
            currentCollection.peek().add(orderedPaths);
            currentCollection.push(orderedPaths);
            withinAtomarPathSet = true;
        }

        String nameToTest = symbolicName;
        String parentNameToTest = convertToGrammarRuleName(node.getParent());
        if (symbolicName.equals("FM_PLACEHOLDER")) {
            nameToTest = convertToGrammarRuleName(node.getParent());
            parentNameToTest = convertToGrammarRuleName(node.getParent().getParent());
        }
        if (!withinListPattern && listPatternRules.containsKey(nameToTest)
            && listPatternRules.get(nameToTest).contains(parentNameToTest)) {
            AstPathList<AstElem> orderedPaths = new AstPathList<>("<ListPattern>", true);
            orderedPaths.setListPattern(true);
            currentCollection.peek().add(orderedPaths);
            currentCollection.push(orderedPaths);
            withinListPattern = true;
        } else if (withinListPattern && (!listPatternRules.containsKey(nameToTest)
            || !listPatternRules.get(nameToTest).contains(parentNameToTest))) {
            currentCollection.pop();
            withinListPattern = false;
        }

        currentCollection.peek().add(new AstPath(symbolicName, node.getText(), lastNode.peek()));

        if (detectionTerminals.contains(node.getText())) {
            withinAtomarPathSet = false;
            currentCollection.pop(); // works on the assumption, that no currentCollection.pop is called
                                     // before in #enterEveryRule
        }
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        throw new IllegalStateException("Ast contains an error node: " + node.getText());
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        String simpleName = ctx.getClass().getSimpleName();

        if (lastNode.isEmpty()) {
            // initialization
            lastNode.push(new AstPath(simpleName, ctx.getText(), null));
            paths = new AstPathList<>(simpleName, true);
            currentCollection.push(paths);
            toPop.push(true);
        } else {
            // create new path elem for last node
            lastNode.push(new AstPath(simpleName, ctx.getText(), lastNode.peek()));
        }

        if (nonOrderedNodes.contains(simpleName)) {
            // create new list of nodes to separate them as a block, which itself is unordered to its siblings
            AstPathList<AstElem> unorderedPaths = new AstPathList<>(simpleName, false);
            currentCollection.peek().add(unorderedPaths);
            currentCollection.push(unorderedPaths);
            toPop.push(true);
        } else {
            toPop.push(false);
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        lastNode.pop();
        if (toPop.pop()) {
            currentCollection.pop();
        }
    }

    public AstPathList<AstElem> getPaths() {
        return paths;
    }

    private String convertToGrammarRuleName(ParseTree node) {
        String basicName = node.getClass().getSimpleName().replace("Context", "");
        basicName = Character.toLowerCase(basicName.charAt(0)) + basicName.substring(1);
        return basicName;
    }

}
