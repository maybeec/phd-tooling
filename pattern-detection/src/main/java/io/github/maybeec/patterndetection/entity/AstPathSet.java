package io.github.maybeec.patterndetection.entity;

import java.util.HashSet;

/**
 *
 */
public class AstPathSet extends HashSet<AstElem> implements AstPathCollection {

    private String type;

    private boolean isOrdered;

    private boolean isAtomic;

    private boolean isListPattern;

    /**
     * @param type
     */
    public AstPathSet(String type) {
        super();
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean isOrdered() {
        return isOrdered;
    }

    @Override
    public boolean isAtomic() {
        return isAtomic;
    }

    @Override
    public boolean isListPattern() {
        return isListPattern;
    }

}
