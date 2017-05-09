package io.github.maybeec.antlr4.parser.java7;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.junit.BeforeClass;
import org.junit.Test;

import io.github.maybeec.antlr4.generator.Tactics;
import io.github.maybeec.antlr4.parser.common.AbstractTemplateParserTest;

public class Java7TemplateParserTest extends AbstractTemplateParserTest {

    @BeforeClass
    public static void generateJava7Parser() throws Exception {
        Tactics customTactic = Tactics.ALL_PARSER_CUSTOM_LEXER;
        HashSet<String> tokenNames = new HashSet<>();
        tokenNames.add("Identifier");
        customTactic.addTokens(tokenNames);

        generateAndLoadParser("Java7", customTactic);
    }

    /**
     * Test method for
     * {@link io.github.maybeec.antlr4.templateparser.java7.Java7TemplateParser#compilationUnit()}.
     * @throws IOException
     *             test fails
     */
    @Test
    public final void testCompilationUnit_placeholder_validation() throws Exception {
        PredictionMode.resetAmbiguityData();

        File template = new File("src/test/resources/templates/java7template.ftl");
        List<ParserRuleContext> trees = parseAmbiguities(template, PredictionMode.LL_EXACT_AMBIG_DETECTION, false);

        // input data analysis
        Map inputData = new HashMap();
        inputData.put("mod", "public");
        inputData.put("fieldname", "iField");

        boolean isValidInput = isValidInput(trees, inputData);
        assertThat(isValidInput).as("Is valid input").isTrue();
    }

}
