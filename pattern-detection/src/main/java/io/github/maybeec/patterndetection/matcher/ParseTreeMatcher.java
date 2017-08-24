package io.github.maybeec.patterndetection.matcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import io.github.maybeec.antlr4.parser.ListPatternCollector;
import io.github.maybeec.patterndetection.exception.NoMatchException;
import io.github.maybeec.patterndetection.exception.NotYetImplementedException;

/**
 * Parse tree matcher, which tries to find a template CST in an application CST by finding one valid
 * substitution of all placeholders of the template.
 */
public class ParseTreeMatcher {

    /** Non ordered productions. Might be served as input later on */
    private static final Set<String> _nonOrderedNodes =
        new HashSet<>(Arrays.asList(new String[] { "ImportDeclaration" }));

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

    /** Unordered nodes, which have been matched already */
    private Set<ParseTree> coveredUnorderedNodes = new HashSet<>();

    /** Current pointer of the template CST */
    private ParseTree templatePointer;

    /** Current pointer of the application CST */
    private ParseTree appPointer;

    /** Root of the template CST */
    private ParseTree templatePointerInit;

    /** Root of the application CST */
    private ParseTree appPointerInit;

    /** Visited nodes */
    private Set<ParseTree> visited = new HashSet<>();

    /** All token substitution covered so far */
    private Map<String, Set<String>> tokenSubstituitions = new HashMap<>();

    /** Currently selected token substitutions (matching token text to substitution string) */
    private Map<String, String> selectedSubstitutions = new HashMap<>();

    /** Number of tokens of the selected substitution for each token (key = token text) */
    private Map<String, Integer> selectedSubstitutionTokenCount = new HashMap<>();

    /** Vocabulary of the parser to get the token names from */
    private Vocabulary parserVocabulary;

    /** Decision points to may get back to during backtracking. */
    private Stack<MatcherState> decisionPoints = new Stack<>();

    /** List patterns in the underlying grammar. See {@link ListPatternCollector} for more details */
    private Map<String, String> listPatterns;

    /**
     * Creates a new instance of the matcher.
     * @param templateCST
     *            template CST root
     * @param applicationFileCST
     *            application CST root
     * @param parserVocabulary
     *            vocabulary of the parser to resolve token names from.
     * @param listPatterns
     *            list patterns
     */
    public ParseTreeMatcher(ParseTree templateCST, ParseTree applicationFileCST, Vocabulary parserVocabulary,
        Map<String, String> listPatterns) {
        templatePointer = templateCST;
        appPointer = applicationFileCST;
        templatePointerInit = templateCST;
        appPointerInit = applicationFileCST;
        this.parserVocabulary = parserVocabulary;
        this.listPatterns = listPatterns;
    }

    /**
     * Runs the detection on {@link #templatePointer} and {@link #appPointer} while retrieving the initial
     * state from the given parameters.
     * @param tokenSubstitutions
     *            {@link #tokenSubstituitions}
     * @param selectedSubstitutions
     *            {@link #selectedSubstitutions}
     * @param selectedSubstitutionTokenCount
     *            {@link #selectedSubstitutionTokenCount}
     * @return the substitution values for each placeholder. Throws a {@link NoMatchException} in case that no
     *         valid substitution could be found to match the template against the application.
     */
    private Map<String, String> detect(Map<String, Set<String>> tokenSubstitutions,
        Map<String, String> selectedSubstitutions, Map<String, Integer> selectedSubstitutionTokenCount) {
        tokenSubstituitions = tokenSubstitutions;
        this.selectedSubstitutions = selectedSubstitutions;
        this.selectedSubstitutionTokenCount = selectedSubstitutionTokenCount;
        return detect();
    }

    /**
     * @see #detect(Map, Map, Map)
     */
    @SuppressWarnings("javadoc")
    public Map<String, String> detect() {
        if (!appPointer.getClass().equals(templatePointer.getClass())) {
            throw new NoMatchException("NO MATCH AT ROOT");
        }

        appPointer = stepDown(appPointer, false);
        templatePointer = stepDown(templatePointer, false);

        decisionPoints.push(new MatcherState(selectedSubstitutions, selectedSubstitutionTokenCount, appPointer,
            templatePointer, visited, coveredUnorderedNodes));
        boolean backtracking = false;
        while (true) {
            try {
                while (LA(appPointer, 1, false) != null && LA(templatePointer, 1, false) != null) {

                    templatePointer = skipAlreadyCoveredUnorderedNodes(templatePointer);
                    appPointer = skipAlreadyCoveredUnorderedNodes(appPointer);

                    if ((nonOrderedNodes.contains(appPointer.getClass().getSimpleName())
                        || nonOrderedNodes.contains(templatePointer.getClass().getSimpleName()))
                        && isOfSameProduction(appPointer, templatePointer)) {

                        Map<ParseTree, ParseTree> matches = new HashMap<>();
                        for (ParseTree templateChild : ((ParserRuleContext) templatePointer.getParent()).children) {
                            if (nonOrderedNodes.contains(templateChild.getClass().getSimpleName())) {
                                ParseTree match = null;
                                // List<ParseTree> matchesWithConflictingSubstitutions = new ArrayList<>();
                                for (ParseTree appChild : ((ParserRuleContext) appPointer.getParent()).children) {
                                    try {
                                        if (!coveredUnorderedNodes.contains(appChild) // match child just once
                                            && nonOrderedNodes.contains(appChild.getClass().getSimpleName())
                                            && isOfSameProduction(appChild, templateChild)) {

                                            new ParseTreeMatcher(templateChild, appChild, parserVocabulary,
                                                listPatterns).detect(tokenSubstituitions, selectedSubstitutions,
                                                    selectedSubstitutionTokenCount);
                                            match = appChild;
                                            break;
                                        }
                                    } catch (NoMatchException e) {
                                        // ignore as we may match another paring
                                    }
                                }
                                if (match != null) {
                                    matches.put(templateChild, match);
                                    coveredUnorderedNodes.add(templateChild);
                                    coveredUnorderedNodes.add(match);
                                } else {
                                    throw new NoMatchException("No match found for "
                                        + templateChild.getClass().getSimpleName() + " :: " + templateChild.getText());
                                }
                            }
                        }
                        continue;
                    }

                    if (templatePointer.getClass().equals(appPointer.getClass())) {
                        if (templatePointer instanceof TerminalNodeImpl) {
                            if (!templatePointer.getText().equals(appPointer.getText())) {
                                throw new NoMatchException("Could not match template['" + templatePointer.getText()
                                    + "'], app['" + appPointer.getText() + "']");
                            }
                            System.out.println("Consume template['" + templatePointer.getText() + "'] and app['"
                                + appPointer.getText() + "']");
                        } else {
                            // System.out.println("Consume template['" +
                            // templatePointer.getClass().getSimpleName()
                            // + "', '" + templatePointer.getText() + "'] and app['"
                            // + appPointer.getClass().getSimpleName() + "', '" + appPointer.getText() +
                            // "']");
                        }
                        appPointer = LA(appPointer, 1, false);
                        templatePointer = LA(templatePointer, 1, false);
                    } else if (templatePointer.getClass().getName().matches(".*Parser\\$Fm_.*")) {

                        if (!backtracking) {
                            decisionPoints.push(new MatcherState(selectedSubstitutions, selectedSubstitutionTokenCount,
                                appPointer, templatePointer, visited, coveredUnorderedNodes));
                        }
                        backtracking = false;

                        // ####### normal placeholder rule
                        // goto next token as we are currently facing a the template language rule
                        String templateRootProductionName = templatePointer.getClass().getSimpleName();
                        templatePointer = LA(templatePointer, 1, true);
                        ParseTree nextTemplateToken = LA(templatePointer, 1, true);
                        Token tpToken = ((TerminalNodeImpl) templatePointer).getSymbol();
                        if ("FM_PLACEHOLDER".equals(parserVocabulary.getSymbolicName(tpToken.getType()))) {

                            if (selectedSubstitutions.containsKey(tpToken.getText())) {
                                System.out.println(
                                    ">>> Take substitution from selection: template['" + templatePointer.getText()
                                        + "'], app['" + selectedSubstitutions.get(tpToken.getText()) + "'], count: "
                                        + selectedSubstitutionTokenCount.get(tpToken.getText()));
                                appPointer =
                                    LA(appPointer, selectedSubstitutionTokenCount.get(tpToken.getText()), true);
                                templatePointer = LA(templatePointer, 1, false);
                            } else {
                                ParseTree placeholderSubstitutionPointer = appPointer;
                                List<ParseTree> path = new ArrayList<>();
                                while (placeholderSubstitutionPointer != null) {
                                    path.add(placeholderSubstitutionPointer);

                                    if (path.get(path.size() - 1).getText().equals(nextTemplateToken.getText())) {
                                        String placeholderSubstitution = path.stream().limit(path.size() - 1)
                                            .filter(c -> c instanceof TerminalNodeImpl).map(t -> t.getText())
                                            .collect(Collectors.joining());

                                        // to not take decision twice after backtracking
                                        if (tokenSubstituitions.containsKey(tpToken.getText()) && tokenSubstituitions
                                            .get(tpToken.getText()).contains(placeholderSubstitution)) {
                                            placeholderSubstitutionPointer =
                                                LA(placeholderSubstitutionPointer, 1, true);
                                            continue;
                                        } else if (tokenSubstituitions.get(tpToken.getText()) == null) {
                                            tokenSubstituitions.put(tpToken.getText(), new HashSet<>());
                                        }
                                        tokenSubstituitions.get(tpToken.getText()).add(placeholderSubstitution);
                                        selectedSubstitutions.put(tpToken.getText(), placeholderSubstitution);
                                        selectedSubstitutionTokenCount.put(tpToken.getText(), path.size() - 1);

                                        System.out.println("Consume template['" + templatePointer.getText()
                                            + "'] and app['" + placeholderSubstitution + "']");
                                        System.out.println("Consume template['" + path.get(path.size() - 1).getText()
                                            + "'] and app['" + placeholderSubstitutionPointer.getText() + "']");

                                        appPointer = LA(placeholderSubstitutionPointer, 1, false);
                                        templatePointer = LA(nextTemplateToken, 1, false);
                                        break;
                                    } else {

                                        // if (templateRootProductionName.equals("Fm_qualifiedNameContext")) {
                                        // System.out.println("here");
                                        // }
                                        //
                                        // placeholderSubstitutionPointer.get

                                        // if (listPatterns.containsKey(templateRootProductionName) &&
                                        // listPatterns
                                        // .get(templateRootProductionName).equals(objectLangProduction)) {
                                        // return true;
                                        // } else
                                        if (!isOfSameProduction(placeholderSubstitutionPointer,
                                            templateRootProductionName)) {
                                            throw new NoMatchException(
                                                "Could not find valid substitution of placeholder. '"
                                                    + placeholderSubstitutionPointer.getClass().getSimpleName()
                                                    + "' is not part of placeholder production "
                                                    + templateRootProductionName);

                                        }
                                    }
                                    placeholderSubstitutionPointer = LA(placeholderSubstitutionPointer, 1, true);
                                }
                            }

                            if (appPointer == null && templatePointer == null) {
                                break; // matched whole input successfully
                            }
                        }

                        // TODO check of *Star, *Opt, *Plus
                    } else {
                        String message = "NOT YET COVERED template: " + templatePointer.getClass().getSimpleName()
                            + "['" + templatePointer.getText() + "', '" + templatePointer.toStringTree() + "'], app: "
                            + appPointer.getClass().getSimpleName() + "['" + appPointer.getText() + "', '"
                            + appPointer.toStringTree() + "']";
                        System.out.println(message);
                        throw new NotYetImplementedException(message);
                    }
                }
                break;
            } catch (NoMatchException e) {
                if (decisionPoints.isEmpty()) {
                    System.out.println("NO MATCH: " + e.getMessage());
                    throw e;
                } else {
                    MatcherState latest = decisionPoints.pop();
                    appPointer = latest.getAppPointer();
                    templatePointer = latest.getTemplatePointer();
                    selectedSubstitutions = latest.getSelectedSubstitutions();
                    selectedSubstitutionTokenCount = latest.getSelectedSubstitutionTokenCount();
                    visited = latest.getVisited();
                    coveredUnorderedNodes = latest.getCoveredUnorderedNodes();
                    System.out.println("NO MATCH: " + e.getMessage());
                    System.out.println("Backtracking...");
                    backtracking = true;
                }
            }
        }

        System.out.println("END");
        return selectedSubstitutions;

    }

    /**
     * Skips all already covered unordered nodes and sets them to be visited. Just iterates over all siblings
     * on the right side of the current node.
     * @param current
     *            node to start with
     * @return the node to continue matching with. The returned node is not covered yet.
     */
    private ParseTree skipAlreadyCoveredUnorderedNodes(ParseTree current) {
        while (coveredUnorderedNodes.contains(current)) {
            ParseTree next = nextSibling(current);
            if (next == null) { // no more siblings
                current = LA(current, 1, false);
                break;
            } else {
                if (coveredUnorderedNodes.contains(next)) {
                    visited.add(next);
                }
                current = next;
            }
        }
        return current;
    }

    /**
     * Returns the next sibling of origin or <code>null</code> if origin is the root or origin is already the
     * right most child.
     * @param origin
     *            searching the next sibling for
     * @return the sibling or <code>null</code>
     */
    private static ParseTree nextSibling(ParseTree origin) {
        ParseTree parent = origin.getParent();
        if (parent != null) {
            for (int i = 0; i < parent.getChildCount(); i++) {
                if (parent.getChild(i) == origin && i + 1 < parent.getChildCount()) {
                    return parent.getChild(i + 1);
                }
            }
        }
        return null;
    }

    /**
     * @see {@link #isOfSameProduction(ParseTree, String)}
     */
    @SuppressWarnings("javadoc")
    private boolean isOfSameProduction(ParseTree objectLangProduction, ParseTree templateProduction) {
        if (objectLangProduction.getClass() == templateProduction.getClass()) {
            return true;
        }
        return isOfSameProduction(objectLangProduction, templateProduction.getClass().getSimpleName());
    }

    /**
     * Checks whether the root node of the object language tree is of same production as the production
     * indicated by the production name of the template language node. The template language node name
     * therefore can have the prefix (F|f)m_ and one of the suffixes Opt|Star|Plus
     * @param objectLangProduction
     *            node of the object language tree to be checked
     * @param templateLangProductionName
     *            node name of the template language
     * @return true if both nodes can be considered to represent equal productions
     */
    private boolean isOfSameProduction(ParseTree objectLangProduction, String templateLangProductionName) {
        if (objectLangProduction == null) {
            return false;
        }

        if (templateLangProductionName.equals("Fm_qualifiedNameContext")) {
            System.out.println("here");
        }

        String objectLangProductionName = null;
        String objectLangProductionNameConverted = null;
        if (objectLangProduction instanceof RuleContext) {
            objectLangProductionName = objectLangProduction.getClass().getSimpleName();
            objectLangProductionNameConverted =
                "(F|f)m_" + getCapitalizedProductionName(objectLangProduction) + "(Opt|Star|Plus)?";
        } else if (objectLangProduction instanceof TerminalNodeImpl) {
            objectLangProductionName =
                parserVocabulary.getSymbolicName(((TerminalNodeImpl) objectLangProduction).getSymbol().getType());
            objectLangProductionNameConverted = "(F|f)m_" + objectLangProductionName + "(Opt|Star|Plus)?Context";
        }

        String originGrammarTemplateProductionName = templateLangProductionName;
        Pattern p = Pattern.compile("(F|f)m_(.+)Context");
        Matcher m = p.matcher(templateLangProductionName);
        if (m.matches()) {
            originGrammarTemplateProductionName = m.group(2);
        }

        if (listPatterns.containsKey(originGrammarTemplateProductionName)
            && listPatterns.get(originGrammarTemplateProductionName).equals(objectLangProductionName)) {
            return true;
        } else if (objectLangProduction instanceof RuleContext) {
            if (templateLangProductionName.matches(objectLangProductionNameConverted)) {
                return true;
            } else {
                return isOfSameProduction(objectLangProduction.getParent(), templateLangProductionName);
            }
        } else if (objectLangProduction instanceof TerminalNodeImpl) {
            if (templateLangProductionName.matches(objectLangProductionNameConverted)) {
                return true;
            } else {
                return isOfSameProduction(objectLangProduction.getParent(), templateLangProductionName);
            }
        } else {
            // should not occur (ANTLR4 4.7)
            return isOfSameProduction(objectLangProduction.getParent(), templateLangProductionName);
        }
    }

    /**
     * Returns the capitalized production name of the given tree node.
     * @param tree
     *            node
     * @return the production name
     */
    private String getCapitalizedProductionName(ParseTree tree) {
        return Character.toLowerCase(tree.getClass().getSimpleName().charAt(0))
            + tree.getClass().getSimpleName().substring(1);
    }

    /**
     * Returns the lookahead of the next <code>la</code> nodes or tokens (in case of
     * <code>toNextToken = true</code>
     * @param pointer
     *            starting point
     * @param la
     *            lookahead value
     * @param toNextToken
     *            just consider tokens
     * @return the node/token the lookahead represents
     */
    private ParseTree LA(ParseTree pointer, int la, boolean toNextToken) {
        // first lets try stepping down
        if (!visited.contains(pointer)) {
            ParseTree stepDown = stepDown(pointer, toNextToken);
            if (stepDown != null) {
                la--;
                if (la == 0) {
                    return stepDown;
                }
            }
        }

        // else try siblings, or step up
        if (pointer.getParent() != null) {
            List<ParseTree> siblings = ((ParserRuleContext) pointer.getParent()).children;
            int position = getIndex(pointer, siblings);
            while (la > 0) {
                if (position + 1 < siblings.size()) {
                    ParseTree next = siblings.get(position + 1);
                    if (!toNextToken || next.getChildCount() == 0) {
                        pointer = next;
                        la--;
                    } else {
                        pointer = stepDown(next, toNextToken);
                        la--;
                    }
                } else {
                    visited.add(pointer.getParent());
                    // early breakup if root is reached, the matching was initiated with.
                    if (pointer.getParent() == appPointerInit || pointer.getParent() == templatePointerInit) {
                        return null;
                    }
                    return LA(pointer.getParent(), la, toNextToken);
                }
            }
        } else {
            return null;
        }
        return pointer;
    }

    /**
     * Steps down the parse tree one node or even to the next token.
     * @param pointer
     *            starting point
     * @param toNextToken
     *            if we should step down until the next token
     * @return the target token/node
     */
    private ParseTree stepDown(ParseTree pointer, boolean toNextToken) {
        if (pointer.getChildCount() == 0) {
            return null;
        }

        ParseTree curr = pointer;
        do {
            curr = curr.getChild(0);
        } while (toNextToken && curr.getChildCount() > 0);
        return curr;
    }

    /**
     * Detects the index the pointer is in the list of elements.
     * @param pointer
     *            element to find
     * @param siblings
     *            list, which contains the element.
     * @return the index of the element in the list. Throws an exception if the element is not contained in
     *         the list.
     */
    private int getIndex(ParseTree pointer, List<ParseTree> siblings) {
        for (int i = 0; i < siblings.size(); i++) {
            if (siblings.get(i).equals(pointer)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Should not be called currently if the pointer is not in list of siblings.");
    }
}
