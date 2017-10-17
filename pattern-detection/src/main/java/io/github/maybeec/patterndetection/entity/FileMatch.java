package io.github.maybeec.patterndetection.entity;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class FileMatch {

    private Path template;

    private Path sourceFile;

    private List<Map<String, String>> variableSubstitutions;

    /**
     * @param template
     * @param sourceFile
     * @param variableSubstitutions
     */
    public FileMatch(Path template, Path sourceFile, List<Map<String, String>> variableSubstitutions) {
        super();
        this.template = template;
        this.sourceFile = sourceFile;
        this.variableSubstitutions = variableSubstitutions;
    }

    public Path getTemplate() {
        return template;
    }

    public Path getSourceFile() {
        return sourceFile;
    }

    public List<Map<String, String>> getVariableSubstitutions() {
        return variableSubstitutions;
    }

    @Override
    public String toString() {
        return "Template[" + template + "] -> Source[" + sourceFile + "]: " + variableSubstitutions
            + System.getProperty("line.separator");
    }
}
