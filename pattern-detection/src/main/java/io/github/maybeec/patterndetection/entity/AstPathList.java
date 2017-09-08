package io.github.maybeec.patterndetection.entity;

import java.util.ArrayList;

/**
 *
 */
public class AstPathList<T extends AstElem> extends ArrayList<T> implements AstPathCollection<T> {

    private String type;

    private boolean isOrdered;

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

}
