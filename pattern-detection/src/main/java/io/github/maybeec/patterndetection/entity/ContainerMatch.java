package io.github.maybeec.patterndetection.entity;

import java.util.List;
import java.util.Map;

import io.github.maybeec.patterndetection.resolver.VariableSubstitutionResolver;

/**
 *
 */
public class ContainerMatch implements Match {

    /**
     * Secured by construction, that no match points to the same app node
     */
    private List<List<Match>> subsequentMatches;

    public ContainerMatch(List<List<Match>> subsequentMatches) {
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
