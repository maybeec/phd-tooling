package io.github.maybeec.antlr4.parser.java8;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.antlr.parser.java8.Java8Lexer;
import org.antlr.parser.java8.Java8Parser;
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

        List<Map<String, String>> placeHolderTypesList = new LinkedList<>();
        List<ParserRuleContext> trees = new ArrayList<>();
        do {
            ParserRuleContext tree;
            System.out.println("start parsing");
            try {
                tree = parser.compilationUnit();
                trees.add(tree);
            } catch (ANTLRParseException e) {
                System.out.println("parsing not successfull!");
                System.err.println(e.getMsg());
                fail(e.getMsg());
                break;
            }
            System.out.println("parsing complete");
            parser.reset();
            System.out.println("Number of ambiguities detected: " + PredictionMode.getAmbiguityCounter());
            PredictionMode.updateAmbiguityDataForNextRun();

            // plausibility check
            ParseTreeWalker walker = new ParseTreeWalker();
            Java8TemplatePlaceholderDetectorListener listener = new Java8TemplatePlaceholderDetectorListener();
            try {
                walker.walk(listener, tree); // walk parse tree
                if (listener.getPlaceHolderTypes() != null) {
                    placeHolderTypesList.add(listener.getPlaceHolderTypes());
                }
            } catch (RuntimeException e) {
                // e.printStackTrace();
                continue;
            }

            // Generates the GUI
            // Future<JFrame> future = Trees.inspect(tree, parser);
            // while (future.get().isVisible()) {
            // try {
            // Thread.sleep(100);
            // } catch (InterruptedException e) {
            // }
            // }
        } while (PredictionMode.hasNextRun());

        // input data analysis
        Java8Lexer objectLangLexer = new Java8Lexer(null);
        Java8Parser objectLangParser = new Java8Parser(null);
        Map inputData = new HashMap();
        inputData.put("mod", "public");
        inputData.put("fieldname", "iField");

        boolean isValidInput = (new FreeMarkerInputAnalysis()).isValidInput(inputData, placeHolderTypesList,
            objectLangLexer, objectLangParser);

        assertTrue(isValidInput);
    }
}
