package io.github.maybeec.patterndetection.deprecated;

import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.atn.PredictionMode;

import io.github.maybeec.antlr4.parser.TemplateParser;
import io.github.maybeec.parsers.javatemplate.JavaTemplateLexer;
import io.github.maybeec.parsers.javatemplate.JavaTemplateParser;
import io.github.maybeec.patterndetection.exception.NoMatchException;

public class FlattenedTreeMatcher {

    private Map<String, String> listPatterns;

    public Map<String, Set<TreePath>> matches(Iterable<Path> pattern, Iterable<Path> applicationFiles)
        throws Exception {
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

        Map<String, Set<TreePath>> variableSubstitutions = new HashMap<>();
        for (Path template : pattern) {
            for (Path file : applicationFiles) {
                for (ParserRuleContext templateCST : templateParseTrees.get(template)) {
                    System.out.println("");
                    System.out.println(">>> Matching " + template.toFile().getAbsolutePath());
                    System.out.println(">>> AT " + file.toFile().getAbsolutePath());
                    System.out.println("");
                    variableSubstitutions.putAll(matches(applicationParseTrees.get(file), templateCST,
                        new JavaTemplateParser(null).getVocabulary()));
                }
            }
        }
        return variableSubstitutions;
    }

    private TemplateParser<JavaTemplateParser> createParser(Path file) throws Exception {
        try (Reader reader = new FileReader(file.toFile())) {
            Lexer lexer = new JavaTemplateLexer(new ANTLRInputStream(reader));
            JavaTemplateParser parser = new JavaTemplateParser(new CommonTokenStream(lexer));

            try (InputStream grammar = FlattenedTreeMatcher.class.getResourceAsStream("/antlr/JavaTemplate.g4")) {
                TemplateParser<JavaTemplateParser> parserWrapper =
                    new TemplateParser<>(parser, JavaTemplateParser.class.getMethod("compilationUnit"), grammar);
                listPatterns = parserWrapper.getListPatterns();
                return parserWrapper;
            }
        }
    }

    public Map<String, Set<TreePath>> matches(ParserRuleContext app, ParserRuleContext template,
        Vocabulary parserVocabulary) {
        LinkedHashSet<TreePath> flattenedApp = TreeUtils.flatten(app, parserVocabulary);
        LinkedHashSet<TreePath> flattenedTemplate = TreeUtils.flatten(template, parserVocabulary);

        LinkedHashSet<TreePath> templateMatches = new LinkedHashSet<>();
        for (TreePath templatePath : flattenedTemplate) {
            for (TreePath appPath : flattenedApp) {
                if (templatePath.matches(appPath, listPatterns)) {
                    templateMatches.add(templatePath);
                }
            }
        }

        Map<String, Set<TreePath>> substitutions = new HashMap<>();
        for (TreePath match : templateMatches) {
            if (match.getPlaceholder() != null) {
                if (substitutions.containsKey(match.getPlaceholder())) {
                    Set<TreePath> alreadyKnownSubstitutions = substitutions.get(match.getPlaceholder());
                    Set<TreePath> values = new HashSet<>(alreadyKnownSubstitutions);
                    values.retainAll(match.getSubstitutions());
                    if (values.isEmpty()) {
                        throw new NoMatchException(
                            "No match for placehoder " + match.getPlaceholder() + ": Conflicting substitutions:\n"
                                + alreadyKnownSubstitutions + "\n" + match.getSubstitutions());
                    } else {
                        substitutions.put(match.getPlaceholder(), values);
                    }
                } else {
                    substitutions.put(match.getPlaceholder(), new HashSet<>());
                    substitutions.get(match.getPlaceholder()).addAll(match.getSubstitutions());
                }
            }
        }

        System.out.println("Matched template with " + templateMatches.size() + " paths out of "
            + flattenedTemplate.size() + " paths.");

        System.out.println("Substitutions: ");
        for (TreePath tm : templateMatches) {
            if (tm.getPlaceholder() != null) {
                System.out.println(tm.getPlaceholder() + " -> "
                    + tm.getSubstitutions().stream().map(x -> x.getText()).collect(Collectors.toSet()));
            } else {
                System.out.println("Match: " + tm.getRoot().toString());
            }
        }

        return substitutions;
    }
}
