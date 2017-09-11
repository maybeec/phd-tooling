package io.github.maybeec.patterndetection.matcher;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.misc.MultiMap;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import io.github.maybeec.antlr4.parser.ListPatternCollector;
import io.github.maybeec.parsers.javatemplate.JavaTemplateParser;
import io.github.maybeec.patterndetection.entity.AstElem;
import io.github.maybeec.patterndetection.entity.AstPath;
import io.github.maybeec.patterndetection.entity.AstPathCollection;
import io.github.maybeec.patterndetection.entity.AstPathList;
import io.github.maybeec.patterndetection.entity.AstPathSet;
import io.github.maybeec.patterndetection.exception.NoMatchException;

/**
 *
 */
public class PathBasedMatcher {

    /** Non ordered productions. Might be served as input later on */
    private static final Set<String> _nonOrderedNodes = new HashSet<>(Arrays.asList(new String[] { "ImportDeclaration",
        "InterfaceMemberDeclaration", "ClassMemberDeclaration", "TypeDeclaration" }));

    /** Non ordered node class names, prepared on the basis of {@value #_nonOrderedNodes} */
    private static Set<String> nonOrderedNodes;

    static {
        nonOrderedNodes = new HashSet<>();
        for (String production : _nonOrderedNodes) {
            nonOrderedNodes.add(production + "Context");
            nonOrderedNodes.add("Fm_" + production + "Context");
            nonOrderedNodes.add("Fm_" + production + "OptContext");
            nonOrderedNodes.add("Fm_" + production + "StarContext");
            nonOrderedNodes.add("Fm_" + production + "PlusContext");
        }
    }

    private static final Set<String> statementTerminals;

    static {
        statementTerminals = new HashSet<>();
        statementTerminals.add(";");
        statementTerminals.add("}");
    }

    /** Unordered nodes, which have been matched already */
    private Set<ParseTree> coveredUnorderedNodes = new HashSet<>();

    /** Current pointer of the template CST */
    private ParseTree templatePointer;

    /** Current pointer of the application CST */
    private ParseTree appPointer;

    /** Root of the template CST */
    private ParseTree templatePointerInit;

    /** Root of the application CST */
    private ParseTree appPointerInit;

    /** Visited nodes */
    private Set<ParseTree> visited = new HashSet<>();

    /** All token substitution covered so far */
    private Map<String, Set<String>> tokenSubstituitions = new HashMap<>();

    /** Currently selected token substitutions (matching token text to substitution string) */
    private Map<String, String> selectedSubstitutions = new HashMap<>();

    /** Number of tokens of the selected substitution for each token (key = token text) */
    private Map<String, Integer> selectedSubstitutionTokenCount = new HashMap<>();

    /** Vocabulary of the parser to get the token names from */
    private Vocabulary parserVocabulary;

    /** Decision points to may get back to during backtracking. */
    private Stack<MatcherState> decisionPoints = new Stack<>();

    /** List patterns in the underlying grammar. See {@link ListPatternCollector} for more details */
    private MultiMap<String, String> listPatterns;

    /**
     * Creates a new instance of the matcher.
     * @param templateCST
     *            template CST root
     * @param applicationFileCST
     *            application CST root
     * @param parserVocabulary
     *            vocabulary of the parser to resolve token names from.
     * @param listPatterns
     *            list patterns
     */
    public PathBasedMatcher(ParseTree templateCST, ParseTree applicationFileCST, Vocabulary parserVocabulary,
        MultiMap<String, String> listPatterns) {
        templatePointer = templateCST;
        appPointer = applicationFileCST;
        templatePointerInit = templateCST;
        appPointerInit = applicationFileCST;
        this.parserVocabulary = parserVocabulary;
        this.listPatterns = listPatterns;
    }

    public Map<String, String> detect() {

        System.out.println("");
        System.out.println(">> Template: ");
        System.out.println("");

        ParseTreeWalker walker = new ParseTreeWalker();
        AstToPathTransformer listener =
            new AstToPathTransformer(new JavaTemplateParser(null).getVocabulary(), statementTerminals, listPatterns);
        walker.walk(listener, templatePointer);
        AstPathSet<AstElem> rootSet = new AstPathSet<>("ROOT");
        AstPathList<AstElem> templatePaths = listener.getPaths();
        rootSet.add(templatePaths);
        printPaths(rootSet);

        System.out.println("");
        System.out.println(">> APP: ");
        System.out.println("");

        listener =
            new AstToPathTransformer(new JavaTemplateParser(null).getVocabulary(), statementTerminals, listPatterns);
        walker.walk(listener, appPointer);
        rootSet = new AstPathSet<>("ROOT");
        AstPathList<AstElem> appPaths = listener.getPaths();
        rootSet.add(appPaths);
        printPaths(rootSet);

        return match(templatePaths, appPaths);

    }

    /**
     * @param templatePaths
     * @param appPaths
     */
    private Map<String, String> match(AstPathList<AstElem> templatePaths, AstPathList<AstElem> appPaths) {
        // separate unordered nodes from ordered ones
        Set<AstPathList<AstElem>> unorderedTempPaths =
            templatePaths.stream().filter(elem -> elem instanceof AstPathList).map(elem -> (AstPathList<AstElem>) elem)
                .collect(Collectors.toSet());
        Set<AstPathList<AstElem>> unorderedAppPaths = appPaths.stream().filter(elem -> elem instanceof AstPathList)
            .map(elem -> (AstPathList<AstElem>) elem).collect(Collectors.toSet());
        List<AstPath> orderedTemplatePaths = templatePaths.stream().filter(elem -> elem instanceof AstPath)
            .map(elem -> (AstPath) elem).collect(Collectors.toList());
        List<AstPath> orderedAppPaths = appPaths.stream().filter(elem -> elem instanceof AstPath)
            .map(elem -> (AstPath) elem).collect(Collectors.toList());

        Map<String, String> variableSubstitutions = matchOrderedPaths(orderedTemplatePaths, orderedAppPaths);

        Map<AstPathList<AstElem>, AstPathList<AstElem>> matches = new HashMap<>();
        for (AstPathList<AstElem> tempElem : unorderedTempPaths) {
            for (AstPathList<AstElem> appElem : unorderedAppPaths) {
                try {
                    variableSubstitutions.putAll(match(tempElem, appElem));
                    matches.put(tempElem, appElem);
                } catch (NoMatchException e) {
                    // ignore as there might be another match
                }
            }
        }
        unorderedTempPaths.removeAll(matches.keySet());
        if (!unorderedTempPaths.isEmpty()) {
            throw new NoMatchException("The following template paths could not be found: \n"
                + unorderedTempPaths.stream().map(e -> e.toString()).collect(Collectors.joining("\n")));
        }

        return variableSubstitutions;
    }

    /**
     * @param orderedTemplatePaths
     * @param orderedAppPaths
     * @return
     */
    private Map<String, String> matchOrderedPaths(List<AstPath> orderedTemplatePaths, List<AstPath> orderedAppPaths) {
        Map<String, String> variableSubstitutions = new HashMap<>();
        int j = 0, initialJ;
        for (int i = 0; i < orderedTemplatePaths.size(); i++) {
            initialJ = j;
            AstPath tempElem = orderedTemplatePaths.get(i);

            AstPath appElem;
            boolean matches;
            do {
                if (j >= orderedAppPaths.size()) {
                    // template could not be found entirely in app!
                    throw new NoMatchException("Could not find path " + tempElem.getPath());
                }
                appElem = orderedAppPaths.get(j);

                matches = true;
                try {
                    variableSubstitutions.putAll(matchPath(tempElem, appElem));
                } catch (NoMatchException e) {
                    matches = false;
                }
                if (!matches) {
                    j++;
                }
            } while (!matches);
        }
        return variableSubstitutions;
    }

    /**
     * @param appElem
     * @return
     */
    public Map<String, String> matchPath(AstPath tempElem, AstPath appElem) {
        AstPath startingTemp = tempElem;
        AstPath startingApp = appElem;

        Map<String, String> variableSubstitutions = new HashMap<>();

        // trivial case
        if (appElem.getPath().equals(tempElem.getPath())) {
            System.out.println("Consume (t->a): " + startingTemp + " --> " + startingApp);
            return variableSubstitutions;
        } else if (!tempElem.containsMetaLang()) {
            throw new NoMatchException("Could not find " + startingTemp.getPath() + " in " + startingApp.getPath());
        }

        // meta code in path
        do {
            if (appElem == null) {
                throw new NoMatchException("Could not find " + startingTemp.getPath() + " in " + startingApp.getPath());
            }
            if (tempElem.getName().equals(appElem.getName())) {
                appElem = appElem.getParent();
            } else if (tempElem.isMetaLang()) {
                if (tempElem.getParent().getName().matches("Fm_" + appElem.getName() + "Context")) {
                    variableSubstitutions.put(tempElem.getText(), appElem.getText());
                    break;
                }
            } else {
                appElem = appElem.getParent();
            }
            tempElem = tempElem.getParent();
        } while (tempElem != null);

        System.out.println("Consume (t->a): " + startingTemp + " --> " + startingApp);
        return variableSubstitutions;
    }

    /**
     * @param listener
     */
    private void printPaths(AstPathCollection<AstElem> paths) {
        for (AstElem elem : paths) {
            if (elem instanceof AstPath) {
                System.out.println(((AstPath) elem).getPath());
            } else if (elem instanceof AstPathCollection) {
                if (((AstPathCollection) elem).isOrdered()) {
                    System.out.println("Ordered Path (" + ((AstPathCollection) elem).getType() + ") [");
                } else {
                    System.out.println("UN-Ordered Path (" + ((AstPathCollection) elem).getType() + ") [");
                }
                printPaths((AstPathList) elem);
                System.out.println("]");
            } else {
                throw new IllegalStateException("Unknown AstElem type " + elem.getClass());
            }
        }
    }

}
