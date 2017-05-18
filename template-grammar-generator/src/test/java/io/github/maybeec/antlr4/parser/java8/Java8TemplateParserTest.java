package io.github.maybeec.antlr4.parser.java8;

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

public class Java8TemplateParserTest extends AbstractTemplateParserTest {

    @BeforeClass
    public static void generateJava8Parser() throws Exception {
        Tactics customTactic = Tactics.ALL_PARSER_CUSTOM_LEXER;
        HashSet<String> tokenNames = new HashSet<>();
        tokenNames.add("Identifier");
        customTactic.addTokens(tokenNames);

        generateAndLoadParser("Java8", customTactic);
    }

    @Test
    public void testCompilationUnit_parse_ifthenelse() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_ifthenelse.ftl");
        List<ParserRuleContext> trees =
            parseAmbiguities("compilationUnit", template, PredictionMode.LL_EXACT_AMBIG_DETECTION);
        assertThat(trees).hasSize(1);
    }

    @Test
    public void testCompilationUnit_parse_ifthenelse2() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_ifthenelse2.ftl");
        List<ParserRuleContext> trees =
            parseAmbiguities("compilationUnit", template, PredictionMode.LL_EXACT_AMBIG_DETECTION);
        assertThat(trees).hasSize(1);
    }

    @Test
    public void testCompilationUnit_parse_ifthenelse_placeholders() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_ifthenelse_placeholders.ftl");
        List<ParserRuleContext> trees =
            parseAmbiguities("compilationUnit", template, PredictionMode.LL_EXACT_AMBIG_DETECTION);
        assertThat(trees).hasSize(2);
    }

    @Test
    public void testCompilationUnit_parse_field_snippet() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_field_snippet.ftl");
        List<ParserRuleContext> trees =
            parseAmbiguities("compilationUnit", template, PredictionMode.LL_EXACT_AMBIG_DETECTION);
        assertThat(trees).hasSize(2);
    }

    @Test
    public void testCompilationUnit_parse_loop() throws Exception {
        File template = new File("src/test/resources/templates/java8template.ftl");
        List<ParserRuleContext> trees =
            parseAmbiguities("compilationUnit", template, PredictionMode.LL_EXACT_AMBIG_DETECTION);
        assertThat(trees).hasSize(2);
    }

    @Test
    public void testCompilationUnit_parse_field_mod_snippet() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_field_mod_snippet.ftl");
        List<ParserRuleContext> trees =
            parseAmbiguities("compilationUnit", template, PredictionMode.LL_EXACT_AMBIG_DETECTION);
        assertThat(trees).hasSize(2);
    }

    @Test
    public void testCompilationUnit_parse_field_mod_snippet2() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_field_mod_snippet2.ftl");
        List<ParserRuleContext> trees =
            parseAmbiguities("compilationUnit", template, PredictionMode.LL_EXACT_AMBIG_DETECTION);
        assertThat(trees).hasSize(5);
    }

    @Test
    public void testCompilationUnit_parse_field_initializer_snippet() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_field_initializer_snippet.ftl");
        List<ParserRuleContext> trees =
            parseAmbiguities("compilationUnit", template, PredictionMode.LL_EXACT_AMBIG_DETECTION);
        assertThat(trees).hasSize(1);
    }

    @Test
    public void testCompilationUnit_parse_java_ambig_with_placeholder() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_java_ambig_with_placeholder.ftl");
        List<ParserRuleContext> trees =
            parseAmbiguities("compilationUnit", template, PredictionMode.LL_EXACT_AMBIG_DETECTION);
        assertThat(trees).hasSize(1);
    }

    @Test
    public void testCompilationUnit_parse_java_imports() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_java_imports.ftl");
        List<ParserRuleContext> trees =
            parseAmbiguities("compilationUnit", template, PredictionMode.LL_EXACT_AMBIG_DETECTION);
        assertThat(trees).hasSize(1);
    }

    @Test
    public void testCompilationUnit_parse_java_methodinvocation() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_java_methodinvokation.ftl");
        List<ParserRuleContext> trees = parseAmbiguities("compilationUnit", template, PredictionMode.LL);
        assertThat(trees).hasSize(1);
    }

    @Test
    public void testCompilationUnit_parse_mult_package_substitution() throws Exception {

        File template = new File("src/test/resources/templates/java8template_mult_package_substitution.ftl");
        List<ParserRuleContext> trees =
            parseAmbiguities("compilationUnit", template, PredictionMode.LL_EXACT_AMBIG_DETECTION);
        assertThat(trees).hasSize(1);
    }

    /**
     * Test method for
     * {@link io.github.maybeec.antlr4.templateparser.java8.Java8TemplateParser#compilationUnit()}.
     * @throws IOException
     *             test fails
     */
    @Test
    public void testCompilationUnit_placeholder_validation_mult_package_substitution() throws Exception {

        File template = new File("src/test/resources/templates/java8template_mult_package_substitution.ftl");
        List<ParserRuleContext> trees =
            parseAmbiguities("compilationUnit", template, PredictionMode.LL_EXACT_AMBIG_DETECTION);

        Map inputData = new HashMap();
        inputData.put("c", "a.b.c");
        inputData.put("b", "e");

        boolean isValidInput = isValidInput(trees, inputData);
        assertThat(isValidInput).as("Is valid input").isTrue();
    }

    /**
     * Test method for
     * {@link io.github.maybeec.antlr4.templateparser.java8.Java8TemplateParser#compilationUnit()}.
     * @throws IOException
     *             test fails
     */
    @Test
    public void testCompilationUnit_placeholder_validation() throws Exception {

        File template = new File("src/test/resources/templates/java8template.ftl");
        List<ParserRuleContext> trees =
            parseAmbiguities("compilationUnit", template, PredictionMode.LL_EXACT_AMBIG_DETECTION);

        Map inputData = new HashMap();
        inputData.put("mod", "public");
        inputData.put("fieldname", "iField");

        boolean isValidInput = isValidInput(trees, inputData);
        assertThat(isValidInput).as("Is valid input").isTrue();
    }
}
