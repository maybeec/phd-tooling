package io.github.maybeec.patterndetection.entity;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface Match {

    /**
     *
     */
    List<Map<String, String>> resolveVariableSubstitutions();

}
