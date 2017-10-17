package io.github.maybeec.patterndetection.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 */
public class AstPath implements AstElem {

    /** Meta language prefix */
    private static final String META_LANG_PREFIX = "fm_";

    /** Name of the element / Path element specifier */
    private String name;

    /** Full text representation by this AST node */
    private String text;

    /** Parent node element. */
    private AstPath parent;

    /** If this element is of meta language */
    private boolean isMetaLang;

    /** If the path (including parents) include meta language */
    private boolean containsMetaLang;

    /**
     * @param name
     * @param text
     * @param parent
     */
    public AstPath(String name, String text, AstPath parent) {
        this.name = name;
        this.text = text;
        this.parent = parent;
        isMetaLang = name.toLowerCase().startsWith(META_LANG_PREFIX);
        containsMetaLang = isMetaLang || (parent != null ? parent.containsMetaLang : false);
    }

    public AstPath getParent() {
        return parent;
    }

    public boolean hasParent() {
        return parent != null;
    }

    public String getName() {
        return name;
    }

    public boolean isMetaLang() {
        return isMetaLang;
    }

    public boolean containsMetaLang() {
        return containsMetaLang;
    }

    public String getText() {
        return text;
    }

    public String getFullPathText() {
        String fullText = "";
        if (parent != null) {
            fullText = parent.getFullPathText();
        }
        fullText += text;
        return fullText;
    }

    public String getPath() {
        return getPathSegments().stream().collect(Collectors.joining("/"));
    }

    public List<String> getPathSegments() {
        List<String> pathSegments = new ArrayList<>();
        if (parent != null) {
            pathSegments.addAll(parent.getPathSegments());
        }
        pathSegments.add(name);
        return pathSegments;
    }

    private List<AstPath> getPathElements() {
        List<AstPath> pathElements = new ArrayList<>();
        AstPath currParent = parent;
        while (currParent != null) {
            pathElements.add(currParent);
            currParent = currParent.parent;
        }
        // return in reverse order
        return IntStream.rangeClosed(1, pathElements.size()).mapToObj(i -> pathElements.get(pathElements.size() - i))
            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return getText();
    }

    /**
     * In contrast to {@link #getPath()}, returns the complete path of this element eliminating all meta
     * language segments
     * @return the pure object language path
     */
    public Object getPureObjLangPath() {
        return getPathElements().stream().filter(e -> !e.isMetaLang).map(AstPath::getName)
            .collect(Collectors.joining("/"));
    }

}
