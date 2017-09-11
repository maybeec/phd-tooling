package io.github.maybeec.patterndetection.entity;

import java.util.Collection;

/**
 *
 */
public interface AstPathCollection<T extends AstElem> extends Collection<T>, AstElem {

    public String getType();

    public boolean isOrdered();

    public boolean isAtomic();
}
