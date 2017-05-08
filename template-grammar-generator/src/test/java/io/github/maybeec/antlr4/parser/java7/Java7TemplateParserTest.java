package io.github.maybeec.antlr4.parser.java7;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.antlr.parser.java7.Java7Lexer;
import org.antlr.parser.java7.Java7Parser;
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
import org.junit.BeforeClass;
import org.junit.Test;

import io.github.maybeec.antlr4.analysis.ANTLRParseException;
import io.github.maybeec.antlr4.analysis.ErrorListener;
import io.github.maybeec.antlr4.analysis.FreeMarkerInputAnalysis;
import io.github.maybeec.antlr4.generator.GrammarExtenderCore;
import io.github.maybeec.antlr4.generator.Tactics;

public class Java7TemplateParserTest {

    private static Class<? extends Parser> parserClass;

    private static Class<? extends Lexer> lexerClass;

    private static Class<? extends ParseTreeListener> listenerClass;

    @BeforeClass
    public static void generateJava7Parser() throws Exception {
        // define template grammar properties
        String newGrammarName = "Java7Template";
        String placeHolderName = "PLACEHOLDER";
        String metaLangPrefix = "fm_";
        String targetPackage = "io.github.maybeec.antlr4.templateparser.java7";
        Tactics customTactic = Tactics.ALL_PARSER_CUSTOM_LEXER;
        HashSet<String> tokenNames = new HashSet<>();
        tokenNames.add("Identifier");
        customTactic.addTokens(tokenNames);

        // transform grammar
        String parserSourcesPath = "target/generated-sources/antlr4/" + targetPackage.replace(".", "/") + "/";
        GrammarExtenderCore.extendGrammar("src/main/antlr4/Java7.g4", parserSourcesPath, customTactic,
            "src/main/antlr4/SimpleFreeMarker.g4", newGrammarName, metaLangPrefix, placeHolderName, targetPackage,
            "ANY");

        String projectPath = Java7TemplateParserTest.class.getResource("").getPath().replaceFirst("/target.*", "/");
        String generatedAntlr4SrcPath = projectPath + parserSourcesPath;
        String parserBuildPath = projectPath + "target/classes/" + targetPackage.replace(".", "/") + "/";

        // compile generated template parser
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, Charset.forName("UTF-8"));
        Iterable<? extends JavaFileObject> compilationUnits = fileManager
            .getJavaFileObjectsFromFiles(Arrays.asList(new File(generatedAntlr4SrcPath).listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".java");
                }
            })));

        List<String> compilerOptions = new ArrayList<>();
        compilerOptions.add("-d");
        compilerOptions.add(parserBuildPath);
        new File(parserBuildPath).mkdirs();
        Boolean compiled = compiler.getTask(null, fileManager, null, compilerOptions, null, compilationUnits).call();

        // add compiled sources to class path
        ClassLoader cl = Java7TemplateParserTest.class.getClassLoader();
        Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
        method.setAccessible(true);
        method.invoke(cl, new Object[] { new File(parserBuildPath).toURL() });

        // retrieve necessary classes
        if (compiled != null && compiled) {
            parserClass = (Class<? extends Parser>) Java7TemplateParserTest.class.getClassLoader()
                .loadClass(targetPackage + "." + newGrammarName + "Parser");
            lexerClass = (Class<? extends Lexer>) Java7TemplateParserTest.class.getClassLoader()
                .loadClass(targetPackage + "." + newGrammarName + "Lexer");
            listenerClass = (Class<? extends ParseTreeListener>) Java7TemplateParserTest.class.getClassLoader()
                .loadClass(targetPackage + "." + newGrammarName + "PlaceholderDetectorListener");
        } else {
            fail("could not compile generated Java7 Template Parser");
        }

    }

    /**
     * Test method for
     * {@link io.github.maybeec.antlr4.templateparser.java7.Java7TemplateParser#compilationUnit()}.
     * @throws IOException
     *             test fails
     */
    @Test
    public final void testCompilationUnit_placeholder_validation() throws Exception {
        PredictionMode.resetAmbiguityData();

        File template = new File("src/test/resources/templates/java7template.ftl");
        Reader reader = new FileReader(template);
        Constructor<? extends Lexer> lexerConstructor = lexerClass.getConstructor(CharStream.class);
        Lexer lexer = lexerConstructor.newInstance(new ANTLRInputStream(reader));

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Constructor<? extends Parser> parserConstructor = parserClass.getConstructor(TokenStream.class);
        Parser parser = parserConstructor.newInstance(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());
        parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);

        List<ParserRuleContext> trees = new ArrayList<>();
        do {
            ParserRuleContext tree;
            System.out.println("start parsing");
            try {
                Method parseMethod = parserClass.getMethod("compilationUnit");
                tree = (ParserRuleContext) parseMethod.invoke(parser);
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
            ParseTreeListener listener = listenerClass.newInstance();
            List<Map<String, String>> placeHolderTypesList = new ArrayList<>();
            walker.walk(listener, tree);
            Method getPlaceholderTypesMethod = listenerClass.getMethod("getPlaceHolderTypes");
            Map<String, String> placeholderTypes = (Map<String, String>) getPlaceholderTypesMethod.invoke(listener);
            if (placeholderTypes != null) {
                placeHolderTypesList.add(placeholderTypes);
            }
            isValidInput |= FreeMarkerInputAnalysis.isValidInput(inputData, placeHolderTypesList, objectLangLexer,
                objectLangParser);
            System.out.println(isValidInput ? "Valid input!" : "Invalid...");
            if (isValidInput) {
                break;
            }
        }

        assertThat(isValidInput).as("Is valid input").isTrue();
    }
}
