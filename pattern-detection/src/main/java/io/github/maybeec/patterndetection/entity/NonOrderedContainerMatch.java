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

        // second calculate variable substitutions for all valid match arrays
        List<Map<String, String>> validVariableSubstitutions = calculateVariableSubstitutions(subsequentMatches);
        return validVariableSubstitutions;
    }

    /**
     * @param validMatches
     * @return
     */
    private List<Map<String, String>> calculateVariableSubstitutions(List<List<Match>> validMatches) {
        List<Map<String, String>> validVariableSubstitutions = new ArrayList<>();
        for (List<Match> validMatch : validMatches) {
            List<List<Map<String, String>>> variableSubstitutionsPerMatch =
                validMatch.stream().map(Match::resolveVariableSubstitutions).collect(Collectors.toList());
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
        return subsequentMatches.toString();
    }

    //
    // /**
    // * @return
    // */
    // private List<List<Match>> getAllDistinctMatches() {
    // List<List<Match>> validMatches = new ArrayList<>();
    // CartesianIterator<Match> it = new CartesianIterator<>(subsequentMatches);
    // while (it.hasNext()) {
    // List<Match> next = it.next();
    // List<String> allPaths =
    // next.stream().map(Match::getMatchedPaths).flatMap(Collection::stream).collect(Collectors.toList());
    // Set<String> unified = new HashSet<>(allPaths);
    // if (allPaths.size() == unified.size()) { // there were no duplicates
    // validMatches.add(next);
    // }
    // }
    // return validMatches;
    // }
    //
    // // @Override
    // // public Set<String> getMatchedPaths() {
    // // // TODO
    // // return null;
    // // }

}
