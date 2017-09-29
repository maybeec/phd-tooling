package io.github.maybeec.patterndetection.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.github.maybeec.patterndetection.exception.NoMatchException;
import io.github.maybeec.patterndetection.resolver.VariableSubstitutionResolver;
import io.github.maybeec.patterndetection.utils.CartesianIterator;

/**
 *
 */
public class OrderedContainerMatch<T extends AstElem> implements Match<T> {

    /**
     * Secured by construction, that no match points to the same app node
     */
    private List<Match<T>> subsequentMatchesNonAmbigous;

    public OrderedContainerMatch(List<Match<T>> subsequentMatchesNonAmbigous) {
        this.subsequentMatchesNonAmbigous = subsequentMatchesNonAmbigous;
    }

    public List<Match<T>> getSubsequentMatchesNonAmbigous() {
        return subsequentMatchesNonAmbigous;
    }

    @Override
    public List<Map<String, String>> getVariableSubstitutions() {

        List<List<Map<String, String>>> variableSubstitutionsPerMatch = new ArrayList<>();
        boolean atLeastOneSubstitution = false;
        for (Match<T> match : subsequentMatchesNonAmbigous) {
            variableSubstitutionsPerMatch.add(match.getVariableSubstitutions());
            if (!match.getVariableSubstitutions().isEmpty()) {
                atLeastOneSubstitution = true;
            }
        }

        List<Map<String, String>> resultingVariableSubstitutions = new ArrayList<>();
        CartesianIterator<Map<String, String>> it = new CartesianIterator<>(variableSubstitutionsPerMatch);
        while (it.hasNext()) {
            List<Map<String, String>> elem = it.next();
            Map<String, String> combinedVariableSubstitution = VariableSubstitutionResolver.combine(elem);
            if (combinedVariableSubstitution != null) {
                resultingVariableSubstitutions.add(combinedVariableSubstitution);
            }
        }

        if (atLeastOneSubstitution && resultingVariableSubstitutions.isEmpty()) {
            throw new NoMatchException("Conflicting variable substitutions!");
        }
        return resultingVariableSubstitutions;
    }
}
