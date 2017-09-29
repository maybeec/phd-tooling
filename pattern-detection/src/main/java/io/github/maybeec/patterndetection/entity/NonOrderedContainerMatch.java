package io.github.maybeec.patterndetection.entity;

import java.util.List;
import java.util.Map;

import io.github.maybeec.patterndetection.resolver.VariableSubstitutionResolver;

/**
 *
 */
public class NonOrderedContainerMatch<T extends AstElem> implements Match<T> {

    /**
     * Matches of unordered nodes, which are grouped by the template node. Thus, the first list contains a
     * list of matches, whereas each list contains all matches for one template node.
     */
    private List<List<Match<T>>> subsequentMatchesAmbigous;

    public NonOrderedContainerMatch(List<List<Match<T>>> subsequentMatchesAmbigous) {
        this.subsequentMatchesAmbigous = subsequentMatchesAmbigous;
    }

    public List<List<Match<T>>> getSubsequentMatchesAmbigous() {
        return subsequentMatchesAmbigous;
    }

    @Override
    public List<Map<String, String>> getVariableSubstitutions() {
        return VariableSubstitutionResolver.resolveVariableSubstitution(subsequentMatchesAmbigous);
    }

}
