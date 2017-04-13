package io.github.maybeec.antlr4.generator;

import java.util.HashSet;
import java.util.Set;

/**
 * A enum of all available grammar transformation strategies
 */
public enum Tactics {
    /**
     *
     */
    ALL(null),

    /**
     *
     */
    ONLYPARSER(null),

    /**
     *
     */
    ONLYTOKEN(null),

    /**
     *
     */
    INTELLIGENT(null),

    /**
     *
     */
    CUSTOM(new HashSet<>());

    private Set<String> tokenNames;

    private Tactics(Set<String> tokenNames) {
        this.tokenNames = tokenNames;
    }

    public void addToken(String tokenName) {
        if (tokenNames != null) {
            tokenNames.add(tokenName);
        }
    }

    public void addTokens(Set<String> tokenNames) {
        if (this.tokenNames != null) {
            this.tokenNames.addAll(tokenNames);
        }
    }

    public boolean containsToken(String tokenName) {
        return tokenNames != null && tokenNames.contains(tokenName);
    }
}
