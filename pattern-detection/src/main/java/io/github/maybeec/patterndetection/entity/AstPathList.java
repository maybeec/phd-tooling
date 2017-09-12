package io.github.maybeec.patterndetection.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class AstPathList<T extends AstElem> extends ArrayList<T> implements AstPathCollection<T> {

    private String type;

    private boolean isOrdered;

    private boolean isAtomic;

    private boolean isListPattern;

    private Map<AstPathList<T>, List<Map<String, String>>> matches;

    /**
     * @param type
     */
    public AstPathList(String type, boolean isOrdered) {
        super();
        this.type = type;
        this.isOrdered = isOrdered;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean isOrdered() {
        return isOrdered;
    }

    public void setAtomic(boolean isAtomic) {
        this.isAtomic = isAtomic;
    }

    @Override
    public boolean isAtomic() {
        return isAtomic;
    }

    @Override
    public boolean isListPattern() {
        return this.isListPattern;
    }

    public void setListPattern(boolean isListPattern) {
        this.isListPattern = isListPattern;
    }
}
