package io.github.maybeec.patterndetection.entity;

import java.util.Map;

/**
 *
 */
public class Match<T> {

    private T template;

    private T appCode;

    private Map<String, String> variableSubstitutions;

    /**
     * @param template
     * @param appCode
     * @param variableSubstitutions
     */
    public Match(T template, T appCode, Map<String, String> variableSubstitutions) {
        super();
        this.template = template;
        this.appCode = appCode;
        this.variableSubstitutions = variableSubstitutions;
    }

    public T getTemplate() {
        return this.template;
    }

    public T getAppCode() {
        return this.appCode;
    }

    public Map<String, String> getVariableSubstitutions() {
        return this.variableSubstitutions;
    }

}
