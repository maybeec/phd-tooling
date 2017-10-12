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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import io.github.maybeec.patterndetection.entity.ListType;
import io.github.maybeec.patterndetection.entity.Match;
import io.github.maybeec.patterndetection.entity.NonOrderedContainerMatch;
import io.github.maybeec.patterndetection.entity.OrderedContainerMatch;
import io.github.maybeec.patterndetection.exception.NoMatchException;
import io.github.maybeec.patterndetection.utils.CartesianIterator;
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
            nonOrderedNodes
                .add("Fm_" + Character.toLowerCase(production.charAt(0)) + production.substring(1) + "Context");
            nonOrderedNodes
                .add("Fm_" + Character.toLowerCase(production.charAt(0)) + production.substring(1) + "OptContext");
            nonOrderedNodes
                .add("Fm_" + Character.toLowerCase(production.charAt(0)) + production.substring(1) + "StarContext");
            nonOrderedNodes
                .add("Fm_" + Character.toLowerCase(production.charAt(0)) + production.substring(1) + "PlusContext");
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

    public Match match() {

        System.out.println("");
        System.out.println(">> Template: ");
        System.out.println("");

        ParseTreeWalker walker = new ParseTreeWalker();
        AstToPathTransformer listener = new AstToPathTransformer(new JavaTemplateParser(null).getVocabulary(),
            statementTerminals, listPatterns, nonOrderedNodes);
        walker.walk(listener, templatePointer);
        AstPathSet rootSet = new AstPathSet(ListType.ATOMIC, "ROOT");
        AstPathList templatePaths = listener.getPaths();
        rootSet.add(templatePaths);
        System.out.println(printPaths(rootSet, e -> e.getPath(), true));

        System.out.println("");
        System.out.println(">> APP: ");
        System.out.println("");

        listener = new AstToPathTransformer(new JavaTemplateParser(null).getVocabulary(), statementTerminals,
            listPatterns, nonOrderedNodes);
        walker.walk(listener, appPointer);
        rootSet = new AstPathSet(ListType.ATOMIC, "ROOT");
        AstPathList appPaths = listener.getPaths();
        rootSet.add(appPaths);
        System.out.println(printPaths(rootSet, e -> e.getPath(), true));

        return new OrderedContainerMatch(match(templatePaths, appPaths));
    }

    /**
     * @param templatePaths
     * @param appPaths
     */
    private List<List<Match>> match(AstPathList templatePaths, AstPathList appPaths) {
        // separate unordered nodes from ordered ones
        List<AstPathList> unorderedTempPaths = templatePaths.stream().filter(elem -> elem instanceof AstPathList)
            .filter(elem -> !((AstPathList) elem).isOrdered()).map(elem -> (AstPathList) elem)
            .collect(Collectors.toList());
        List<AstPathList> unorderedAppPaths = appPaths.stream().filter(elem -> elem instanceof AstPathList)
            .filter(elem -> !((AstPathList) elem).isOrdered()).map(elem -> (AstPathList) elem)
            .collect(Collectors.toList());

        List<AstElem> orderedTemplatePaths = templatePaths.stream()
            .filter(elem -> (elem instanceof AstPath)
                || (elem instanceof AstPathCollection) && ((AstPathCollection) elem).isOrdered())
            .collect(Collectors.toList());
        List<AstElem> orderedAppPaths = appPaths.stream()
            .filter(elem -> (elem instanceof AstPath)
                || (elem instanceof AstPathCollection) && ((AstPathCollection) elem).isOrdered())
            .collect(Collectors.toList());

        List<Match> listOfMatches = new ArrayList<>();
        List<List<Match>> matchesOrderedPaths = matchOrderedPaths(orderedTemplatePaths, orderedAppPaths, false);
        listOfMatches.add(new OrderedContainerMatch(matchesOrderedPaths));

        List<List<Match>> matches = getAllUnorderedMatches(unorderedTempPaths, unorderedAppPaths);
        listOfMatches.add(new NonOrderedContainerMatch(matches));

        return Arrays.asList(listOfMatches);
    }

    /**
     * @param unorderedTempPaths
     * @param unorderedAppPaths
     * @return
     */
    private List<List<Match>> getAllUnorderedMatches(List<AstPathList> unorderedTempPaths,
        List<AstPathList> unorderedAppPaths) {
        if (unorderedTempPaths.isEmpty()) {
            return new ArrayList<>();
        }

        // unorderedTempPaths.sort(new Comparator<AstPathList>() {
        // @Override
        // public int compare(AstPathList o1, AstPathList o2) {
        // return o1.getType().compareTo(o2.getType());
        // }
        // });

        List<List<Match>> matches = new ArrayList<>();
        Iterator<AstPathList> it = unorderedTempPaths.iterator();
        Map<OrderedContainerMatch, AstPathList> matchTargets = new HashMap<>();
        while (it.hasNext()) {
            AstPathList tempElem = it.next();

            List<Match> matchesTemp = new ArrayList<>();
            for (AstPathList appElem : unorderedAppPaths) {
                try {
                    OrderedContainerMatch match;
                    if (tempElem.isMetaLang()) {
                        match = new OrderedContainerMatch(matchMetaRule(tempElem, appElem));
                    } else {
                        match = new OrderedContainerMatch(match(tempElem, appElem));
                    }
                    matchesTemp.add(match);
                    matchTargets.put(match, appElem);
                } catch (NoMatchException e) {
                    // ignore as there might be another match
                    // System.out.println(e.getMessage());
                    // e.printStackTrace();
                }
            }
            if (!matchesTemp.isEmpty()) {
                matches.add(matchesTemp);
                it.remove();
            }
        }

        if (!unorderedTempPaths.isEmpty()) {
            throw new NoMatchException("The following template paths could not be found: \n" + unorderedTempPaths
                .stream().map(e -> printPaths(e, AstPath::getText, false)).collect(Collectors.joining("\n")));
        }

        List<List<Match>> allDistinctMatches = getAllDistinctMatches(matches, matchTargets);
        if (allDistinctMatches.isEmpty()) {
            throw new NoMatchException("The following template paths could not be found: \n" + unorderedTempPaths
                .stream().map(e -> printPaths(e, AstPath::getText, false)).collect(Collectors.joining("\n")));
        }

        return allDistinctMatches;
    }

    /**
     * @param tempElem
     * @param appElem
     */
    private List<List<Match>> matchMetaRule(AstPathList tempElem, AstPathList appElem) {

        List<List<Match>> matches = new ArrayList<>();

        AstElem firstTempElemChild = tempElem.get(0);
        if (firstTempElemChild instanceof AstPath) {
            if (((AstPath) firstTempElemChild).isMetaLang()
                && ((AstPath) firstTempElemChild).getName().equals("FM_PLACEHOLDER")
                && tempElem.getHint().matches("Fm_" + appElem.getHint() + "(Opt|Star|Plus)?Context")) {
                ArrayList<Match> list = new ArrayList<>();
                list.add(new AtomarMatch(tempElem, appElem, matchPlaceholder(((AstPath) firstTempElemChild).getText(),
                    printPaths(appElem, e -> e.getText(), false))));
                matches.add(list);
            } else {
                throw new NoMatchException("Cannot match " + printPaths(tempElem, e -> e.getPath(), true));
            }
        } else if (((AstPathCollection) firstTempElemChild).isMetaLang()) { // AstPathCollection
            switch (((AstPathCollection) firstTempElemChild).getType()) {
            case OPTIONAL:
            case ARBITRARY:
                try {
                    if (((AstPathList) firstTempElemChild).isMetaLang()) {
                        matches = matchMetaRule((AstPathList) firstTempElemChild, appElem);
                    } else {
                        matches = match((AstPathList) firstTempElemChild, appElem);
                    }
                } catch (NoMatchException e) {
                    // ignore, check later as of consistency
                }
                break;
            case ALTERNATIVE:
                for (AstElem tempChildElem : (AstPathCollection) firstTempElemChild) {
                    try {
                        if (((AstPathList) tempChildElem).isMetaLang()) {
                            matches = matchMetaRule((AstPathList) tempChildElem, appElem);
                        } else {
                            // TODO check if we can return a match object instead as currently it would mix up
                            // multiple alternative matches here
                            matches.addAll(match((AstPathList) tempChildElem, appElem));
                        }
                        // TODO add variableAssignment (AstPathCollection) firstTempElemChild.getHint()
                    } catch (NoMatchException e) {
                        // ignore, check later as of consistency
                    }
                }
                if (matches.isEmpty()) {
                    throw new NoMatchException("No match found for " + printPaths(tempElem, e -> e.getPath(), true));
                }
                break;
            case ATOMIC:
                if (((AstPathList) firstTempElemChild).isMetaLang()) {
                    matches = matchMetaRule((AstPathList) firstTempElemChild, appElem);
                } else {
                    matches = match((AstPathList) firstTempElemChild, appElem);
                }
                break;
            default:
                break;
            }
        } else {
            return match((AstPathList) firstTempElemChild, appElem);
        }
        return matches;
    }

    private List<List<Match>> getAllDistinctMatches(List<List<Match>> subsequentMatches,
        Map<OrderedContainerMatch, AstPathList> matchTargets) {
        List<List<Match>> validMatches = new ArrayList<>();
        CartesianIterator<Match> it = new CartesianIterator<>(subsequentMatches);
        while (it.hasNext()) {
            List<Match> next = it.next();
            Set<AstPathList> matchedAppElements =
                next.stream().map(e -> matchTargets.get(e)).distinct().collect(Collectors.toSet());
            if (matchedAppElements.size() == next.size()) {
                validMatches.add(next);
            } // otherwise, some app elements have been matched multiple times in one go
        }
        return validMatches;
    }

    /**
     * @param orderedTemplatePaths
     * @param orderedAppPaths
     * @return
     */
    private List<List<Match>> matchOrderedPaths(List<AstElem> orderedTemplatePaths, List<AstElem> orderedAppPaths,
        boolean exactly) {

        List<Match> listOfMatches = new ArrayList<>();

        int j = 0;
        for (int i = 0; i < orderedTemplatePaths.size(); i++) {
            AstElem tempElem = orderedTemplatePaths.get(i);

            AstElem appElem;
            boolean matches;
            do {
                if (j >= orderedAppPaths.size()) {
                    // template could not be found entirely in app!
                    String debugVal = tempElem instanceof AstPath ? ((AstPath) tempElem).getPath()
                        : ((AstPathCollection) tempElem).getHint();
                    throw new NoMatchException("Could not find path " + debugVal);
                }
                appElem = orderedAppPaths.get(j);

                matches = true;
                try {
                    listOfMatches.add(new OrderedContainerMatch(matchPath(tempElem, appElem)));
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
        return Arrays.asList(listOfMatches);
    }

    /**
     * @param appElem
     * @return
     */
    public List<List<Match>> matchPath(AstElem tempElem, AstElem appElem) {
        if (tempElem instanceof AstPathList && ((AstPathList) tempElem).isAtomic() && appElem instanceof AstPathList
            && ((AstPathList) appElem).isAtomic()) {
            return matchOrderedPaths((AstPathList) tempElem, (AstPathList) appElem, true);
        } else if (tempElem instanceof AstPathList && ((AstPathList) tempElem).isListPattern()
            && appElem instanceof AstPathList && ((AstPathList) appElem).isListPattern()) {
            return matchListPattern((AstPathList) tempElem, (AstPathList) appElem);
        } else if (tempElem instanceof AstPathList && !((AstPathList) tempElem).isAtomic()
            && appElem instanceof AstPathList && !((AstPathList) appElem).isAtomic()) {
            return matchOrderedPaths((AstPathList) tempElem, (AstPathList) appElem, false);
        } else if (tempElem instanceof AstPath && appElem instanceof AstPath) {
            AstPath startingTemp = (AstPath) tempElem;
            AstPath startingApp = (AstPath) appElem;
            AstPath currentTemp = startingTemp;
            AstPath currentApp = startingApp;

            Map<String, String> variableSubstitutions = new HashMap<>();

            List<Match> listOfMatches = new ArrayList<>();
            if (!currentTemp.isMetaLang()) {
                // trivial case
                if (currentApp.getPath().equals(currentTemp.getPath())
                    && currentApp.getText().equals(currentTemp.getText())) {
                    System.out.println("Consume (t->a): " + startingTemp + " --> " + startingApp);
                    listOfMatches.add(new AtomarMatch(tempElem, appElem, variableSubstitutions));
                } else if (!currentTemp.containsMetaLang()) {
                    throw new NoMatchException(
                        "Could not find " + startingTemp.getPath() + " in " + startingApp.getPath());
                }
            } else {
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
                            variableSubstitutions.putAll(matchPlaceholder(currentTemp.getText(), currentApp.getText()));
                            break;
                        }
                    } else {
                        currentApp = currentApp.getParent();
                    }
                    currentTemp = currentTemp.getParent();
                } while (currentTemp != null);

                System.out.println("Consume (t->a): " + startingTemp + " --> " + startingApp);
                listOfMatches.add(new AtomarMatch(tempElem, appElem, variableSubstitutions));
            }
            return Arrays.asList(listOfMatches);
        } else {
            throw new NoMatchException("Cannot match AstPath " + tempElem + " against AstPathCollection " + appElem);
        }
    }

    /**
     * @param placeholder
     * @param appCode
     * @return
     */
    private Map<String, String> matchPlaceholder(String placeholder, String appCode) {
        // get list of concatenated constant or variable fragments within placeholder decl
        if (!placeholder.matches("\\$\\{.+\\}")) {
            throw new NoMatchException("Unknown placeholder syntax: " + placeholder);
        }
        placeholder = placeholder.substring(2, placeholder.length() - 1);

        Map<String, String> variableAssignments = new HashMap<>(1);
        String[] fragments = placeholder.split("\\+");
        if (fragments.length == 1) {
            variableAssignments.put(placeholder, appCode);
            return variableAssignments;
        }

        StringBuilder regexBuilder = new StringBuilder();
        List<String> phVariables = new ArrayList<>();
        for (String frag : fragments) {
            frag = frag.trim();
            if (frag.matches("\".*\"")) {
                regexBuilder.append(frag.substring(1, frag.length() - 1));
            } else {
                phVariables.add(frag);
                regexBuilder.append("(.+)");
            }
        }
        String[] phVariablesArr = phVariables.toArray(new String[0]);

        Pattern p = Pattern.compile(regexBuilder.toString());
        Matcher m = p.matcher(appCode);
        if (m.matches()) {
            for (int i = 1; i <= m.groupCount(); i++) {
                // this is a workaround to find matching/conflicting variable substitutions
                // as variable substitutions are currently stored with the complete syntax
                variableAssignments.put(phVariablesArr[i - 1], m.group(i));
            }
            return variableAssignments;
        } else {
            throw new NoMatchException("Could not match placeholder " + placeholder + " against " + appCode);
        }
    }

    /**
     * @param tempElem
     * @param appElem
     * @return
     */
    private List<List<Match>> matchListPattern(AstPathList orderedTemplatePaths, AstPathList orderedAppPaths) {

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

        List<List<Match>> foundMatches = new ArrayList<>();
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
                                : ((AstPathCollection) tempElem).getHint();
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
                                variableSubstitutions
                                    .putAll(matchPlaceholder(((AstPath) tempElem).getText(), appMatch));
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

                foundMatches
                    .add(Arrays.asList(new AtomarMatch(orderedTemplatePaths, orderedAppPaths, variableSubstitutions)));
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
    private String printPaths(AstPathCollection paths, Function<AstPath, String> pathToString, boolean newLine) {
        StringBuilder strB = new StringBuilder();

        for (AstElem elem : paths) {
            if (elem instanceof AstPath) {
                strB.append(pathToString.apply(((AstPath) elem)));
                if (newLine) {
                    strB.append("\n");
                }
            } else if (elem instanceof AstPathCollection) {
                if (!newLine) {
                    strB.append("\n");
                }
                strB.append(((AstPathCollection) elem).getType());
                strB.append(" Path (" + ((AstPathCollection) elem).getHint() + ") [");
                strB.append("\n");
                strB.append(printPaths((AstPathList) elem, pathToString, newLine));
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
