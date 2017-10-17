package io.github.maybeec.patterndetection.matcher;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.misc.MultiMap;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import io.github.maybeec.patterndetection.entity.AstPath;
import io.github.maybeec.patterndetection.entity.AstPathCollection;
import io.github.maybeec.patterndetection.entity.AstPathList;
import io.github.maybeec.patterndetection.entity.ListType;

/**
 *
 */
public class AstToPathTransformer implements ParseTreeListener {

    /** Non ordered node class names */
    private Set<String> nonOrderedNodes;

    private AstPathList paths;

    // private Stack<AstPathCollection> currentCollection = new Stack<>();
    private Deque<AstPathCollection> currentCollection = new ArrayDeque<>();

    private Deque<AstPath> lastNode = new ArrayDeque<>();

    private Deque<AstPathCollection> lastPotentialMetaElseLocation = new ArrayDeque<>();

    private Deque<Boolean> toPop = new ArrayDeque<>();

    private Vocabulary vocabulary;

    /** Terminal symbols of the smallest entry to be detected. */
    private Set<String> detectionTerminals;

    /** Found list pattern occurrences mapping list element and separator to list parent rule name */
    private MultiMap<String, String> listPatternRules;

    /**
     *
     */
    public AstToPathTransformer(Vocabulary vocabulary, Set<String> detectionTerminals,
        MultiMap<String, String> listPatternRules, Set<String> nonOrderedNodes) {
        this.vocabulary = vocabulary;
        this.detectionTerminals = detectionTerminals;
        this.listPatternRules = listPatternRules;
        this.nonOrderedNodes = nonOrderedNodes;
    }

    @Override
    public void visitTerminal(TerminalNode node) {

        String symbolicName = vocabulary.getSymbolicName(node.getSymbol().getType());

        String nameToTest = symbolicName;
        String parentNameToTest = convertToGrammarRuleName(node.getParent());
        if (symbolicName.equals("FM_PLACEHOLDER")) {
            nameToTest = convertToGrammarRuleName(node.getParent());
            parentNameToTest = convertToGrammarRuleName(node.getParent().getParent());
        }
        if (!currentCollection.peek().isListPattern() && listPatternRules.containsKey(nameToTest)
            && listPatternRules.get(nameToTest).contains(parentNameToTest)) {
            AstPathList orderedPaths = new AstPathList(ListType.LIST_PATTERN, "<ListPattern>");
            currentCollection.peek().add(orderedPaths);
            currentCollection.push(orderedPaths);
        } else if (currentCollection.peek().isListPattern() && (!listPatternRules.containsKey(nameToTest)
            || !listPatternRules.get(nameToTest).contains(parentNameToTest))) {
            currentCollection.pop();
        }

        if ("FM_IF".equals(nameToTest)) {
            // TODO check if previous token is else to change again the type to optional
            AstPathList optional = new AstPathList(ListType.OPTIONAL, node.getText());
            currentCollection.peek().add(optional);
            currentCollection.push(optional);
            lastPotentialMetaElseLocation.push(optional);
            AstPathList atomic = new AstPathList(ListType.ATOMIC, /* "<if-then-body>" */node.getText());
            atomic.setIsMetaLang(true);
            currentCollection.peek().add(atomic);
            currentCollection.push(atomic);
        } else if ("FM_LIST_CLOSE".equals(nameToTest) || "FM_IF_CLOSE".equals(nameToTest)) {
            currentCollection.pop();
            currentCollection.pop();
            lastPotentialMetaElseLocation.pop();
        } else if ("FM_ELSE".equals(nameToTest)) {
            lastPotentialMetaElseLocation.peek().setType(ListType.ALTERNATIVE);
            currentCollection.pop();
            AstPathList atomic = new AstPathList(ListType.ATOMIC, "<else-body>");
            atomic.setIsMetaLang(true);
            currentCollection.peek().add(atomic);
            currentCollection.push(atomic);
        } else if ("FM_ELSE_IF".equals(nameToTest)) {
            currentCollection.pop();
            AstPathList atomic = new AstPathList(ListType.ATOMIC, /* "<else-if-body>" */ node.getText());
            atomic.setIsMetaLang(true);
            currentCollection.peek().add(atomic);
            currentCollection.push(atomic);
        } else if ("FM_LIST".equals(nameToTest)) {
            AstPathList optional = new AstPathList(ListType.OPTIONAL, node.getText());
            currentCollection.peek().add(optional);
            currentCollection.push(optional);
            lastPotentialMetaElseLocation.push(optional);
            AstPathList atomic = new AstPathList(ListType.ARBITRARY, /* "<loop-body>" */ node.getText());
            currentCollection.peek().add(atomic);
            currentCollection.push(atomic);
        } else {
            currentCollection.peek().add(new AstPath(symbolicName, node.getText(), lastNode.peek()));
        }
    }

    /**
     * @return
     */
    private AstPathCollection getParentMetaLangCollection() {
        for (Iterator<AstPathCollection> it = currentCollection.iterator(); it.hasNext();) {
            AstPathCollection next = it.next();
            if (next.isMetaLang()) {
                return next;
            }
        }
        return null;
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        throw new IllegalStateException("Ast contains an error node: " + node.getText());
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        String simpleName = ctx.getClass().getSimpleName();

        // initialization
        if (lastNode.isEmpty()) {
            // initialization
            lastNode.push(new AstPath("<<ROOT>>", "<<ROOT>>", null));
            paths = new AstPathList(ListType.ORDERED, "<<ROOT>>");
            currentCollection.push(paths);
            toPop.push(true);
        } else {
            // create new path elem for last node
            lastNode.push(new AstPath(simpleName, ctx.getText(), lastNode.peek()));
        }

        // regular
        if (nonOrderedNodes.contains(simpleName)) {
            // create new list of nodes to separate them as a block, which itself is unordered to its siblings
            AstPathList unorderedPaths = new AstPathList(ListType.NONORDERED, simpleName);
            if (simpleName.matches("Fm_(.+)(Opt|Star|Plus)?Context")) {
                unorderedPaths.setIsMetaLang(true);
            }
            currentCollection.peek().add(unorderedPaths);
            currentCollection.push(unorderedPaths);
            toPop.push(true);
            // } else if (!currentCollection.peek().is(ListType.LIST_PATTERN)
            // && simpleName.matches("Fm_(.+)(Opt|Star|Plus)?Context")) {
            // AstPathList alternativePaths = new AstPathList(ListType.ORDERED, simpleName);
            // alternativePaths.setIsMetaLang(true);
            // currentCollection.peek().add(alternativePaths);
            // currentCollection.push(alternativePaths);
            // toPop.push(true);
            // } else if (simpleName.matches("Fm_(.+)ContextOpt")) {
            // AstPathList optionalPaths = new AstPathList(ListType.OPTIONAL, simpleName);
            // currentCollection.peek().add(optionalPaths);
            // currentCollection.push(optionalPaths);
            // toPop.push(true);
            // } else if (simpleName.matches("Fm_(.+)ContextStar")) {
            // AstPathList arbitraryPaths = new AstPathList(ListType.ARBITRARY, simpleName);
            // currentCollection.peek().add(arbitraryPaths);
            // currentCollection.push(arbitraryPaths);
            // toPop.push(true);
            // } else if (simpleName.matches("Fm_(.+)ContextPlus")) {
            // AstPathList atLeastOnePaths = new AstPathList(ListType.AT_LEAST_ONE, simpleName);
            // currentCollection.peek().add(atLeastOnePaths);
            // currentCollection.push(atLeastOnePaths);
            // toPop.push(true);
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

    public AstPathList getPaths() {
        return paths;
    }

    private String convertToGrammarRuleName(ParseTree node) {
        String basicName = node.getClass().getSimpleName().replace("Context", "");
        basicName = Character.toLowerCase(basicName.charAt(0)) + basicName.substring(1);
        return basicName;
    }

}
