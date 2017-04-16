package io.github.maybeec.antlr4.generator;

/**
 * A container class for information exchange during template transformation
 */
public class GrammarSpec {

    /** The name for the new grammar */
    private String newGrammarName;

    /** A capitalized unique prefix usable for the placeholder lexer rule name */
    private String metaLangPlaceholderPrefix;

    /** An uncapitalized unique prefix usable for the parser rule names */
    private String metaLangRulePrefix;

    /** The name for the placeholder in the template grammar */
    private static String placeHolderSuffix;

    /** The definition for the placeholder in the template grammar */
    private String placeHolderDef;

    /** The definition for the if rule in the template grammar */
    private String ifRuleDef;

    /** The definition for the ifelse rule in the template grammar */
    private String ifElseRuleDef;

    /** The definition for the loop rule in the template grammar */
    private String loopRuleDef;

    /**
     * @param newGrammarName
     *            The name for the new grammar
     * @param metaLangPrefix
     *            An unique prefix to be used for newly create meta lang productions
     * @param placeHolderSuffix
     *            The name for the placeholder in the template grammar
     * @param placeHolderDef
     *            The definition for the placeholder in the template grammar
     * @param ifRuleDef
     *            The definition for the if rule in the template grammar
     * @param ifElseRuleDef
     *            The definition for the ifelse rule in the template grammar
     * @param loopDef
     *            The definition for the loop rule in the template grammar
     */
    public GrammarSpec(String newGrammarName, String metaLangPrefix, String placeHolderSuffix, String placeHolderDef,
        String ifRuleDef, String ifElseRuleDef, String loopDef) {
        super();
        this.newGrammarName = newGrammarName;
        metaLangPlaceholderPrefix = metaLangPrefix.toUpperCase();
        metaLangRulePrefix = metaLangPrefix.toLowerCase();
        GrammarSpec.placeHolderSuffix = placeHolderSuffix;
        this.placeHolderDef = placeHolderDef;
        this.ifRuleDef = ifRuleDef;
        this.ifElseRuleDef = ifElseRuleDef;
        loopRuleDef = loopDef;
    }

    /**
     * Returns the field 'newGrammarName'
     * @return value of newGrammarName
     */
    public String getNewGrammarName() {
        return newGrammarName;
    }

    /**
     * Returns the field 'metaLangPlaceholderPrefix'
     * @return value of metaLangPlaceholderPrefix
     */
    public String getMetaLangPlaceholderPrefix() {
        return metaLangPlaceholderPrefix;
    }

    /**
     * Returns the field 'metaLangRulePrefix'
     * @return value of metaLangRulePrefix
     */
    public String getMetaLangRulePrefix() {
        return metaLangRulePrefix;
    }

    /**
     * Returns the field 'placeHolderSuffix'
     * @return value of placeHolderSuffix
     */
    public String getPlaceHolderSuffix() {
        return placeHolderSuffix;
    }

    /**
     * Returns the field 'placeHolderDef'
     * @return value of placeHolderDef
     */
    public String getPlaceHolderDef() {
        return placeHolderDef;
    }

    /**
     * Returns the field 'ifRuleDef'
     * @return value of ifRuleDef
     */
    public String getIfRuleDef() {
        return ifRuleDef;
    }

    /**
     * Returns the field 'ifElseRuleDef'
     * @return value of ifElseRuleDef
     */
    public String getIfElseRuleDef() {
        return ifElseRuleDef;
    }

    /**
     * Returns the field 'loopDef'
     * @return value of loopDef
     */
    public String getLoopRuleDef() {
        return loopRuleDef;
    }

}
