package io.github.maybeec.patterndetection.matcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
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
import io.github.maybeec.patterndetection.entity.AtomarMatch;
import io.github.maybeec.patterndetection.entity.Match;
import io.github.maybeec.patterndetection.entity.NonOrderedContainerMatch;
import io.github.maybeec.patterndetection.entity.OrderedContainerMatch;
import io.github.maybeec.patterndetection.exception.NoMatchException;
import io.github.maybeec.patterndetection.utils.MathUtil;

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

    /** Vocabulary of the parser to get the token names from */
    private Vocabulary parserVocabulary;

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

    public List<Match<AstElem>> match() {

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
        System.out.println(printPaths(rootSet, e -> e.getPath(), true));

        System.out.println("");
        System.out.println(">> APP: ");
        System.out.println("");

        listener =
            new AstToPathTransformer(new JavaTemplateParser(null).getVocabulary(), statementTerminals, listPatterns);
        walker.walk(listener, appPointer);
        rootSet = new AstPathSet<>("ROOT");
        AstPathList<AstElem> appPaths = listener.getPaths();
        rootSet.add(appPaths);
        System.out.println(printPaths(rootSet, e -> e.getPath(), true));

        return match(templatePaths, appPaths);

    }

    /**
     * @param templatePaths
     * @param appPaths
     */
    private List<Match<AstElem>> match(AstPathList<AstElem> templatePaths, AstPathList<AstElem> appPaths) {
        // separate unordered nodes from ordered ones
        Set<AstPathList<AstElem>> unorderedTempPaths = templatePaths.stream()
            .filter(elem -> elem instanceof AstPathList).filter(elem -> !((AstPathList) elem).isOrdered())
            .map(elem -> (AstPathList<AstElem>) elem).collect(Collectors.toSet());
        Set<AstPathList<AstElem>> unorderedAppPaths = appPaths.stream().filter(elem -> elem instanceof AstPathList)
            .filter(elem -> !((AstPathList) elem).isOrdered()).map(elem -> (AstPathList<AstElem>) elem)
            .collect(Collectors.toSet());

        List<AstElem> orderedTemplatePaths = templatePaths.stream()
            .filter(elem -> (elem instanceof AstPath)
                || (elem instanceof AstPathCollection<?>) && ((AstPathCollection<?>) elem).isOrdered())
            .collect(Collectors.toList());
        List<AstElem> orderedAppPaths = appPaths.stream()
            .filter(elem -> (elem instanceof AstPath)
                || (elem instanceof AstPathCollection<?>) && ((AstPathCollection<?>) elem).isOrdered())
            .collect(Collectors.toList());

        List<Match<AstElem>> listOfMatches = new ArrayList<>();
        List<Match<AstElem>> matchesOrderedPaths = matchOrderedPaths(orderedTemplatePaths, orderedAppPaths, false);
        listOfMatches.add(new OrderedContainerMatch<>(matchesOrderedPaths));

        // get all unordered matches, contains multiple matches per template node
        List<List<Match<AstElem>>> matches = getAllUnorderedMatches(unorderedTempPaths, unorderedAppPaths);
        listOfMatches.add(new NonOrderedContainerMatch<>(matches));

        return listOfMatches;
    }

    /**
     * @param unorderedTempPaths
     * @param unorderedAppPaths
     * @return
     */
    private List<List<Match<AstElem>>> getAllUnorderedMatches(Set<AstPathList<AstElem>> unorderedTempPaths,
        Set<AstPathList<AstElem>> unorderedAppPaths) {
        List<List<Match<AstElem>>> matches = new ArrayList<>();
        Iterator<AstPathList<AstElem>> it = unorderedTempPaths.iterator();
        while (it.hasNext()) {
            AstPathList<AstElem> tempElem = it.next();
            List<Match<AstElem>> matchesTemp = new ArrayList<>();
            for (AstPathList<AstElem> appElem : unorderedAppPaths) {
                try {
                    // List<Map<String, String>> variableAssignments = match(tempElem, appElem);
                    // for (Map<String, String> va : variableAssignments) {
                    matchesTemp.add(new OrderedContainerMatch<>(match(tempElem, appElem)));
                    // }
                } catch (NoMatchException e) {
                    // ignore as there might be another match
                }
            }
            if (!matchesTemp.isEmpty()) {
                matches.add(matchesTemp);
                it.remove();
            }
        }

        if (!unorderedTempPaths.isEmpty()) {
            throw new NoMatchException("The following template paths could not be found: \n" + unorderedTempPaths
                .stream().map(e -> printPaths(e, p -> p.getText(), false)).collect(Collectors.joining("\n")));
        }
        return matches;
    }

    /**
     * @param orderedTemplatePaths
     * @param orderedAppPaths
     * @return
     */
    private List<Match<AstElem>> matchOrderedPaths(List<AstElem> orderedTemplatePaths, List<AstElem> orderedAppPaths,
        boolean exactly) {

        List<Match<AstElem>> listOfMatches = new ArrayList<>();
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
                    listOfMatches.add(new OrderedContainerMatch<>(matchPath(tempElem, appElem)));
                } catch (NoMatchException e) {
                    matches = false;
                }
                if (!matches) {
                    if (exactly) {
                        j = orderedAppPaths.size() + 1; // trigger error handling at loop start
                    } else {
                        j++;
                    }
                } else {
                    j++;
                }
            } while (!matches);
        }
        return listOfMatches;
    }

    /**
     * @param appElem
     * @return
     */
    public List<Match<AstElem>> matchPath(AstElem tempElem, AstElem appElem) {
        if (tempElem instanceof AstPathList<?> && ((AstPathList<?>) tempElem).isAtomic()
            && appElem instanceof AstPathList<?> && ((AstPathList<?>) appElem).isAtomic()) {
            return matchOrderedPaths((AstPathList<AstElem>) tempElem, (AstPathList<AstElem>) appElem, true);
        } else if (tempElem instanceof AstPathList<?> && ((AstPathList<?>) tempElem).isListPattern()
            && appElem instanceof AstPathList<?> && ((AstPathList<?>) appElem).isListPattern()) {
            return matchListPattern((AstPathList<AstElem>) tempElem, (AstPathList<AstElem>) appElem);
        } else if (tempElem instanceof AstPath && appElem instanceof AstPath) {
            AstPath startingTemp = (AstPath) tempElem;
            AstPath startingApp = (AstPath) appElem;
            AstPath currentTemp = startingTemp;
            AstPath currentApp = startingApp;

            Map<String, String> variableSubstitutions = new HashMap<>();

            // trivial case
            if (currentApp.getPath().equals(currentTemp.getPath())) {
                System.out.println("Consume (t->a): " + startingTemp + " --> " + startingApp);
                List<Match<AstElem>> listOfMatches = new ArrayList<>();
                listOfMatches.add(new AtomarMatch<>(tempElem, appElem, variableSubstitutions));
                return listOfMatches;
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
            List<Match<AstElem>> listOfMatches = new ArrayList<>();
            listOfMatches.add(new AtomarMatch<>(tempElem, appElem, variableSubstitutions));
            return listOfMatches;
        } else {
            throw new NoMatchException("Cannot match AstPath " + tempElem + " against AstPathCollection " + appElem);
        }
    }

    /**
     * @param tempElem
     * @param appElem
     * @return
     */
    private List<Match<AstElem>> matchListPattern(AstPathList<AstElem> orderedTemplatePaths,
        AstPathList<AstElem> orderedAppPaths) {

        int numPh = (int) orderedTemplatePaths.stream().filter(e -> e instanceof AstPath).map(e -> (AstPath) e)
            .filter(e -> e.containsMetaLang()).count();
        int maxSubstitutions = orderedAppPaths.size() - orderedTemplatePaths.size() + numPh;

        // will be small enough to cast to int
        int[][] combinations;
        if (maxSubstitutions == 0) {
            // if there are PHs, than all of them will just replace one element
            combinations = new int[1][numPh];
            Arrays.fill(combinations, new int[] { 1 });
        } else if (maxSubstitutions < numPh) {
            throw new NoMatchException("App path list to short. Could not instantiate all placeholders.");
        } else {
            // n = maxSubstitutions, k = PHs; different buckets, same balls.
            combinations = MathUtil.multichooseMin1(maxSubstitutions, numPh);
        }

        List<Match<AstElem>> foundMatches = new ArrayList<>();
        for (int[] combination : combinations) {
            Map<String, String> variableSubstitutions = new HashMap<>();

            try {
                int observedPhIndex = 0;
                int j = 0;
                for (int i = 0; i < orderedTemplatePaths.size(); i++) {

                    boolean isPh = false;
                    AstElem tempElem = orderedTemplatePaths.get(i);
                    String tempName;
                    if (tempElem instanceof AstPath) {
                        isPh = ((AstPath) tempElem).isMetaLang();
                        tempName = ((AstPath) tempElem).getName();
                    } else {
                        // let's not support this for now
                        throw new IllegalStateException("AstPathCollection not supported here so far!");
                    }

                    AstElem appElem;
                    String appMatch = "";
                    boolean matches = false;
                    int consumedAppElems = 0;
                    do {
                        if (j >= orderedAppPaths.size()) {
                            // template could not be found entirely in app!
                            String debugVal = tempElem instanceof AstPath ? ((AstPath) tempElem).getPath()
                                : ((AstPathCollection<?>) tempElem).getType();
                            throw new NoMatchException("Could not find path " + debugVal);
                        }
                        appElem = orderedAppPaths.get(j);

                        if (appElem instanceof AstPath) {
                            appMatch += ((AstPath) appElem).getText();
                            consumedAppElems++;
                        } else {
                            // let's not support this for now
                            throw new IllegalStateException("AstPathCollection not supported here so far!");
                        }

                        if (isPh) {
                            if (combination[observedPhIndex] > consumedAppElems) {
                                j++;
                                continue;
                            } else {
                                System.out.println("Consume (t->a): " + tempElem + " --> " + appMatch);
                                variableSubstitutions.put(((AstPath) tempElem).getText(), appMatch);
                                j++;
                                observedPhIndex++;
                                break;
                            }
                        } else {
                            matches = tempName.equals(((AstPath) appElem).getName())
                                && ((AstPath) tempElem).getText().equals(((AstPath) appElem).getText());
                        }

                        if (!matches) {
                            if (isPh) {
                                j++;
                            } else {
                                throw new NoMatchException(
                                    "Could not match template path " + ((AstPath) tempElem).getPath());
                            }
                        } else {
                            System.out.println("Consume (t->a): " + tempElem + " --> " + appMatch);
                            j++;
                        }
                    } while (!matches);
                }

                foundMatches.add(new AtomarMatch<>(orderedTemplatePaths, orderedAppPaths, variableSubstitutions));
            } catch (NoMatchException e) {
                // ignore, try next
            }
        }

        if (foundMatches.isEmpty()) {
            throw new NoMatchException("Could not match template " + orderedTemplatePaths + " to " + orderedAppPaths);
        }

        return foundMatches;
    }

    /**
     * @param listener
     */
    private String printPaths(AstPathCollection<AstElem> paths, Function<AstPath, String> pathToString,
        boolean newLine) {
        StringBuilder strB = new StringBuilder();

        for (AstElem elem : paths) {
            if (elem instanceof AstPath) {
                strB.append(pathToString.apply(((AstPath) elem)));
                if (newLine) {
                    strB.append("\n");
                }
            } else if (elem instanceof AstPathCollection) {
                if (((AstPathCollection<?>) elem).isOrdered()) {
                    strB.append("Ordered Path (" + ((AstPathCollection<?>) elem).getType() + ") [");
                    strB.append("\n");
                } else {
                    if (!newLine) {
                        strB.append("\n");
                    }
                    strB.append("UN-Ordered Path (" + ((AstPathCollection<?>) elem).getType() + ") [");
                    strB.append("\n");
                }
                strB.append(printPaths((AstPathList<AstElem>) elem, pathToString, newLine));
                strB.append("\n");
                strB.append("]");
                strB.append("\n");
            } else {
                throw new IllegalStateException("Unknown AstElem type " + elem.getClass());
            }
        }
        return strB.toString();
    }

}
