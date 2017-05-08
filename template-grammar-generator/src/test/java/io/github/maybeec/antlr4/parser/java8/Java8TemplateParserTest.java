package io.github.maybeec.antlr4.parser.java8;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import io.github.maybeec.antlr4.analysis.ANTLRParseException;
import io.github.maybeec.antlr4.analysis.ErrorListener;
import io.github.maybeec.antlr4.analysis.FreeMarkerInputAnalysis;
import io.github.maybeec.antlr4.common.ParserTestUtil;
import io.github.maybeec.antlr4.templateparser.java8.Java8TemplateLexer;
import io.github.maybeec.antlr4.templateparser.java8.Java8TemplateParser;
import io.github.maybeec.antlr4.templateparser.java8.Java8TemplatePlaceholderDetectorListener;

public class Java8TemplateParserTest {

    @Test
    public void parseCompilationUnit_java8_LL_EXACT_AMBIG_parse_ifthenelse() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_ifthenelse.ftl");
        List<ParserRuleContext> trees =
            ParserTestUtil.parseAmbiguities(template, PredictionMode.LL_EXACT_AMBIG_DETECTION, false);
        assertThat(trees).hasSize(1);
    }

    @Test
    public void parseCompilationUnit_java8_LL_EXACT_AMBIG_parse_ifthenelse2() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_ifthenelse2.ftl");
        List<ParserRuleContext> trees =
            ParserTestUtil.parseAmbiguities(template, PredictionMode.LL_EXACT_AMBIG_DETECTION, false);
        assertThat(trees).hasSize(1);
    }

    @Test
    public void parseCompilationUnit_java8_LL_EXACT_AMBIG_parse_ifthenelse_placeholders() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_ifthenelse_placeholders.ftl");
        List<ParserRuleContext> trees =
            ParserTestUtil.parseAmbiguities(template, PredictionMode.LL_EXACT_AMBIG_DETECTION, false);
        assertThat(trees).hasSize(2);
    }

    @Test
    public void parseCompilationUnit_java8_LL_EXACT_AMBIG_parse_field_snippet() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_field_snippet.ftl");
        List<ParserRuleContext> trees =
            ParserTestUtil.parseAmbiguities(template, PredictionMode.LL_EXACT_AMBIG_DETECTION, false);
        assertThat(trees).hasSize(2);
    }

    @Test
    public final void parserCompilationUnit_LL_EXACT_AMIG_parse_loop() throws Exception {
        File template = new File("src/test/resources/templates/java8template.ftl");
        List<ParserRuleContext> trees =
            ParserTestUtil.parseAmbiguities(template, PredictionMode.LL_EXACT_AMBIG_DETECTION, false);
        assertThat(trees).hasSize(2);
    }

    @Test
    public final void parserCompilationUnit_LL_EXACT_AMIG_parse_field_mod_snippet() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_field_mod_snippet.ftl");
        List<ParserRuleContext> trees =
            ParserTestUtil.parseAmbiguities(template, PredictionMode.LL_EXACT_AMBIG_DETECTION, false);
        assertThat(trees).hasSize(2);
    }

    @Test
    public final void parserCompilationUnit_LL_EXACT_AMIG_parse_field_mod_snippet2() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_field_mod_snippet2.ftl");
        List<ParserRuleContext> trees =
            ParserTestUtil.parseAmbiguities(template, PredictionMode.LL_EXACT_AMBIG_DETECTION, false);
        assertThat(trees).hasSize(5);
    }

    @Test
    public final void parserCompilationUnit_LL_EXACT_AMIG_parse_field_initializer_snippet() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_field_initializer_snippet.ftl");
        List<ParserRuleContext> trees =
            ParserTestUtil.parseAmbiguities(template, PredictionMode.LL_EXACT_AMBIG_DETECTION, false);
        assertThat(trees).hasSize(1);
    }

    @Test
    public final void parserCompilationUnit_LL_EXACT_AMIG_parse_java_ambig_with_placeholder() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_java_ambig_with_placeholder.ftl");
        List<ParserRuleContext> trees =
            ParserTestUtil.parseAmbiguities(template, PredictionMode.LL_EXACT_AMBIG_DETECTION, false);
        assertThat(trees).hasSize(1);
    }

    /**
     * Test method for
     * {@link io.github.maybeec.antlr4.templateparser.java8.Java8TemplateParser#compilationUnit()}.
     * @throws IOException
     *             test fails
     */
    @Test
    public final void testCompilationUnit_placeholder_validation() throws Exception {

        PredictionMode.resetAmbiguityData();

        // template parsing
        File template = new File("src/test/resources/templates/java8template.ftl");
        Reader reader = new FileReader(template);
        Java8TemplateLexer lexer = new Java8TemplateLexer(new ANTLRInputStream(reader));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Java8TemplateParser parser = new Java8TemplateParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());
        parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);

        List<ParserRuleContext> trees = new ArrayList<>();
        do {
            ParserRuleContext tree;
            System.out.println("start parsing");
            try {
                tree = parser.compilationUnit();
                trees.add(tree);
            } catch (ANTLRParseException e) {
                fail(e.getMsg());
                break;
            }
            System.out.println("parsing complete");
            parser.reset();
            System.out.println("Number of ambiguities detected: " + PredictionMode.getAmbiguityCounter());
            PredictionMode.updateAmbiguityDataForNextRun();

        } while (PredictionMode.hasNextRun());

        // input data analysis
        Java8TemplateLexer objectLangLexer = new Java8TemplateLexer(null);
        Java8TemplateParser objectLangParser = new Java8TemplateParser(null);

        Map inputData = new HashMap();
        inputData.put("mod", "public");
        inputData.put("fieldname", "iField");

        boolean isValidInput = false;
        for (ParserRuleContext tree : trees) {
            ParseTreeWalker walker = new ParseTreeWalker();
            Java8TemplatePlaceholderDetectorListener listener = new Java8TemplatePlaceholderDetectorListener();
            List<Map<String, String>> placeHolderTypesList = new ArrayList<>();
            walker.walk(listener, tree);
            if (listener.getPlaceHolderTypes() != null) {
                placeHolderTypesList.add(listener.getPlaceHolderTypes());
            }
            isValidInput |= FreeMarkerInputAnalysis.isValidInput(inputData, placeHolderTypesList, objectLangLexer,
                objectLangParser);
            System.out.println(isValidInput ? "Valid input!" : "Invalid...");
        }

        assertThat(isValidInput).as("Is valid input").isTrue();
    }
}
