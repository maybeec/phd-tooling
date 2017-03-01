package io.github.maybeec.antlr4.generator;

/**
 * A container class for information exchange during template transformation
 *
 * @author fkreis (06.05.2016)
 */
public class GrammarSpec {

    /**
     * The name for the new grammar
     */
    private String newGrammarName;

    /**
     * A capitalized unique prefix usable for the placeholder lexer rule name
     */
    private String uniquePlaceholderStart;

    /**
     * An uncapitalized unique prefix usable for the parser rule names
     */
    private String uniqueStart;

    /**
     * The name for the placeholder in the template grammar
     */
    private static String placeHolderName;

    /**
     * The definition for the placeholder in the template grammar
     */
    private String placeHolderDef;

    /**
     * The definition for the if rule in the template grammar
     */
    private String ifRuleDef;

    /**
     * The definition for the ifelse rule in the template grammar
     */
    private String ifElseRuleDef;

    /**
     * The definition for the loop rule in the template grammar
     */
    private String loopRuleDef;

    /**
     * @param newGrammarName
     *            The name for the new grammar
     * @param uniquePlaceholderStart
     *            A capitalized unique prefix usable for the placeholder lexer rule name
     * @param uniqueStart
     *            An uncapitalized unique prefix usable for the parser rule names
     * @param placeHolderName
     *            The name for the placeholder in the template grammar
     * @param placeHolderDef
     *            The definition for the placeholder in the template grammar
     * @param ifRuleDef
     *            The definition for the if rule in the template grammar
     * @param ifElseRuleDef
     *            The definition for the ifelse rule in the template grammar
     * @param loopDef
     *            The definition for the loop rule in the template grammar
     * @author fkreis (30.06.2016)
     */
    public GrammarSpec(String newGrammarName, String uniquePlaceholderStart, String uniqueStart,
        String placeHolderName, String placeHolderDef, String ifRuleDef, String ifElseRuleDef, String loopDef) {
        super();
        this.newGrammarName = newGrammarName;
        this.uniquePlaceholderStart = uniquePlaceholderStart;
        this.uniqueStart = uniqueStart;
        GrammarSpec.placeHolderName = placeHolderName;
        this.placeHolderDef = placeHolderDef;
        this.ifRuleDef = ifRuleDef;
        this.ifElseRuleDef = ifElseRuleDef;
        loopRuleDef = loopDef;
    }

    /**
     * Returns the field 'newGrammarName'
     * @return value of newGrammarName
     * @author fkreis (06.05.2016)
     */
    public String getNewGrammarName() {
        return newGrammarName;
    }

    /**
     * Returns the field 'uniquePlaceholderStart'
     * @return value of uniquePlaceholderStart
     * @author fkreis (06.05.2016)
     */
    public String getUniquePlaceholderStart() {
        return uniquePlaceholderStart;
    }

    /**
     * Returns the field 'uniqueStart'
     * @return value of uniqueStart
     * @author fkreis (06.05.2016)
     */
    public String getUniqueStart() {
        return uniqueStart;
    }

    /**
     * Returns the field 'placeHolderName'
     * @return value of placeHolderName
     * @author fkreis (06.05.2016)
     */
    public String getPlaceHolderName() {
        return placeHolderName;
    }

    /**
     * Returns the field 'placeHolderDef'
     * @return value of placeHolderDef
     * @author fkreis (06.05.2016)
     */
    public String getPlaceHolderDef() {
        return placeHolderDef;
    }

    /**
     * Returns the field 'ifRuleDef'
     * @return value of ifRuleDef
     * @author fkreis (30.06.2016)
     */
    public String getIfRuleDef() {
        return ifRuleDef;
    }

    /**
     * Returns the field 'ifElseRuleDef'
     * @return value of ifElseRuleDef
     * @author fkreis (30.06.2016)
     */
    public String getIfElseRuleDef() {
        return ifElseRuleDef;
    }

    /**
     * Returns the field 'loopDef'
     * @return value of loopDef
     * @author fkreis (30.06.2016)
     */
    public String getLoopRuleDef() {
        return loopRuleDef;
    }

}
