package io.github.maybeec.antlr4.generator;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import freemarker.template.TemplateException;
import io.github.maybeec.antlr4.generator.GrammarExtenderCore;
import io.github.maybeec.antlr4.generator.Tactics;

/**
 *
 * @author fkreis (06.05.2016)
 */
public class GrammarExtenderCoreTest {

    /**
     * Test method for
     * {@link io.github.maybeec.antlr4.generator.GrammarExtenderCore#extendGrammar(java.lang.String, java.lang.String, io.github.maybeec.antlr4.generator.Tactics, io.github.maybeec.antlr4.generator.GrammarSpec, java.lang.String)}
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
            GrammarExtenderCore.extendGrammar("src/main/antlr4/Java8.g4", "target/test-out/java8TemplateParser/",
                Tactics.ONLYTOKEN, "src/main/antlr4/SimpleFreeMarker.g4", newGrammarName, uniquePlaceholderStart,
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
