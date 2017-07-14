package io.github.maybeec.patterndetection.matcher;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Save point of the of the matcher state. Used to recover the matcher state on backtracking.
 */
public class MatcherState {

    /** @see #getSelectedSubstitutions() */
    private Map<String, String> selectedSubstitutions;

    /** @see #getSelectedSubstitutionTokenCount() */
    private Map<String, Integer> selectedSubstitutionTokenCount;

    /** @see #getVisited() */
    private Set<ParseTree> visited;

    /** @see #getCoveredUnorderedNodes() */
    private Set<ParseTree> coveredUnorderedNodes;

    /** @see #getAppPointer() */
    private ParseTree appPointer;

    /** @see #getTemplatePointer() */
    private ParseTree templatePointer;

    /**
     * Creates a new matcher state.
     * @param selectedSubstitutions
     *            {@link #getSelectedSubstitutions()}
     * @param selectedSubstitutionTokenCount
     *            {@link #getSelectedSubstitutionTokenCount()}
     * @param appPointer
     *            {@link #getAppPointer()}
     * @param templatePointer
     *            {@link #getTemplatePointer()}
     * @param visited
     *            {@link #getVisited()}
     * @param coveredUnorderedNodes
     *            {@link #getCoveredUnorderedNodes()}
     */
    public MatcherState(Map<String, String> selectedSubstitutions, Map<String, Integer> selectedSubstitutionTokenCount,
        ParseTree appPointer, ParseTree templatePointer, Set<ParseTree> visited, Set<ParseTree> coveredUnorderedNodes) {
        super();
        this.selectedSubstitutions = new HashMap<>(selectedSubstitutions);
        this.selectedSubstitutionTokenCount = new HashMap<>(selectedSubstitutionTokenCount);
        this.visited = new HashSet<>(visited);
        this.coveredUnorderedNodes = new HashSet<>(coveredUnorderedNodes);
        this.appPointer = appPointer;
        this.templatePointer = templatePointer;
    }

    /**
     * @return currently selected token substitutions (matching token text to substitution string)
     */
    public Map<String, String> getSelectedSubstitutions() {
        return selectedSubstitutions;
    }

    /**
     * @return number of tokens of the selected substitution for each token (key = token text)
     */
    public Map<String, Integer> getSelectedSubstitutionTokenCount() {
        return selectedSubstitutionTokenCount;
    }

    /**
     * @return the current pointer of the application CST
     */
    public ParseTree getAppPointer() {
        return appPointer;
    }

    /**
     * @return the current pointer of the template CST
     */
    public ParseTree getTemplatePointer() {
        return templatePointer;
    }

    /**
     * @return visited nodes
     */
    public Set<ParseTree> getVisited() {
        return visited;
    }

    /**
     * @return unordered nodes, which have been matched already
     */
    public Set<ParseTree> getCoveredUnorderedNodes() {
        return coveredUnorderedNodes;
    }

}
