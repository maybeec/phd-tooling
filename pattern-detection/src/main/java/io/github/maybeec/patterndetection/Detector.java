package io.github.maybeec.patterndetection;

import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import io.github.maybeec.antlr4.parser.TemplateParser;
import io.github.maybeec.parsers.javatemplate.JavaTemplateLexer;
import io.github.maybeec.parsers.javatemplate.JavaTemplateParser;

public class Detector {

    public List<Map<String, String>> detect(Iterable<Path> pattern, Iterable<Path> applicationFiles,
        String templateFileEnding) throws Exception {

        long start = System.currentTimeMillis();
        Map<Path, List<ParserRuleContext>> templateParseTrees = new HashMap<>();

        for (Path template : pattern) {
            TemplateParser<JavaTemplateParser> parserWrapper = createParser(template);
            List<ParserRuleContext> templateCSTs =
                parserWrapper.parseAmbiguities(PredictionMode.LL_EXACT_AMBIG_DETECTION);
            templateParseTrees.put(template, templateCSTs);
        }
        long end = System.currentTimeMillis();
        System.out.println(">>> Parsing pattern took " + ((end - start) / 1000) + "s");

        Map<Path, ParserRuleContext> applicationParseTrees = new HashMap<>();
        start = System.currentTimeMillis();
        for (Path appFile : applicationFiles) {
            TemplateParser<JavaTemplateParser> parserWrapper = createParser(appFile);
            ParserRuleContext appFileCST = parserWrapper.parse(PredictionMode.LL);
            applicationParseTrees.put(appFile, appFileCST);
        }
        end = System.currentTimeMillis();
        System.out.println(">>> Parsing the application code took " + ((end - start) / 1000.0) + "s");

        System.out.println();
        System.out.println(" ===================================================================================== ");
        System.out.println();

        List<Map<String, String>> variableSubstitutions = new ArrayList<>();
        for (Path template : pattern) {
            for (Path file : applicationFiles) {
                for (ParserRuleContext templateCST : templateParseTrees.get(template)) {
                    System.out.println("");
                    System.out.println(">>> Matching " + template.toFile().getAbsolutePath());
                    System.out.println(">>> AT " + file.toFile().getAbsolutePath());
                    System.out.println("");
                    variableSubstitutions.add(new TreeMatcher(templateCST, applicationParseTrees.get(file),
                        new JavaTemplateParser(null).getVocabulary()).detect());
                }
            }
        }

        return variableSubstitutions;
    }

    private TemplateParser<JavaTemplateParser> createParser(Path file) throws Exception {
        try (Reader reader = new FileReader(file.toFile())) {
            Lexer lexer = new JavaTemplateLexer(new ANTLRInputStream(reader));
            JavaTemplateParser parser = new JavaTemplateParser(new CommonTokenStream(lexer));

            try (InputStream grammar = getClass().getResourceAsStream("/antlr/JavaTemplate.g4")) {
                TemplateParser<JavaTemplateParser> parserWrapper =
                    new TemplateParser<>(parser, JavaTemplateParser.class.getMethod("compilationUnit"), grammar);
                return parserWrapper;
            }
        }
    }

    /**
     * @param list
     * @param list2
     */
    private void detect(ParseTree templateCST, ParseTree applicationFileCST, Vocabulary lexerVocabulary) {
        if (templateCST.getClass().equals(applicationFileCST.getClass())) {
            if (templateCST.getChildCount() > 0) {
                if (applicationFileCST.getChildCount() > 0) {
                    for (int i = 0; i < ((ParserRuleContext) templateCST).children.size(); i++) {
                        if (i < ((ParserRuleContext) applicationFileCST).children.size()) {
                            detect(templateCST.getChild(i), applicationFileCST.getChild(i), lexerVocabulary);
                        } else {
                            System.err.println(
                                "NO MATCH, application file does not contain child " + templateCST.getChild(i));
                        }
                    }
                } else {
                    System.err.println("Template contains even more children, but application file does not!");
                }
            } else if (templateCST.getText().equals(applicationFileCST.getText())) {
                // everything fine...
                System.out.println("Successfully matching terminal '" + templateCST.getText() + "' against '"
                    + applicationFileCST.getText() + "'");
            } else {
                System.err.println("Not yet analyzed! " + templateCST.getClass().getSimpleName() + "['"
                    + templateCST.getText() + "'] --- " + applicationFileCST.getClass().getSimpleName() + "['"
                    + applicationFileCST.getText() + "']");
            }
        } else if (templateCST.getClass().getName().matches(".*Parser\\$Fm_.*")) {
            if (applicationFileCST instanceof TerminalNodeImpl && templateCST.getChildCount() == 1
                && templateCST.getChild(0) instanceof TerminalNodeImpl && "FM_PLACEHOLDER".equals(lexerVocabulary
                    .getSymbolicName(((TerminalNodeImpl) templateCST.getChild(0)).getSymbol().getType()))) {
                System.out.println("Successfully matching terminal " + templateCST.getClass().getSimpleName() + "['"
                    + templateCST.getText() + "'] with child PH_PLACEHOLDER against '" + applicationFileCST.getText()
                    + "'");
            }
        } else {
            System.out
                .println("ANY OTHER CLASSES: " + templateCST.getClass() + " --- " + applicationFileCST.getClass());
        }
    }

}
