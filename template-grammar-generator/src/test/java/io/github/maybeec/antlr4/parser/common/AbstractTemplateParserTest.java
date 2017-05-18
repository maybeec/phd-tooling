package io.github.maybeec.antlr4.parser.common;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import io.github.maybeec.antlr4.analysis.FreeMarkerInputAnalysis;
import io.github.maybeec.antlr4.generator.GrammarExtenderCore;
import io.github.maybeec.antlr4.generator.Tactics;
import io.github.maybeec.antlr4.parser.TemplateParser;
import io.github.maybeec.antlr4.parser.java7.Java7TemplateParserTest;
import io.github.maybeec.antlr4.parser.java8.Java8TemplateParserTest;

/** Abstract class for common test code. */
public abstract class AbstractTemplateParserTest {

    protected static Class<? extends Parser> parserClass;

    protected static Class<? extends Lexer> lexerClass;

    protected static Class<? extends ParseTreeListener> listenerClass;

    protected static Path parserGrammar;

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
        parserGrammar = GrammarExtenderCore.extendGrammarAndGenerateParser("src/test/antlr4/" + language + ".g4",
            parserSourcesPath, tactic, "src/test/antlr4/SimpleFreeMarker.g4", newGrammarName, metaLangPrefix,
            placeHolderName, targetPackage, "ANY");

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
    protected Lexer newLexer(CodePointCharStream antlrInputStream) throws Exception {
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
            System.out.println("Found placeholders: " + placeholderTypes);
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
    protected ParserRuleContext parse(String parseRule, File file, PredictionMode predictionMode) throws Exception {
        return parse(parseRule, file, predictionMode, false).get(0);
    }

    /**
     * @see #parse(File, PredictionMode, boolean, boolean)
     */
    @SuppressWarnings("javadoc")
    protected List<ParserRuleContext> parseAmbiguities(String parseRule, File file, PredictionMode predictionMode)
        throws Exception {
        return parse(parseRule, file, predictionMode, true);
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
     * @return the parse trees
     * @throws Exception
     *             test fails
     */
    protected List<ParserRuleContext> parse(String parseRule, File file, PredictionMode predictionMode,
        boolean parseAmbiguities) throws Exception {
        // template parsing
        Reader reader = new FileReader(file);
        Lexer lexer = newLexer(CharStreams.fromReader(reader));
        Parser parser = newParser(new CommonTokenStream(lexer));
        try (InputStream grammarStream = Files.newInputStream(parserGrammar)) {
            return new TemplateParser(parser, parserClass.getMethod(parseRule), grammarStream).parse(predictionMode,
                parseAmbiguities);
        }

    }

}
