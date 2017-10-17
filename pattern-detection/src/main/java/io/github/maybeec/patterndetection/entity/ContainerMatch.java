package io.github.maybeec.patterndetection.entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.github.maybeec.patterndetection.resolver.VariableSubstitutionResolver;

/**
 *
 */
public class ContainerMatch implements Match {

    /**
     * Secured by construction, that no match points to the same app node
     */
    private List<List<Match>> subsequentMatches;

    private Map<String, String> variableSubstitutions;

    public ContainerMatch(List<List<Match>> subsequentMatches) {
        this.subsequentMatches = subsequentMatches;
    }

    public ContainerMatch(List<List<Match>> subsequentMatches, Map<String, String> variableSubstitutions) {
        this.subsequentMatches = subsequentMatches;
        this.variableSubstitutions = variableSubstitutions;
    }

    public List<List<Match>> getSubsequentMatches() {
        return subsequentMatches;
    }

    @Override
    public List<Map<String, String>> resolveVariableSubstitutions() {
        List<Map<String, String>> calculateVariableSubstitutions =
            VariableSubstitutionResolver.calculateVariableSubstitutions(subsequentMatches);

        if (variableSubstitutions != null) {
            for (Iterator<Map<String, String>> it = calculateVariableSubstitutions.iterator(); it.hasNext();) {
                Map<String, String> entry = it.next();
                Set<String> containedKeys = new HashSet<>(entry.keySet());
                containedKeys.retainAll(variableSubstitutions.keySet());
                for (String key : containedKeys) {
                    if (!entry.get(key).equals(variableSubstitutions.get(key))) {
                        it.remove();
                        continue;
                    }
                }

                entry.putAll(variableSubstitutions);
            }
        }
        return calculateVariableSubstitutions;
    }

    @Override
    public String toString() {
        return subsequentMatches.toString() + (variableSubstitutions != null ? " + " + variableSubstitutions : "");
    }

}
