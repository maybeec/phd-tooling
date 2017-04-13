package io.github.maybeec.antlr4.common;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import javax.swing.JFrame;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.PredictionMode;

import io.github.maybeec.antlr4.analysis.ANTLRParseException;
import io.github.maybeec.antlr4.analysis.ErrorListener;
import io.github.maybeec.antlr4.templateparser.java8.Java8TemplateLexer;
import io.github.maybeec.antlr4.templateparser.java8.Java8TemplateParser;

/**
 * Test Util class for parser tests.
 */
public class ParserTestUtil {

    private static boolean printToFile = false;

    /**
     * @see #parse(File, PredictionMode, boolean, boolean)
     */
    @SuppressWarnings("javadoc")
    public static ParserRuleContext parse(File file, PredictionMode predictionMode, boolean debug) throws Exception {
        return parse(file, predictionMode, false, debug).get(0);
    }

    /**
     * @see #parse(File, PredictionMode, boolean, boolean)
     */
    @SuppressWarnings("javadoc")
    public static List<ParserRuleContext> parseAmbiguities(File file, PredictionMode predictionMode, boolean debug)
        throws Exception {
        return parse(file, predictionMode, true, debug);
    }

    /**
     * Parse a java file with the given prediction mode and return the parse trees. If debug is enabled, the
     * test blocks to show the parsed trees in a UI view.
     * @param file
     *            to be parsed
     * @param predictionMode
     *            prediction mode to be used for parsing.
     * @param parseAmbiguities
     *            states if ambiguities should be parsed as well
     * @param debug
     *            if true, the test blocks for each parsed tree and shows it in a graph UI for debugging.
     * @return the parse trees
     * @throws Exception
     *             test fails
     */
    public static List<ParserRuleContext> parse(File file, PredictionMode predictionMode, boolean parseAmbiguities,
        boolean debug) throws Exception {
        PredictionMode.resetAmbiguityData();

        // template parsing
        Reader reader = new FileReader(file);
        Java8TemplateLexer lexer = new Java8TemplateLexer(new ANTLRInputStream(reader));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Java8TemplateParser parser = new Java8TemplateParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());
        parser.getInterpreter().setPredictionMode(predictionMode);

        List<ParserRuleContext> trees = new ArrayList<>();
        int count = 0;
        long start = System.nanoTime();
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

            if (parseAmbiguities) {
                parser.reset();
                System.out.println("Number of ambiguities detected: " + PredictionMode.getAmbiguityCounter());
                PredictionMode.updateAmbiguityDataForNextRun();
            }
            count++;

            if (printToFile) {
                Trees.save(tree, parser, file.getName() + "_" + count + ".ps", "Calibri", 8);
            }

            // Generates the GUI
            if (debug) {
                Future<JFrame> future = Trees.inspect(tree, parser);
                while (future.get().isVisible()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        } while (parseAmbiguities && PredictionMode.hasNextRun());
        long end = System.nanoTime();

        System.out.println(count + " trees parsed in " + ((end - start) / Math.pow(10, 9)) + "s");
        return trees;
    }
}
