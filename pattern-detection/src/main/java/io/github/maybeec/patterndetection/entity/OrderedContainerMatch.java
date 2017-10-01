package io.github.maybeec.patterndetection.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.github.maybeec.patterndetection.resolver.VariableSubstitutionResolver;
import io.github.maybeec.patterndetection.utils.CartesianIterator;

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
        List<Map<String, String>> validVariableSubstitutions = new ArrayList<>();
        for (List<Match> validMatch : subsequentMatchesNonAmbigous) {
            List<List<Map<String, String>>> variableSubstitutionsPerMatch = validMatch.stream()
                .map(Match::resolveVariableSubstitutions).filter(e -> !e.isEmpty()).collect(Collectors.toList());
            CartesianIterator<Map<String, String>> it = new CartesianIterator<>(variableSubstitutionsPerMatch);
            while (it.hasNext()) {
                List<Map<String, String>> combination = it.next();

                Map<String, String> variableSubstitution = new HashMap<>();
                boolean consistentMatch = true;
                for (Map<String, String> elem : combination) {
                    if (VariableSubstitutionResolver.isCompatible(variableSubstitution, elem)) {
                        variableSubstitution.putAll(elem);
                    } else {
                        consistentMatch = false;
                        break;
                    }
                }
                if (consistentMatch) {
                    validVariableSubstitutions.add(variableSubstitution);
                }
            }
        }
        return validVariableSubstitutions;
    }

    @Override
    public String toString() {
        return subsequentMatchesNonAmbigous.toString();
    }

    // @Override
    // public List<Map<String, String>> resolveVariableSubstitutions() {
    //
    // List<List<Map<String, String>>> variableSubstitutionsPerMatch = new ArrayList<>();
    // boolean atLeastOneSubstitution = false;
    // for (Match match : subsequentMatchesNonAmbigous) {
    // List<Map<String, String>> variableSubstitutions = match.resolveVariableSubstitutions();
    // if (!variableSubstitutions.isEmpty()) {
    // variableSubstitutionsPerMatch.add(variableSubstitutions);
    // atLeastOneSubstitution = true;
    // }
    // }
    //
    // List<Map<String, String>> resultingVariableSubstitutions = new ArrayList<>();
    // CartesianIterator<Map<String, String>> it = new CartesianIterator<>(variableSubstitutionsPerMatch);
    // while (it.hasNext()) {
    // List<Map<String, String>> elem = it.next();
    // Map<String, String> combinedVariableSubstitution = VariableSubstitutionResolver.combine(elem);
    // if (combinedVariableSubstitution != null) {
    // resultingVariableSubstitutions.add(combinedVariableSubstitution);
    // }
    // }
    //
    // if (atLeastOneSubstitution && resultingVariableSubstitutions.isEmpty()) {
    // throw new NoMatchException("Conflicting variable substitutions!");
    // }
    // return resultingVariableSubstitutions;
    // }

    // @Override
    // public Set<String> getMatchedPaths() {
    // return subsequentMatchesNonAmbigous.stream().map(Match::getMatchedPaths).flatMap(Collection::stream)
    // .collect(Collectors.toSet());
    // }
}
