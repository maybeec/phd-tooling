package io.github.maybeec.patterndetection.entity;

import java.util.ArrayList;

/**
 *
 */
public class AstPathList extends ArrayList<AstElem> implements AstPathCollection {

    private String type;

    private boolean isOrdered;

    private boolean isAtomic;

    private boolean isListPattern;

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
        return isListPattern;
    }

    public void setListPattern(boolean isListPattern) {
        this.isListPattern = isListPattern;
    }
}
