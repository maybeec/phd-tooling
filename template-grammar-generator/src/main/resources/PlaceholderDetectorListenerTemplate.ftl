package ${package};

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
public class ${newGrammarName}PlaceholderDetectorListener extends ${newGrammarName}BaseListener {

    /** Index for placeholder token definition */
    private int placeholderIndex;

    /** Unique rule prefix as defined in the GrammarSpec */
    private String metaLangRulePrefix;

    /** The placeholder rule's name as defined in the GrammarSpec */
    private String placeHolderSuffix;

    /** Maps the placeholder's */
    private Map<String, String> placeHolderTypes;

    /** A list of all parser rule names sorted by their index numbers */
    private List<String> parserRuleNames;

    /** A list of all detected placeholders that occur more than once */
    private HashSet<String> allMultiplePlaceholders;

    /** The placeholder that caused a runtime exception due to an implausibility */
    private String problematicMultiplePlaceholder;

    /**
     * Default Constructor
     */
    public ${newGrammarName}PlaceholderDetectorListener() {
        super();
        try {
            String metaLangPlaceholderPrefix = "${metaLangLexerRulePrefix}";
            placeHolderSuffix = "${placeHolderLabel}";
            metaLangRulePrefix = "${metaLangParserRulePrefix}";

            ${newGrammarName}Parser parser = new ${newGrammarName}Parser(null);
            Class<? extends ${newGrammarName}Parser> parserClass = parser.getClass();

            Field placeholderNumberField = parserClass.getField(metaLangPlaceholderPrefix + placeHolderSuffix);
            placeholderIndex = placeholderNumberField.getInt(null); // static field

            placeHolderTypes = new HashMap<>();
            parserRuleNames = Arrays.asList(parser.getRuleNames());
            allMultiplePlaceholders = new HashSet<>();

        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
    }

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
        if (ruleName.startsWith(metaLangRulePrefix) && ruleName.endsWith(placeHolderSuffix)) {
            placeHolderType = ruleName.replaceFirst(metaLangRulePrefix, "");
            placeHolderType = placeHolderType.substring(0, placeHolderType.lastIndexOf(placeHolderSuffix));
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