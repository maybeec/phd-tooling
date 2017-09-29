package io.github.maybeec.patterndetection.resolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import io.github.maybeec.patterndetection.entity.AstElem;
import io.github.maybeec.patterndetection.entity.AtomarMatch;
import io.github.maybeec.patterndetection.entity.Match;
import io.github.maybeec.patterndetection.exception.NoMatchException;
import io.github.maybeec.patterndetection.utils.CartesianIterator;

/**
 *
 */
public class VariableSubstitutionResolver {

    /**
     *
     */
    public List<Map<String, String>> resolve(List<Match<AstElem>> matches) {

        for (Match<AstElem> match : matches) {

        }

        return null;
    }

    /**
     * @param variableSubstitutions
     * @param matches
     */
    public static List<Map<String, String>> resolveVariableSubstitution(List<List<AtomarMatch<AstElem>>> matches) {
        // === calculate a valid variable assignment
        // erst ohne PH matches
        // -> alle permutationen
        // dann mit PHs
        // -> erstelle liste von placeholders
        // -> sortiere liste nach anzahl von matches
        // -> prüfe alle mit einem match und setze die variableSubstitutions (fail wenn nicht konsistent)
        // -> prüfe mit 2 Matches mit gegebenen variableSubstitutions
        // ----> wenn dennoch weiterhin beide Alternativen existieren, eine wählen, eine weitere vormerken
        List<List<AtomarMatch<AstElem>>> pureObjLangMatches =
            matches.stream().filter(e -> !e.get(0).containsPh()).collect(Collectors.toList());

        // matches to be selected grouped by template node
        // Map<AstPathList<AstElem>, Match<AstPathList<AstElem>>> selectedMatches = new HashMap<>();

        List<Map<String, String>> possibleVariableSubstitutions = new ArrayList<>();

        CartesianIterator<AtomarMatch<AstElem>> it = new CartesianIterator<>(pureObjLangMatches);
        while (it.hasNext()) {
            List<AtomarMatch<AstElem>> next = it.next();
            List<AstElem> matchedTempEng = new ArrayList<>();
            Map<String, String> variableSubstitutionsTemp = new HashMap<>();
            boolean consistentMatch = true;
            for (AtomarMatch<AstElem> e : next) {
                if (!matchedTempEng.contains(e.getTemplate())) {
                    matchedTempEng.add(e.getTemplate());
                } else {
                    consistentMatch = false;
                    break;
                }
                if (isCompatible(variableSubstitutionsTemp, e.getVariableSubstitutions())) {
                    variableSubstitutionsTemp.putAll(e.getVariableSubstitutions());
                } else {
                    consistentMatch = false;
                    break;
                }
            }

            if (consistentMatch && !variableSubstitutionsTemp.isEmpty()) {
                possibleVariableSubstitutions.add(variableSubstitutionsTemp);
            }
        }

        return possibleVariableSubstitutions;
    }

    /**
     * Calculate the valid combined variable substitutions of a and b. If no valid combination can be found, a
     * {@link NoMatchException} will be thrown.
     * @param a
     *            list of variable substitutions
     * @param b
     *            list of variable substitutions
     * @return the list of valid combine variable substitutions or throws an {@link NoMatchException}.
     */
    public static List<Map<String, String>> calcValidVariableSubstitutions(List<Map<String, String>> a,
        List<Map<String, String>> b) {
        if (a.isEmpty() && !b.isEmpty()) {
            return b;
        } else if (b.isEmpty()) {
            return a;
        }

        List<List<Map<String, String>>> in = new ArrayList<>();
        in.add(a);
        in.add(b);

        List<Map<String, String>> combinedVariableSubstitutions = new ArrayList<>();
        CartesianIterator<Map<String, String>> it = new CartesianIterator<>(in);
        while (it.hasNext()) {
            List<Map<String, String>> next = it.next();
            if (isCompatible(next.get(0), next.get(1))) {
                next.get(0).putAll(next.get(1));
                combinedVariableSubstitutions.add(next.get(0));
            }
        }
        if (combinedVariableSubstitutions.isEmpty()) {
            throw new NoMatchException("No compatible variable substitution found.");
        }
        return combinedVariableSubstitutions;
    }

    /**
     * Checks whether there is any conflict (non equal variable substitution in both maps)
     * @param variableSubstitutionsSource
     *            already selected variable substitutions
     * @param variableSubstitutionsToAdd
     *            variable substitutions potentially to be added
     * @return <code>true</code> if there are no conflicts, <code>false</code> otherwise
     */
    public static boolean isCompatible(Map<String, String> variableSubstitutionsSource,
        Map<String, String> variableSubstitutionsToAdd) {
        Set<String> keysContainedInBoth = new HashSet<>(variableSubstitutionsSource.keySet());
        keysContainedInBoth.retainAll(variableSubstitutionsToAdd.keySet()); // get intersection
        // check all values in the intersection to be the same / compatible
        for (String key : keysContainedInBoth) {
            if (!variableSubstitutionsSource.get(key).equals(variableSubstitutionsToAdd.get(key))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Combines the set of variable substitutions if there is not conflict, meaning a mapping of the same key
     * with different values.
     * @param variableSubstitutions
     *            variable substitutions to be combined
     * @return the combined variable substitution or <code>null</code> in case of conflicting variable
     *         substitutions
     */
    public static Map<String, String> combine(List<Map<String, String>> variableSubstitutions) {
        Map<String, String> variableSubstitution = new HashMap<>();
        for (Map<String, String> elem : variableSubstitutions) {
            if (!isCompatible(variableSubstitution, elem)) {
                return null;
            } else {
                variableSubstitution.putAll(elem);
            }
        }
        return variableSubstitution;
    }
}
