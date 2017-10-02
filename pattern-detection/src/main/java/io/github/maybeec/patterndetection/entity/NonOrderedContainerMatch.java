package io.github.maybeec.patterndetection.entity;

import java.util.List;
import java.util.Map;

import io.github.maybeec.patterndetection.resolver.VariableSubstitutionResolver;

/**
 *
 */
public class NonOrderedContainerMatch implements Match {

    /**
     * Matches of unordered nodes. Each set represents a valid match of the underlying app templates.
     */
    private List<List<Match>> subsequentMatches;

    public NonOrderedContainerMatch(List<List<Match>> subsequentMatches) {
        this.subsequentMatches = subsequentMatches;
    }

    public List<List<Match>> getSubsequentMatches() {
        return subsequentMatches;
    }

    @Override
    public List<Map<String, String>> resolveVariableSubstitutions() {
        return VariableSubstitutionResolver.calculateVariableSubstitutions(subsequentMatches);
    }

    @Override
    public String toString() {
        return subsequentMatches.toString();
    }

}
