package io.github.maybeec.patterndetection.entity;

import java.util.Collection;

/**
 *
 */
public interface AstPathCollection extends Collection<AstElem>, AstElem {

    public String getType();

    public boolean isOrdered();

    public boolean isAtomic();

    public boolean isListPattern();
}
