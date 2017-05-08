package io.github.maybeec.antlr4.parser.java7;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.antlr.parser.java7.Java7Lexer;
import org.antlr.parser.java7.Java7Parser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import io.github.maybeec.antlr4.analysis.ANTLRParseException;
import io.github.maybeec.antlr4.analysis.ErrorListener;
import io.github.maybeec.antlr4.analysis.FreeMarkerInputAnalysis;
import io.github.maybeec.antlr4.templateparser.java7.Java7TemplateLexer;
import io.github.maybeec.antlr4.templateparser.java7.Java7TemplateParser;
import io.github.maybeec.antlr4.templateparser.java7.Java7TemplatePlaceholderDetectorListener;

/**
 *
 * @author fkreis (26.06.2016)
 */
public class Java7TemplateParserTest {

    /**
     * Test method for
     * {@link io.github.maybeec.antlr4.templateparser.java7.Java7TemplateParser#compilationUnit()}.
     * @throws IOException
     *             test fails
     * @throws ExecutionException
     *             test fails
     * @throws InterruptedException
     *             test fails
     */
    @Test
    public final void testCompilationUnit() throws IOException {
        PredictionMode.resetAmbiguityData();

        File template = new File("src/test/resources/templates/java7template.ftl");
        Reader reader = new FileReader(template);
        Java7TemplateLexer lexer = new Java7TemplateLexer(new ANTLRInputStream(reader));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Java7TemplateParser parser = new Java7TemplateParser(tokens);

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

            // Generates the GUI
            // Future<JDialog> future = Trees.inspect(tree, parser); // for ANTLR 4.5.1
            // Utils.waitForClose(future.get());
        } while (PredictionMode.hasNextRun());

        // input data analysis
        Java7Lexer objectLangLexer = new Java7Lexer(null);
        Java7Parser objectLangParser = new Java7Parser(null);
        Map inputData = new HashMap();
        inputData.put("mod", "public");
        inputData.put("fieldname", "iField");

        boolean isValidInput = false;
        for (ParserRuleContext tree : trees) {
            ParseTreeWalker walker = new ParseTreeWalker();
            Java7TemplatePlaceholderDetectorListener listener = new Java7TemplatePlaceholderDetectorListener();
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

        assertTrue(isValidInput);

    }
}
