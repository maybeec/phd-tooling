package java8TemplateParser;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import antlr4Parser.ANTLRParseException;
import antlr4Parser.ErrorListener;
import freeMarkerInputAnalysis.FreeMarkerInputAnalysis;
import io.github.maybeec.parsers.java8.Java8Lexer;
import io.github.maybeec.parsers.java8.Java8Parser;

/**
 *
 * @author fkreis (26.06.2016)
 */
public class Java8TemplateParserTest {

    /**
     * Test method for {@link java8TemplateParser.Java8TemplateParser#compilationUnit()}.
     * @throws IOException
     *             test fails
     */
    @Test
    public final void testCompilationUnit() throws IOException {

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
        int count = 0;
        do {
            ParserRuleContext tree;
            System.out.println("start parsing");
            try {
                tree = parser.compilationUnit();
            } catch (ANTLRParseException e) {
                System.out.println("parsing not successfull!");
                System.out.println(e.getMsg());
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
            count++;

            // Generates the GUI
            // Future<JDialog> future = Trees.inspect(tree, parser); // for ANTLR 4.5.1
            // Utils.waitForClose(future.get());
        } while (PredictionMode.hasNextRun());
        System.out.println(count);

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
