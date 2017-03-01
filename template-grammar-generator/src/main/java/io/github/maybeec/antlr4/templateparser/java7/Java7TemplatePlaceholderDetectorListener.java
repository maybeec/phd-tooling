package io.github.maybeec.antlr4.templateparser.java7;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * A Listener that collects information about the expected types of placeholders
 */
public class Java7TemplatePlaceholderDetectorListener extends Java7TemplateBaseListener {

    /**
     * Index for placeholder token definition
     */
    private int placeholderIndex;

    /**
     * Unique rule prefix as defined in the GrammarSpec
     */
    private String uniqueStart;

    /**
     * The placeholder rule's name as defined in the GrammarSpec
     */
    private String placeHolderName;

    /**
     * Maps the placeholder's
     */
    private Map<String, String> placeHolderTypes;

    /**
     * A list of all parser rule names sorted by their index numbers
     */
    private List<String> parserRuleNames;

    /**
     * A list of all detected placeholders that occur more than once
     */
    private HashSet<String> allMultiplePlaceholders;

    /**
     * The placeholder that caused a runtime exception due to an implausibility
     */
    private String problematicMultiplePlaceholder;

    /**
     * Default Constructor
     */
    public Java7TemplatePlaceholderDetectorListener() {
        super();
        try {
            String uniquePlaceholderStart = "FM_";
            placeHolderName = "PlaceHolder";
            uniqueStart = "fm_";

            Java7TemplateParser parser = new Java7TemplateParser(null);
            Class<? extends Java7TemplateParser> parserClass = parser.getClass();

            Field placeholderNumberField = parserClass.getField(uniquePlaceholderStart + placeHolderName);
            placeholderIndex = placeholderNumberField.getInt(null); // static field

            placeHolderTypes = new HashMap<>();
            parserRuleNames = Arrays.asList(parser.getRuleNames());
            allMultiplePlaceholders = new HashSet<>();

        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitTerminal(TerminalNode node) {

        Token token = node.getSymbol();
        int tokenTypeIndex = token.getType();
        if (tokenTypeIndex == placeholderIndex) {

            // find placeholder type
            int placeholderTypeIndex = ((ParserRuleContext) node.getParent()).getRuleIndex();
            String placeholderType = placeholderIndexToPlaceholderType(placeholderTypeIndex);

            // check whether placeholder already in list
            String placeholderText = token.getText();
            if (placeHolderTypes.containsKey(placeholderText)) {
                allMultiplePlaceholders.add(placeholderText);
                if (!placeHolderTypes.get(placeholderText).equals(placeholderType)) {
                    problematicMultiplePlaceholder = placeholderText;
                    throw new RuntimeException("Expected Types MISMATCH: " + placeholderText + " / "
                        + placeholderType + " vs. " + placeHolderTypes.get(placeholderText));
                }
            } else {
                placeHolderTypes.put(placeholderText, placeholderType);
            }
        }
    }

    /**
     * @param placeholderTypeIndex
     *            The index of the placeholder's rule
     * @return the expected type of the given placeholder rule
     */
    private String placeholderIndexToPlaceholderType(int placeholderTypeIndex) {
        String ruleName = parserRuleNames.get(placeholderTypeIndex);
        String placeHolderType;
        if (ruleName.startsWith(uniqueStart) && ruleName.endsWith(placeHolderName)) {
            placeHolderType = ruleName.replaceFirst(uniqueStart, "");
            placeHolderType = placeHolderType.substring(0, placeHolderType.lastIndexOf(placeHolderName));
        } else {
            System.out.println("Found Placeholder violating naming convention: " + ruleName);
            placeHolderType = "";
        }
        return placeHolderType;
    }

    /**
     * Returns the field 'placeHolderTypes'
     * @return value of placeHolderTypes
     */
    public Map<String, String> getPlaceHolderTypes() {
        return placeHolderTypes;
    }

    /**
     * Returns the field 'allMultiplePlaceholders'
     * @return value of allMultiplePlaceholders
     */
    public HashSet<String> getAllMultiplePlaceholders() {
        return allMultiplePlaceholders;
    }

    /**
     * Returns the field 'problematicMultiplePlaceholder'
     * @return value of problematicMultiplePlaceholder
     */
    public String getProblematicMultiplePlaceholder() {
        return problematicMultiplePlaceholder;
    }
}