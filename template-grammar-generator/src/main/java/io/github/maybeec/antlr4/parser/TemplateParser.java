package io.github.maybeec.antlr4.parser;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.IntStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.PredictionMode;

import io.github.maybeec.antlr4.analysis.ANTLRParseException;
import io.github.maybeec.antlr4.analysis.ErrorListener;

public class TemplateParser<P extends Parser> {

    /** If true, all parser runs will be printed to png into the project root */
    private static final boolean PRINT_TO_PNG = false;

    /** If true, all parser runs will be printed to eps into the project root */
    private static final boolean PRINT_EPS = false;

    /** If true, all parser runs will trigger the blocking ANTLR4 graph UI to show the parse tree */
    private static final boolean DEBUG_SHOW_BLOCKING_UI = false;

    private P parser;

    private Method parseRule;

    private String grammar;

    public TemplateParser(P target, Method parseRule, InputStream grammar) throws IOException {
        parser = target;
        this.parseRule = parseRule;
        try (InputStreamReader inputStreamReader = new InputStreamReader(grammar);
            BufferedReader buffer = new BufferedReader(inputStreamReader)) {
            this.grammar = buffer.lines().collect(Collectors.joining("\n"));
        }
    }

    /**
     * @see #parse(PredictionMode, boolean, boolean)
     */
    @SuppressWarnings("javadoc")
    public ParserRuleContext parse(PredictionMode predictionMode) throws Exception {
        return parse(predictionMode, false).get(0);
    }

    /**
     * @see #parse(PredictionMode, boolean, boolean)
     */
    @SuppressWarnings("javadoc")
    public List<ParserRuleContext> parseAmbiguities(PredictionMode predictionMode) throws Exception {
        return parse(predictionMode, true);
    }

    /**
     * Parse a java file with the given prediction mode and return the parse trees. If debug is enabled, the
     * test blocks to show the parsed trees in a UI view.
     * @param predictionMode
     *            prediction mode to be used for parsing.
     * @param parseAmbiguities
     *            states if ambiguities should be parsed as well
     * @return the parse trees
     * @throws Exception
     *             test fails
     */
    public List<ParserRuleContext> parse(PredictionMode predictionMode, boolean parseAmbiguities) throws Exception {
        long start = System.nanoTime();
        PredictionMode.resetAmbiguityData();

        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());
        parser.getInterpreter().setPredictionMode(predictionMode);

        List<ParserRuleContext> trees = new ArrayList<>();
        int count = 0;
        Map<String, String> listPatterns = new ListPatternCollector(grammar).detectListPatternInstantiations();
        ListPatternTransformer transformer = new ListPatternTransformer(listPatterns);
        do {
            ParserRuleContext tree;
            System.out.println("start parsing");
            boolean errorneous = false;
            try {
                tree = (ParserRuleContext) parseRule.invoke(parser);
                // System.out.println(tree.toStringTree(parser));
                transformer.transform(tree);
                // System.out.println("after transformation:");
                // System.out.println(tree.toStringTree(parser));
                trees.add(tree);

                System.out.println("parsing complete");
                count++;

                printToFile(parser, count, tree);

                // Generates the GUI
                if (DEBUG_SHOW_BLOCKING_UI) {
                    Future<JFrame> future = Trees.inspect(tree, parser);
                    while (future.get().isVisible()) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                        }
                    }
                }

            } catch (InvocationTargetException e) {
                if (e.getCause() instanceof ANTLRParseException) {
                    System.out.println("!!! parsing not successfull!");
                    System.err.println(((ANTLRParseException) e.getCause()).getMsg());
                    throw (ANTLRParseException) e.getCause();
                } else {
                    System.out.println("!!! undefined parsing error");
                    throw e;
                }
                // errorneous = true;
                // e.printStackTrace();
                // throw e;
            }
            if (parseAmbiguities) {
                parser.reset();
                System.out.println("Number of ambiguities detected: " + PredictionMode.getAmbiguityCounter());
                PredictionMode.updateAmbiguityDataForNextRun(true);
            }
        } while (parseAmbiguities && PredictionMode.hasNextRun());

        long end = System.nanoTime();

        System.out.println(count + " trees parsed in " + ((end - start) / Math.pow(10, 9)) + "s");
        return trees;
    }

    /**
     * Prints eps as well as png files for a given tree.
     * @param parser
     *            the tree is parsed from
     * @param count
     *            running counter for file naming
     * @param tree
     *            to be printed
     * @throws Exception
     *             if anything went wrong
     */
    private static void printToFile(Parser parser, int count, ParserRuleContext tree) throws Exception {
        String fileName = (!parser.getSourceName().equals(IntStream.UNKNOWN_SOURCE_NAME) ? parser.getSourceName()
            : parser.getGrammarFileName()) + "_" + count;
        if (PRINT_EPS) {
            Trees.save(tree, parser, fileName + ".eps", "Calibri", 8);
        }

        if (PRINT_TO_PNG) {
            TreeViewer treeViewer = new TreeViewer(new ArrayList<>(Arrays.asList(parser.getRuleNames())), tree);
            Future<JFrame> future = treeViewer.open();
            future.get();

            BufferedImage bi = new BufferedImage(treeViewer.getPreferredSize().width,
                treeViewer.getPreferredSize().height, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            treeViewer.paint(g);
            g.dispose();
            ImageIO.write(bi, "png", new File(fileName + ".png"));

            future.cancel(true);
        }
    }
}
