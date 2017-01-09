package grammarExtensionTool;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import freemarker.template.TemplateException;

/**
 *
 * @author fkreis (06.05.2016)
 */
public class GrammarExtenderCoreTest {

    /**
     * Test method for
     * {@link grammarExtensionTool.GrammarExtenderCore#extendGrammar(java.lang.String, java.lang.String, grammarExtensionTool.Tactics, grammarExtensionTool.GrammarSpec, java.lang.String)}
     * .
     */
    @Test
    public void testExtendGrammar() {

        // define template grammar properties
        String newGrammarName = "Java8Template";
        String uniquePlaceholderStart = "FM_";
        String placeHolderName = "PlaceHolder";
        String uniqueStart = "fm_";

        // tranform grammar
        try {
            GrammarExtenderCore.extendGrammar("src/test/resources/grammars/Java8.g4",
                "src/main/java/java8TemplateParser/", Tactics.ONLYTOKEN,
                "src/test/resources/grammars/SimpleFreeMarker.g4", newGrammarName, uniquePlaceholderStart,
                uniqueStart, placeHolderName);
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.getMessage());
        } catch (TemplateException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

}
