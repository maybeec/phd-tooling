package io.github.maybeec.antlr4.parser.common;

import static org.junit.Assert.fail;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import io.github.maybeec.antlr4.analysis.ANTLRParseException;
import io.github.maybeec.antlr4.analysis.ErrorListener;
import io.github.maybeec.antlr4.analysis.FreeMarkerInputAnalysis;
import io.github.maybeec.antlr4.generator.GrammarExtenderCore;
import io.github.maybeec.antlr4.generator.Tactics;
import io.github.maybeec.antlr4.parser.java7.Java7TemplateParserTest;
import io.github.maybeec.antlr4.parser.java8.Java8TemplateParserTest;

/** Abstract class for common test code. */
public abstract class AbstractTemplateParserTest {

    /** If true, all runs will be printed to png into the project root */
    private static final boolean PRINT_TO_PNG = false;

    /** If true, all runs will be printed to eps into the project root */
    private static final boolean PRINT_EPS = false;

    protected static Class<? extends Parser> parserClass;

    protected static Class<? extends Lexer> lexerClass;

    protected static Class<? extends ParseTreeListener> listenerClass;

    /**
     * Generates and loads the parser
     * @param language
     * @param tactic
     * @throws Exception
     */
    protected static void generateAndLoadParser(String language, Tactics tactic) throws Exception {
        // define template grammar properties
        String newGrammarName = language + "Template";
        String placeHolderName = "PLACEHOLDER";
        String metaLangPrefix = "fm_";
        String targetPackage = "io.github.maybeec.antlr4.templateparser." + language.toLowerCase();

        // transform grammar
        String parserSourcesPath = "target/generated-test-sources/antlr4/" + targetPackage.replace(".", "/") + "/";
        GrammarExtenderCore.extendGrammar("src/test/antlr4/" + language + ".g4", parserSourcesPath, tactic,
            "src/test/antlr4/SimpleFreeMarker.g4", newGrammarName, metaLangPrefix, placeHolderName, targetPackage,
            "ANY");

        String projectPath = Java8TemplateParserTest.class.getResource("").getPath().replaceFirst("/target.*", "/");
        String generatedAntlr4SrcPath = projectPath + parserSourcesPath;
        String parserBuildPath = projectPath + "target/test-classes/" + targetPackage.replace(".", "/") + "/";

        Boolean compiled = compileAndLoadParserClasses(generatedAntlr4SrcPath, parserBuildPath);

        // retrieve necessary classes
        if (compiled != null && compiled) {
            parserClass = (Class<? extends Parser>) AbstractTemplateParserTest.class.getClassLoader()
                .loadClass(targetPackage + "." + newGrammarName + "Parser");
            lexerClass = (Class<? extends Lexer>) AbstractTemplateParserTest.class.getClassLoader()
                .loadClass(targetPackage + "." + newGrammarName + "Lexer");
            listenerClass = (Class<? extends ParseTreeListener>) AbstractTemplateParserTest.class.getClassLoader()
                .loadClass(targetPackage + "." + newGrammarName + "PlaceholderDetectorListener");
        } else {
            fail("could not compile generated Java7 Template Parser");
        }
    }

    /**
     * Compiles the generated ANTLR4 sources to the build path and loads them to the test loading class
     * loader.
     * @param srcPath
     *            source path to be compiled
     * @param buildPath
     *            build path to be compiled to
     * @return see return type of {@link CompilationTask#call()}
     */
    private static Boolean compileAndLoadParserClasses(String srcPath, String buildPath) throws Exception {
        // compile generated template parser
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, Charset.forName("UTF-8"));
        Iterable<? extends JavaFileObject> compilationUnits =
            fileManager.getJavaFileObjectsFromFiles(Arrays.asList(new File(srcPath).listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".java");
                }
            })));

        List<String> compilerOptions = new ArrayList<>();
        compilerOptions.add("-d");
        compilerOptions.add(buildPath);
        new File(buildPath).mkdirs();
        Boolean compiled = compiler.getTask(null, fileManager, null, compilerOptions, null, compilationUnits).call();

        // add compiled sources to class path
        ClassLoader cl = Java7TemplateParserTest.class.getClassLoader();
        Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
        method.setAccessible(true);
        method.invoke(cl, new Object[] { new File(buildPath).toURL() });
        return compiled;
    }

    /**
     * Creates a new parser with the given token stream
     * @param tokens
     *            token stream
     * @return the parser instance
     * @throws Exception
     *             if anything fails
     */
    protected Parser newParser(CommonTokenStream tokens) throws Exception {
        Constructor<? extends Parser> parserConstructor = parserClass.getConstructor(TokenStream.class);
        return parserConstructor.newInstance(tokens);
    }

    /**
     * Creates a new lexer instance with the given input stream
     * @param antlrInputStream
     *            input stream
     * @return the lexer instance
     * @throws Exception
     *             if anything fails
     */
    protected Lexer newLexer(ANTLRInputStream antlrInputStream) throws Exception {
        Constructor<? extends Lexer> lexerConstructor = lexerClass.getConstructor(CharStream.class);
        return lexerConstructor.newInstance(antlrInputStream);
    }

    /**
     * Returns the placeholder types collected by the PlaceholderDectectionListener of the generated parser.
     * @param listener
     *            generated and instantiated PlaceholderDetectionListener
     * @return the collected placeholder types
     */
    protected Map<String, String> getPlaceholderTypes(ParseTreeListener listener) throws Exception {
        Method getPlaceholderTypesMethod = listenerClass.getMethod("getPlaceHolderTypes");
        return (Map<String, String>) getPlaceholderTypesMethod.invoke(listener);
    }

    /**
     * Checks if the given input matches any parse tree
     * @param trees
     *            parse trees to be checked
     * @param inputData
     *            input data to be processed by the template engine
     * @return <code>true</code> if the input is a valid input for at least one parse tree
     * @throws Exception
     *             if anything fails
     */
    protected boolean isValidInput(List<ParserRuleContext> trees, Map inputData) throws Exception {
        boolean isValidInput = false;
        Lexer lexer = newLexer(null);
        Parser parser = newParser(null);
        for (ParserRuleContext tree : trees) {
            ParseTreeWalker walker = new ParseTreeWalker();
            ParseTreeListener listener = listenerClass.newInstance();
            List<Map<String, String>> placeHolderTypesList = new ArrayList<>();
            walker.walk(listener, tree);
            Map<String, String> placeholderTypes = getPlaceholderTypes(listener);
            if (placeholderTypes != null) {
                placeHolderTypesList.add(placeholderTypes);
            }
            isValidInput |= FreeMarkerInputAnalysis.isValidInput(inputData, placeHolderTypesList, lexer, parser);
            System.out.println(isValidInput ? "Valid input!" : "Invalid...");
            if (isValidInput) {
                break;
            }
        }
        return isValidInput;
    }

    /**
     * @see #parse(File, PredictionMode, boolean, boolean)
     */
    @SuppressWarnings("javadoc")
    protected ParserRuleContext parse(File file, PredictionMode predictionMode, boolean debug) throws Exception {
        return parse(file, predictionMode, false, debug).get(0);
    }

    /**
     * @see #parse(File, PredictionMode, boolean, boolean)
     */
    @SuppressWarnings("javadoc")
    protected List<ParserRuleContext> parseAmbiguities(File file, PredictionMode predictionMode, boolean debug)
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
    protected List<ParserRuleContext> parse(File file, PredictionMode predictionMode, boolean parseAmbiguities,
        boolean debug) throws Exception {
        PredictionMode.resetAmbiguityData();

        // template parsing
        Reader reader = new FileReader(file);
        Lexer lexer = newLexer(new ANTLRInputStream(reader));
        Parser parser = newParser(new CommonTokenStream(lexer));

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
                Method parseMethod = parserClass.getMethod("compilationUnit");
                tree = (ParserRuleContext) parseMethod.invoke(parser);
                trees.add(tree);
            } catch (ANTLRParseException e) {
                System.out.println("parsing not successfull!");
                System.err.println(e.getMsg());
                e.printStackTrace();
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

            printToFile(file, parser, count, tree);

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
    private static void printToFile(File file, Parser parser, int count, ParserRuleContext tree) throws Exception {
        String fileName = file.getName() + "_" + count;
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
