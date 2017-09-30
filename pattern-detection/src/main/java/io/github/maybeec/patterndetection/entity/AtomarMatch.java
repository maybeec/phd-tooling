package io.github.maybeec.patterndetection.entity;

import java.util.List;
import java.util.Map;

import org.assertj.core.util.Lists;

/**
 *
 */
public class AtomarMatch implements Match {

    private AstElem template;

    private AstElem appCode;

    private List<Map<String, String>> variableSubstitutions;

    private boolean containsPh;

    /**
     * @param template
     * @param appCode
     * @param variableSubstitutions
     */
    public AtomarMatch(AstElem template, AstElem appCode, Map<String, String> variableSubstitutions) {
        this(template, appCode,
            variableSubstitutions.isEmpty() ? Lists.newArrayList() : Lists.newArrayList(variableSubstitutions));
    }

    /**
     * @param template
     * @param appCode
     * @param variableSubstitutions
     */
    public AtomarMatch(AstElem template, AstElem appCode, List<Map<String, String>> variableSubstitutions) {
        this.template = template;
        this.appCode = appCode;
        this.variableSubstitutions =
            variableSubstitutions.isEmpty() ? Lists.newArrayList() : Lists.newArrayList(variableSubstitutions);
        containsPh = !variableSubstitutions.isEmpty();

    }

    public AstElem getTemplate() {
        return template;
    }

    public AstElem getAppCode() {
        return appCode;
    }

    @Override
    public List<Map<String, String>> resolveVariableSubstitutions() {
        return variableSubstitutions;
    }

    public boolean containsPh() {
        return containsPh;
    }

    // @Override
    // public Set<String> getMatchedPaths() {
    // if (appCode instanceof AstPathCollection) {
    // return getMatchedPaths((AstPathCollection) appCode);
    // } else if (appCode instanceof AstPath) {
    // Set<String> paths = new HashSet<>();
    // paths.add(((AstPath) appCode).getPath());
    // return paths;
    // }
    // return null;
    // }

    // private Set<String> getMatchedPaths(AstPathCollection collection) {
    //
    // Set<String> paths = new HashSet<>();
    // for (AstElem ac : collection) {
    // if (ac instanceof AstPath) {
    // paths.add(((AstPath) ac).getPath());
    // } else if (ac instanceof AstPathCollection) {
    // paths.addAll(getMatchedPaths((AstPathCollection) ac));
    // }
    // }
    // return paths;
    // }
}
