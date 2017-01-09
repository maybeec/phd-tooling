package c11TemplateParser;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
import io.github.maybeec.parsers.c11.C11Lexer;
import io.github.maybeec.parsers.c11.C11Parser;

/**
 *
 * @author fkreis (26.06.2016)
 */
public class C11TemplateParserTest {

    /**
     * Test method for {@link c11TemplateParser.C11TemplateParser#compilationUnit()}.
     * @throws IOException
     *             test fails
     */
    @Test
    public final void testCompilationUnit() throws IOException {
        File template = new File("src/test/resources/templates/c11template.ftl");
        Reader reader = new FileReader(template);
        C11TemplateLexer lexer = new C11TemplateLexer(new ANTLRInputStream(reader));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        C11TemplateParser parser = new C11TemplateParser(tokens);

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
                fail(e.getMsg());
                break;
            }
            System.out.println("parsing complete");
            parser.reset();
            System.out.println("Number of ambiguities detected: " + PredictionMode.getAmbiguityCounter());
            PredictionMode.updateAmbiguityDataForNextRun();

            // plausibility check
            ParseTreeWalker walker = new ParseTreeWalker();
            C11TemplatePlaceholderDetectorListener listener = new C11TemplatePlaceholderDetectorListener();
            try {
                walker.walk(listener, tree); // walk parse tree
                if (listener.getPlaceHolderTypes() != null) {
                    placeHolderTypesList.add(listener.getPlaceHolderTypes());
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
                continue;
            }
            count++;

            // Generates the GUI
            // Future<JDialog> future = Trees.inspect(tree, parser); // for ANTLR 4.5.1
            // Utils.waitForClose(future.get());
        } while (PredictionMode.hasNextRun());
        System.out.println(count);

        // input data analysis
        C11Lexer objectLangLexer = new C11Lexer(null);
        C11Parser objectLangParser = new C11Parser(null);
        Map inputData = new HashMap();
        inputData.put("number", "1");
        inputData.put("spec", "int");

        boolean isValidInput = (new FreeMarkerInputAnalysis()).isValidInput(inputData, placeHolderTypesList,
            objectLangLexer, objectLangParser);

        assertTrue(isValidInput);

    }

}
