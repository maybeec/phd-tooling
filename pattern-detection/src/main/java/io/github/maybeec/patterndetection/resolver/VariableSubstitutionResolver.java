package io.github.maybeec.patterndetection.resolver;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
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
    public List<Map<String, String>> resolve(Match match) {

        return null;
    }

    /**
     * @param validMatches
     * @return
     */
    public static List<Map<String, String>> calculateVariableSubstitutions(List<List<Match>> validMatches) {
        List<Map<String, String>> validVariableSubstitutions = new ArrayList<>();
        for (List<Match> validMatch : validMatches) {
            List<List<Map<String, String>>> variableSubstitutionsPerMatch =
                validMatch.stream().map(Match::resolveVariableSubstitutions).filter(e -> !e.isEmpty())
                    .filter(e -> !e.get(0).isEmpty()).distinct().collect(Collectors.toList());
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
                if (consistentMatch && !validVariableSubstitutions.contains(variableSubstitution)) {
                    validVariableSubstitutions.add(variableSubstitution);
                }
            }
        }
        return validVariableSubstitutions;
    }

    // /**
    // * @param variableSubstitutions
    // * @param matches
    // */
    // public static List<Map<String, String>> resolveVariableSubstitution(List<List<Match>> matches) {
    // // === calculate a valid variable assignment
    // // erst ohne PH matches
    // // -> alle permutationen
    // // dann mit PHs
    // // -> erstelle liste von placeholders
    // // -> sortiere liste nach anzahl von matches
    // // -> prüfe alle mit einem match und setze die variableSubstitutions (fail wenn nicht konsistent)
    // // -> prüfe mit 2 Matches mit gegebenen variableSubstitutions
    // // ----> wenn dennoch weiterhin beide Alternativen existieren, eine wählen, eine weitere vormerken
    // List<List<Match>> pureObjLangMatches =
    // matches.stream().filter(e -> !e.get(0).containsPh()).collect(Collectors.toList());
    //
    // // matches to be selected grouped by template node
    // // Map<AstPathList<AstElem>, Match<AstPathList<AstElem>>> selectedMatches = new HashMap<>();
    //
    // List<Map<String, String>> possibleVariableSubstitutions = new ArrayList<>();
    //
    // CartesianIterator<Match> it = new CartesianIterator<>(pureObjLangMatches);
    // while (it.hasNext()) {
    // List<Match> next = it.next();
    // List<AstElem> matchedTempEng = new ArrayList<>();
    // Map<String, String> variableSubstitutionsTemp = new HashMap<>();
    // boolean consistentMatch = true;
    // for (Match e : next) {
    // if (isCompatible(variableSubstitutionsTemp, e.getVariableSubstitutions())) {
    // variableSubstitutionsTemp.putAll(e.getVariableSubstitutions());
    // } else {
    // consistentMatch = false;
    // break;
    // }
    // }
    //
    // if (consistentMatch && !variableSubstitutionsTemp.isEmpty()) {
    // possibleVariableSubstitutions.add(variableSubstitutionsTemp);
    // }
    // }
    //
    // return possibleVariableSubstitutions;
    // }

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

    // /**
    // * Combines the set of variable substitutions if there is not conflict, meaning a mapping of the same
    // key
    // * with different values.
    // * @param variableSubstitutions
    // * variable substitutions to be combined
    // * @return the combined variable substitution or <code>null</code> in case of conflicting variable
    // * substitutions
    // */
    // public static Map<String, String> combine(List<Map<String, String>> variableSubstitutions) {
    // Map<String, String> variableSubstitution = new HashMap<>();
    // for (Map<String, String> elem : variableSubstitutions) {
    // if (!isCompatible(variableSubstitution, elem)) {
    // return null;
    // } else {
    // variableSubstitution.putAll(elem);
    // }
    // }
    // return variableSubstitution;
    // }
    /** Basic FreeMarker configuration */
    private static Configuration cfg;

    static {
        cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
    }

    public static List<Map<String, String>> languageSpecificReduce(List<Map<String, String>> variables) {

        List<Map<String, String>> reducedVariables = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (Map<String, String> elem : variables) {
            List<String> partiallyContainedKeys = getPartiallyContainedKeys(elem);
            elem.keySet().removeAll(partiallyContainedKeys);
            reducedVariables.add(elem);
            min = Math.min(min, elem.size());
        }
        final int _min = min;
        return reducedVariables.stream().filter(e -> e.size() == _min).collect(Collectors.toList());
    }

    private static List<String> getPartiallyContainedKeys(Map<String, String> variables) {
        List<String> partiallyContained = new ArrayList<>();

        for (String current : variables.keySet()) {
            List<String> collect = variables.keySet().stream().filter(e -> !e.equals(current) && e.contains(current))
                .collect(Collectors.toList());

            Iterator<String> it = collect.iterator();
            while (it.hasNext()) {
                String potentiallyRedundant = it.next();
                Map<String, String> tmp = new HashMap<>(variables);
                if (tmp.remove(potentiallyRedundant) != null) {
                    Template template;
                    String output = null;

                    try (StringWriter out = new StringWriter()) {
                        template = new Template("temp", new StringReader("${" + potentiallyRedundant + "}"), cfg);
                        template.process(buildModel(tmp), out);
                        output = out.toString();
                    } catch (IOException | TemplateException ex) {
                        // e.printStackTrace();
                    }

                    if (output == null || output.isEmpty() || !variables.get(potentiallyRedundant).equals(output)) {
                        it.remove(); // could not be missed
                    }
                }
            }
            partiallyContained.addAll(collect);
        }
        return partiallyContained;
    }

    private static Map<String, Object> buildModel(Map<String, String> flatModel) {

        Map<String, Object> model = new HashMap<>();
        for (String key : flatModel.keySet()) {
            buildModel(model, key, flatModel.get(key));
        }
        return model;
    }

    private static void buildModel(Map<String, Object> model, String remainingKey, String value) {
        String[] fragments = remainingKey.split("\\.");
        if (fragments.length == 1) {
            model.put(fragments[0], value); // there will be no conflicts
        } else if (fragments.length > 1) {
            Map<String, Object> childModel = (Map<String, Object>) model.get(fragments[0]);
            if (childModel == null) {
                childModel = new HashMap<>();
                model.put(fragments[0], childModel);
            }
            String[] remainingFragments = new String[fragments.length - 1];
            System.arraycopy(fragments, 1, remainingFragments, 0, fragments.length - 1);
            buildModel(childModel, String.join(".", remainingFragments), value);
        }
    }
}
