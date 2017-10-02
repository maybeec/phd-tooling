package io.github.maybeec.patterndetection.entity;

import java.util.List;
import java.util.Map;

import io.github.maybeec.patterndetection.resolver.VariableSubstitutionResolver;

/**
 *
 */
public class OrderedContainerMatch implements Match {

    /**
     * Secured by construction, that no match points to the same app node
     */
    private List<List<Match>> subsequentMatchesNonAmbigous;

    public OrderedContainerMatch(List<List<Match>> subsequentMatchesNonAmbigous) {
        this.subsequentMatchesNonAmbigous = subsequentMatchesNonAmbigous;
    }

    public List<List<Match>> getSubsequentMatchesNonAmbigous() {
        return subsequentMatchesNonAmbigous;
    }

    @Override
    public List<Map<String, String>> resolveVariableSubstitutions() {
        return VariableSubstitutionResolver.calculateVariableSubstitutions(subsequentMatchesNonAmbigous);
    }

    @Override
    public String toString() {
        return subsequentMatchesNonAmbigous.toString();
    }

}
