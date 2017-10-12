package io.github.maybeec.patterndetection.entity;

import java.util.Collection;

/**
 *
 */
public interface AstPathCollection extends Collection<AstElem>, AstElem {

    public String getHint();

    public boolean isOrdered();

    public boolean isAtomic();

    public boolean isListPattern();

    public void setType(ListType type);

    public ListType getType();

    public boolean isMetaLang();

    public void setIsMetaLang(boolean isMetaLang);

    default boolean is(ListType... types) {
        boolean result = false;
        for (ListType type : types) {
            result |= getType() == type;
        }
        return result;
    }
}
