package io.github.maybeec.patterndetection.entity;

import java.util.HashSet;

/**
 *
 */
public class AstPathSet extends HashSet<AstElem> implements AstPathCollection {

    private ListType type;

    private String hint;

    private Boolean isMetaLang;

    /**
     * @param type
     */
    public AstPathSet(ListType type, String hint) {
        this.hint = hint;
        this.type = type;
    }

    @Override
    public void setType(ListType type) {
        this.type = type;
    }

    @Override
    public ListType getType() {
        return type;
    }

    @Override
    public String getHint() {
        return hint;
    }

    @Override
    public boolean isOrdered() {
        return type == ListType.ORDERED || type == ListType.LIST_PATTERN;
    }

    @Override
    public boolean isAtomic() {
        return type == ListType.ATOMIC;
    }

    @Override
    public boolean isListPattern() {
        return type == ListType.LIST_PATTERN;
    }

    @Override
    public boolean isMetaLang() {
        return isMetaLang != null ? isMetaLang : type.isMetaLang();
    }

    @Override
    public void setIsMetaLang(boolean isMetaLang) {
        this.isMetaLang = isMetaLang;
    }
}
