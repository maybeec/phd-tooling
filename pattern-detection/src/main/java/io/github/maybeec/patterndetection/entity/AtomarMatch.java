package io.github.maybeec.patterndetection.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.assertj.core.util.Lists;

/**
 *
 */
public class AtomarMatch<T> implements Match<T> {

    private T template;

    private T appCode;

    private List<Map<String, String>> variableSubstitutions;

    private boolean containsPh;

    /**
     * @param template
     * @param appCode
     * @param variableSubstitutions
     */
    public AtomarMatch(T template, T appCode, Map<String, String> variableSubstitutions) {
        this(template, appCode,
            variableSubstitutions.isEmpty() ? Lists.newArrayList() : Lists.newArrayList(variableSubstitutions));
    }

    /**
     * @param template
     * @param appCode
     * @param variableSubstitutions
     */
    public AtomarMatch(T template, T appCode, List<Map<String, String>> variableSubstitutions) {
        this.template = template;
        this.appCode = appCode;
        this.variableSubstitutions =
            variableSubstitutions.isEmpty() ? Lists.newArrayList() : Lists.newArrayList(variableSubstitutions);
        this.containsPh = !variableSubstitutions.isEmpty();

    }

    public T getTemplate() {
        return this.template;
    }

    public T getAppCode() {
        return this.appCode;
    }

    @Override
    public List<Map<String, String>> getVariableSubstitutions() {
        return this.variableSubstitutions;
    }

    public boolean containsPh() {
        return this.containsPh;
    }

    @Override
    public Set<String> getMatchedPaths() {
        if (appCode instanceof AstPathCollection) {
            AstPathCollection<T> appCodeC = ((AstPathCollection<T>) appCode);

            for (AstPathCollection ac : appCodeC) {

            }
        }
        return null;
    }
}
