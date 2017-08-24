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
import org.antlr.v4.runtime.atn.PredictionMode;

import io.github.maybeec.antlr4.parser.TemplateParser;
import io.github.maybeec.parsers.javatemplate.JavaTemplateLexer;
import io.github.maybeec.parsers.javatemplate.JavaTemplateParser;
import io.github.maybeec.patterndetection.matcher.ParseTreeMatcher;

/** Application interface of the pattern detection implementation. */
public class Detector {

    /**
     * Detects a pattern given by a set of templates in a given application given by a set of application
     * source code files.
     * @param pattern
     *            set of templates
     * @param applicationFiles
     *            set of application source files
     * @param templateFileEnding
     *            file ending of the templates for optimization purposes.
     * @return the variable substitutions for each occurrence of the found pattern in the application
     * @throws Exception
     *             if anything fails.
     */
    public List<Map<String, String>> detect(Iterable<Path> pattern, Iterable<Path> applicationFiles,
        String templateFileEnding) throws Exception {

        long start = System.currentTimeMillis();
        Map<Path, List<ParserRuleContext>> templateParseTrees = new HashMap<>();

        // all iterations will yield the same list patterns as we are parsing the same language
        Map<String, String> listPatterns = new HashMap<>(0);
        for (Path template : pattern) {
            TemplateParser<JavaTemplateParser> parserWrapper = createParser(template);
            listPatterns = parserWrapper.getListPatterns();
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
                    variableSubstitutions.add(new ParseTreeMatcher(templateCST, applicationParseTrees.get(file),
                        new JavaTemplateParser(null).getVocabulary(), listPatterns).detect());
                }
            }
        }

        return variableSubstitutions;
    }

    /**
     * Creates a new parser and parses the given file.
     * @param file
     *            to be parsed
     * @return the template parser wrapper of the original {@link JavaTemplateParser}
     * @throws Exception
     *             if the file could not be read or parsing fails
     */
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

}
