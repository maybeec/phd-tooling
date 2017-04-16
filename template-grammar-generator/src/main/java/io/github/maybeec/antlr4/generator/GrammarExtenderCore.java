package io.github.maybeec.antlr4.generator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
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

    public static void extendGrammar(String objectGrammarPath, String destinationPath, Tactics extensionTactic,
        String metaGrammarPath, String newGrammarName, String metaLangPrefix, String placeHolderName,
        String targetPackage) throws IOException, TemplateException {

        // parse metalanguage
        File metaGrammar = new File(metaGrammarPath);
        Reader metaReader = new FileReader(metaGrammar);
        ANTLRv4Lexer metaLexer = new ANTLRv4Lexer(new ANTLRInputStream(metaReader));
        CommonTokenStream metaTokens = new CommonTokenStream(metaLexer);
        ANTLRv4Parser metaParser = new ANTLRv4Parser(metaTokens);
        GrammarSpecContext metaTree = metaParser.grammarSpec();

        // create a standard ANTLR parse tree walker
        ParseTreeWalker metaWalker = new ParseTreeWalker();

        // collect information about metagrammar
        MetaLanguageListener metaCollector = new MetaLanguageListener(metaTokens, metaLangPrefix);
        metaWalker.walk(metaCollector, metaTree); // walk parse tree

        // create grammarspec using metagrammar infos
        GrammarSpec grammarSpec = new GrammarSpec(newGrammarName, metaLangPrefix, placeHolderName,
            metaCollector.getParserRules(), metaCollector.getLexerRules());

        // parse object Language
        File objectGrammar = new File(objectGrammarPath);
        Reader objectReader = new FileReader(objectGrammar);
        ANTLRv4Lexer objectLexer = new ANTLRv4Lexer(new ANTLRInputStream(objectReader));
        CommonTokenStream objectTokens = new CommonTokenStream(objectLexer);
        ANTLRv4Parser objectParser = new ANTLRv4Parser(objectTokens);
        GrammarSpecContext objectTree = objectParser.grammarSpec();

        // create a standard ANTLR parse tree walker
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

        PlaceholderRulesCreator rulesCreator = new PlaceholderRulesCreator(ruleRewriter.getRewriter(),
            selectedRules, grammarSpec, ruleRewriter.getCreatedLexerRuleList(), ruleRewriter.getUsedPlaceholderRules());
        objectWalker.walk(rulesCreator, objectTree); // walk parse tree

        // print manipulated grammar to file
        String destinationFilePath = destinationPath + grammarSpec.getNewGrammarName() + ".g4";
        printToFile(destinationFilePath, rulesCreator.getRewriter().getText());

        // parse grammar with Placeholder
        // File grammarWithPlaceholder = new File(destinationFilePath);
        // objectReader = new FileReader(grammarWithPlaceholder);
        // objectLexer = new ANTLRv4Lexer(new ANTLRInputStream(objectReader));
        // objectTokens = new CommonTokenStream(objectLexer);
        // objectParser = new ANTLRv4Parser(objectTokens);
        // objectTree = objectParser.grammarSpec();
        //
        // // extend with Conditions and Loops
        // ConditionAndLoopIncluderListener conditionLoopListener =
        // new ConditionAndLoopIncluderListener(objectTokens, grammarSpec);
        // objectWalker.walk(conditionLoopListener, objectTree); // walk parse tree
        //
        // // print manipulated grammar to file
        // printToFile(destinationFilePath, conditionLoopListener.getRewriter().getText());
        //
        // generate parser based on new grammar
        File newGrammarFile = new File(destinationFilePath);
        generateParserWithANTLR(newGrammarFile, targetPackage);

        // generate PlaceholderDetectorListener using Freemarker
        try {
            generatePlaceholderDetectorListenerWithFreemarker(destinationPath, grammarSpec, targetPackage);
        } catch (TemplateException e) {
            // TODO Auto-generated catch block
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

    private static void generateParserWithANTLR(File grammarFile, String targetPackage) throws IOException {
        String[] args = { grammarFile.getCanonicalPath(), "-listener", "-o",
            grammarFile.getParentFile().getCanonicalPath(), "-package", targetPackage, "-long-messages" };
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
