package io.github.maybeec.patterndetection.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
        this(template, appCode, variableSubstitutions == null || variableSubstitutions.isEmpty() ? new ArrayList<>()
            : Arrays.asList(variableSubstitutions));
    }

    /**
     * @param template
     * @param appCode
     * @param variableSubstitutions
     */
    public AtomarMatch(AstElem template, AstElem appCode, List<Map<String, String>> variableSubstitutions) {
        this.template = template;
        this.appCode = appCode;
        this.variableSubstitutions = variableSubstitutions == null ? new ArrayList<>() : variableSubstitutions;
        containsPh = !this.variableSubstitutions.isEmpty();

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

    @Override
    public String toString() {
        return template.toString() + " -> " + appCode.toString();
    }

}
