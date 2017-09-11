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
        Set<AstPathList<AstElem>> unorderedTempPaths = templatePaths.stream()
            .filter(elem -> elem instanceof AstPathList).filter(elem -> ((AstPathList) elem).isOrdered())
            .map(elem -> (AstPathList<AstElem>) elem).collect(Collectors.toSet());
        Set<AstPathList<AstElem>> unorderedAppPaths = appPaths.stream().filter(elem -> elem instanceof AstPathList)
            .filter(elem -> ((AstPathList) elem).isOrdered()).map(elem -> (AstPathList<AstElem>) elem)
            .collect(Collectors.toSet());

        List<AstElem> orderedTemplatePaths = templatePaths.stream()
            .filter(elem -> (elem instanceof AstPath)
                || (elem instanceof AstPathCollection<?>) && ((AstPathCollection<?>) elem).isOrdered())
            .collect(Collectors.toList());
        List<AstElem> orderedAppPaths = appPaths.stream()
            .filter(elem -> (elem instanceof AstPath)
                || (elem instanceof AstPathCollection<?>) && ((AstPathCollection<?>) elem).isOrdered())
            .collect(Collectors.toList());

        Map<String, String> variableSubstitutions = matchOrderedPaths(orderedTemplatePaths, orderedAppPaths, false);

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
    private Map<String, String> matchOrderedPaths(List<AstElem> orderedTemplatePaths, List<AstElem> orderedAppPaths,
        boolean exactly) {
        Map<String, String> variableSubstitutions = new HashMap<>();
        int j = 0;
        for (int i = 0; i < orderedTemplatePaths.size(); i++) {
            AstElem tempElem = orderedTemplatePaths.get(i);

            AstElem appElem;
            boolean matches;
            do {
                if (j >= orderedAppPaths.size()) {
                    // template could not be found entirely in app!
                    String debugVal = tempElem instanceof AstPath ? ((AstPath) tempElem).getPath()
                        : ((AstPathCollection<?>) tempElem).getType();
                    throw new NoMatchException("Could not find path " + debugVal);
                }
                appElem = orderedAppPaths.get(j);

                matches = true;
                try {
                    variableSubstitutions.putAll(matchPath(tempElem, appElem));
                } catch (NoMatchException e) {
                    matches = false;
                }
                if (!matches) {
                    if (exactly) {
                        j = orderedAppPaths.size(); // trigger error handling at loop start
                    } else {
                        j++;
                    }
                }
            } while (!matches);
        }
        return variableSubstitutions;
    }

    /**
     * @param appElem
     * @return
     */
    public Map<String, String> matchPath(AstElem tempElem, AstElem appElem) {
        if (tempElem instanceof AstPathList<?> && ((AstPathList<?>) tempElem).isAtomic()
            && appElem instanceof AstPathList<?> && ((AstPathList<?>) appElem).isAtomic()) {
            return matchOrderedPaths((AstPathList<AstElem>) tempElem, (AstPathList<AstElem>) appElem, true);
        } else if (tempElem instanceof AstPath && appElem instanceof AstPath) {
            AstPath startingTemp = (AstPath) tempElem;
            AstPath startingApp = (AstPath) appElem;
            AstPath currentTemp = startingTemp;
            AstPath currentApp = startingApp;

            Map<String, String> variableSubstitutions = new HashMap<>();

            // trivial case
            if (currentApp.getPath().equals(currentTemp.getPath())) {
                System.out.println("Consume (t->a): " + startingTemp + " --> " + startingApp);
                return variableSubstitutions;
            } else if (!currentTemp.containsMetaLang()) {
                throw new NoMatchException("Could not find " + startingTemp.getPath() + " in " + startingApp.getPath());
            }

            // meta code in path
            do {
                if (currentApp == null) {
                    throw new NoMatchException(
                        "Could not find " + startingTemp.getPath() + " in " + startingApp.getPath());
                }
                if (currentTemp.getName().equals(currentApp.getName())) {
                    currentApp = currentApp.getParent();
                } else if (currentTemp.isMetaLang()) {
                    if (currentTemp.getParent().getName().matches("Fm_" + currentApp.getName() + "Context")) {
                        variableSubstitutions.put(currentTemp.getText(), currentApp.getText());
                        break;
                    }
                } else {
                    currentApp = currentApp.getParent();
                }
                currentTemp = currentTemp.getParent();
            } while (currentTemp != null);

            System.out.println("Consume (t->a): " + startingTemp + " --> " + startingApp);
            return variableSubstitutions;
        } else {
            throw new NoMatchException("Cannot match AstPath " + tempElem + " against AstPathCollection " + appElem);
        }
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
