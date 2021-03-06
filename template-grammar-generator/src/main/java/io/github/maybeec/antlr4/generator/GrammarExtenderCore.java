package io.github.maybeec.antlr4.generator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.antlr.parser.antlr4.ANTLRv4Lexer;
import org.antlr.parser.antlr4.ANTLRv4Parser;
import org.antlr.parser.antlr4.ANTLRv4Parser.GrammarSpecContext;
import org.antlr.v4.Tool;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.tool.ErrorType;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * The core of the template transformation tool.
 */
public class GrammarExtenderCore {

    public static Path extendGrammarAndGenerateParser(String objectGrammarPath, String destinationPath,
        Tactics extensionTactic, String metaGrammarPath, String newGrammarName, String metaLangPrefix,
        String placeHolderName, String targetPackage, String anyTokenName) throws IOException, TemplateException {
        return extendGrammarAndGenerateParser(objectGrammarPath, destinationPath, extensionTactic, metaGrammarPath,
            newGrammarName, metaLangPrefix, placeHolderName, targetPackage, anyTokenName, true);
    }

    public static Path extendGrammar(String objectGrammarPath, String destinationPath, Tactics extensionTactic,
        String metaGrammarPath, String newGrammarName, String metaLangPrefix, String placeHolderName,
        String anyTokenName) throws IOException, TemplateException {
        return extendGrammarAndGenerateParser(objectGrammarPath, destinationPath, extensionTactic, metaGrammarPath,
            newGrammarName, metaLangPrefix, placeHolderName, null, anyTokenName, false);
    }

    public static Path extendGrammarAndGenerateParser(String objectGrammarPath, String destinationPath,
        Tactics extensionTactic, String metaGrammarPath, String newGrammarName, String metaLangPrefix,
        String placeHolderName, String targetPackage, String anyTokenName, boolean generateParser)
        throws IOException, TemplateException {

        // parse metalanguage
        File metaGrammar = new File(metaGrammarPath);
        Reader metaReader = new FileReader(metaGrammar);
        ANTLRv4Lexer metaLexer = new ANTLRv4Lexer(new ANTLRInputStream(metaReader));
        CommonTokenStream metaTokens = new CommonTokenStream(metaLexer);
        ANTLRv4Parser metaParser = new ANTLRv4Parser(metaTokens);
        GrammarSpecContext metaTree = metaParser.grammarSpec();

        // create a standard ANTLR parse tree walker
        ParseTreeWalker metaWalker = new ParseTreeWalker();

        // collect information about meta grammar
        MetaLanguageListener metaCollector = new MetaLanguageListener(metaTokens, metaLangPrefix, anyTokenName);
        metaWalker.walk(metaCollector, metaTree); // walk parse tree

        // create grammarspec using metagrammar infos
        GrammarSpec grammarSpec = new GrammarSpec(newGrammarName, metaLangPrefix, placeHolderName,
            metaCollector.getParserRules(), metaCollector.getLexerRules(), anyTokenName);

        // parse object Language
        File objectGrammar = new File(objectGrammarPath);
        Reader objectReader = new FileReader(objectGrammar);
        ANTLRv4Lexer objectLexer = new ANTLRv4Lexer(new ANTLRInputStream(objectReader));
        CommonTokenStream objectTokens = new CommonTokenStream(objectLexer);
        ANTLRv4Parser objectParser = new ANTLRv4Parser(objectTokens);
        GrammarSpecContext objectTree = objectParser.grammarSpec();

        ParseTreeWalker objectWalker = new ParseTreeWalker();

        // collect information about object grammar
        ObjectLanguageListener objectCollector = new ObjectLanguageListener(extensionTactic);
        objectWalker.walk(objectCollector, objectTree); // walk parse tree
        List<String> multiLexerRules = objectCollector.getMultiLexerRules();
        Map<String, String> tokenNames = objectCollector.getTokenNames();
        HashSet<String> selectedRules = objectCollector.getSelectedRules();

        // extend rules
        RulePlaceholderRewriter ruleRewriter =
            new RulePlaceholderRewriter(objectTokens, tokenNames, selectedRules, multiLexerRules, grammarSpec);
        objectWalker.walk(ruleRewriter, objectTree); // walk parse tree
        String step1Grammar = ruleRewriter.getRewriter().getText();

        // write down to detect left recursions and unfold them if they are starting with an alt-block
        String destinationFilePath2 = destinationPath + grammarSpec.getNewGrammarName() + ".g4";
        printToFile(destinationFilePath2, step1Grammar);

        objectLexer = new ANTLRv4Lexer(new ANTLRInputStream(new StringReader(step1Grammar)));
        CommonTokenStream tokenStream = new CommonTokenStream(objectLexer);
        objectParser = new ANTLRv4Parser(tokenStream);
        objectTree = objectParser.grammarSpec();
        LeftRecursiveRuleRewriter recRuleRewriter =
            new LeftRecursiveRuleRewriter(tokenStream, ruleRewriter.getUsedPlaceholderRules(), grammarSpec);
        objectWalker.walk(recRuleRewriter, objectTree); // walk parse tree

        PlaceholderRulesCreator rulesCreator = new PlaceholderRulesCreator(recRuleRewriter.getRewriter(), selectedRules,
            grammarSpec, ruleRewriter.getCreatedLexerRuleList(), ruleRewriter.getUsedPlaceholderRules());
        objectWalker.walk(rulesCreator, objectTree); // walk parse tree

        // print manipulated grammar to file
        String destinationFilePath = destinationPath + grammarSpec.getNewGrammarName() + ".g4";
        printToFile(destinationFilePath, rulesCreator.getRewriter().getText());

        if (generateParser) {
            generateParser(destinationPath, metaLangPrefix, placeHolderName, targetPackage, grammarSpec,
                destinationFilePath);
        }
        return new File(destinationFilePath).getAbsoluteFile().toPath();
    }

    /**
     * @param destinationPath
     * @param metaLangPrefix
     * @param placeHolderName
     * @param targetPackage
     * @param grammarSpec
     * @param destinationFilePath
     * @throws IOException
     */
    private static void generateParser(String destinationPath, String metaLangPrefix, String placeHolderName,
        String targetPackage, GrammarSpec grammarSpec, String destinationFilePath) throws IOException {
        // generate parser based on new grammar
        File newGrammarFile = new File(destinationFilePath);
        generateParserWithANTLR(newGrammarFile, targetPackage, metaLangPrefix.toUpperCase() + placeHolderName);

        // generate PlaceholderDetectorListener using Freemarker
        try {
            generatePlaceholderDetectorListenerWithFreemarker(destinationPath, grammarSpec, targetPackage);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    private static void generatePlaceholderDetectorListenerWithFreemarker(String destinationPath,
        GrammarSpec grammarSpec, String targetPackage) throws IOException, TemplateException {

        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File("src/main/resources"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setSharedVariable("package", targetPackage);

        /* Create a data-model */
        // just reuse grammarSpec

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate("PlaceholderDetectorListenerTemplate.ftl");

        /* Merge data-model with template */
        Writer out = new FileWriter(
            new File(destinationPath + grammarSpec.getNewGrammarName() + "PlaceholderDetectorListener.java"));
        temp.process(grammarSpec, out);
        out.close();

    }

    private static void generateParserWithANTLR(File grammarFile, String targetPackage, String placeholderName)
        throws IOException {
        String[] args =
            { grammarFile.getCanonicalPath(), "-listener", "-o", grammarFile.getParentFile().getCanonicalPath(),
                "-package", targetPackage, "-long-messages", "-metalang-placeholder", placeholderName };
        Tool antlr = new Tool(args);
        if (args.length == 0) {
            antlr.help();
        }

        try {
            antlr.processGrammarsOnCommandLine();
        } finally {
            if (antlr.log) {
                try {
                    String logname = antlr.logMgr.save();
                    System.out.println("wrote " + logname);
                } catch (IOException ioe) {
                    antlr.errMgr.toolError(ErrorType.INTERNAL_ERROR, ioe);
                }
            }
        }

        if (antlr.errMgr.getNumErrors() > 0) {
            antlr.exit(1);
        }
    }

    private static void printToFile(String filePath, String data) throws IOException {
        Writer fw = null;
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs();
            fw = new FileWriter(file);
            fw.write(data);
        } catch (IOException e) {
            throw new IOException("Unable to create new grammar in specified path", e);
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
