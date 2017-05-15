package io.github.maybeec.patterndetection;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 */
public class MatcherState {

    private Map<String, String> selectedSubstitutions;

    private Map<String, Integer> selectedSubstitutionTokenCount;

    private ParseTree appPointer;

    private ParseTree templatePointer;

    /**
     * @param selectedSubstitutions
     * @param appPointer
     * @param templatePointer
     */
    public MatcherState(Map<String, String> selectedSubstitutions, Map<String, Integer> selectedSubstitutionTokenCount,
        ParseTree appPointer, ParseTree templatePointer) {
        super();
        this.selectedSubstitutions = new HashMap<>(selectedSubstitutions);
        this.selectedSubstitutionTokenCount = new HashMap<>(selectedSubstitutionTokenCount);
        this.appPointer = appPointer;
        this.templatePointer = templatePointer;
    }

    public Map<String, String> getSelectedSubstitutions() {
        return selectedSubstitutions;
    }

    public Map<String, Integer> getSelectedSubstitutionTokenCount() {
        return selectedSubstitutionTokenCount;
    }

    public ParseTree getAppPointer() {
        return appPointer;
    }

    public ParseTree getTemplatePointer() {
        return templatePointer;
    }

}
