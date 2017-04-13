package io.github.maybeec.antlr4.common;

import static org.junit.Assert.fail;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.antlr.v4.gui.TreeViewer;
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

    /** If true, all runs will be printed to eps and png into the project root */
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
                printToFile(file, parser, count, tree);
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

    /**
     * Prints eps as well as png files for a given tree.
     * @param file
     *            to retrieve the filename from
     * @param parser
     *            the tree is parsed from
     * @param count
     *            running counter for file naming
     * @param tree
     *            to be printed
     * @throws Exception
     *             if anything went wrong
     */
    private static void printToFile(File file, Java8TemplateParser parser, int count, ParserRuleContext tree)
        throws Exception {
        String fileName = file.getName() + "_" + count;
        Trees.save(tree, parser, fileName + ".eps", "Calibri", 8);

        TreeViewer treeViewer = new TreeViewer(new ArrayList<>(Arrays.asList(parser.getRuleNames())), tree);
        Future<JFrame> future = treeViewer.open();
        future.get();

        BufferedImage bi = new BufferedImage(treeViewer.getPreferredSize().width, treeViewer.getPreferredSize().height,
            BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        treeViewer.paint(g);
        g.dispose();
        ImageIO.write(bi, "png", new File(fileName + ".png"));

        future.cancel(true);
    }
}
