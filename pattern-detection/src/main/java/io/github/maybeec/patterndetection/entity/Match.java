package io.github.maybeec.patterndetection.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public interface Match<T> {

    /**
     *
     */
    List<Map<String, String>> getVariableSubstitutions();

    Set<String> getMatchedPaths();

}
