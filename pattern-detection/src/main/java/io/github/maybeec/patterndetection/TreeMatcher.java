package io.github.maybeec.patterndetection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import io.github.maybeec.patterndetection.exception.NoMatchException;
import io.github.maybeec.patterndetection.exception.NotYetImplementedException;

/**
 *
 */
public class TreeMatcher {

    private ParseTree templatePointer;

    private ParseTree appPointer;

    private Set<ParseTree> visited = new HashSet<>();

    private Map<String, Set<String>> tokenSubstituitions = new HashMap<>();

    private Map<String, String> selectedSubstitutions = new HashMap<>();

    private Map<String, Integer> selectedSubstitutionTokenCount = new HashMap<>();

    private Vocabulary lexerVocabulary;

    private Stack<MatcherState> decisionPoints = new Stack<>();

    public TreeMatcher(ParseTree templateCST, ParseTree applicationFileCST, Vocabulary lexerVocabulary) {
        templatePointer = templateCST;
        appPointer = applicationFileCST;
        this.lexerVocabulary = lexerVocabulary;
    }

    public Map<String, String> detect() {
        if (!appPointer.getClass().equals(templatePointer.getClass())) {
            throw new NoMatchException("NO MATCH AT ROOT");
        }

        appPointer = stepDown(appPointer, false);
        templatePointer = stepDown(templatePointer, false);

        decisionPoints
            .push(new MatcherState(selectedSubstitutions, selectedSubstitutionTokenCount, appPointer, templatePointer));
        boolean backtracking = false;
        while (true) {
            try {
                while (LA(appPointer, 1, false) != null && LA(templatePointer, 1, false) != null) {
                    if (templatePointer.getClass().equals(appPointer.getClass())) {
                        if (templatePointer instanceof TerminalNodeImpl) {
                            if (!templatePointer.getText().equals(appPointer.getText())) {
                                throw new NoMatchException("Could not match template['" + templatePointer.getText()
                                    + "'], app['" + appPointer.getText() + "']");
                            }
                            System.out.println("Consume template['" + templatePointer.getText() + "'] and app['"
                                + appPointer.getText() + "']");
                        } else {
                            // System.out.println("Consume template['" +
                            // templatePointer.getClass().getSimpleName()
                            // + "', '" + templatePointer.getText() + "'] and app['"
                            // + appPointer.getClass().getSimpleName() + "', '" + appPointer.getText() +
                            // "']");
                        }
                        appPointer = LA(appPointer, 1, false);
                        templatePointer = LA(templatePointer, 1, false);
                    } else if (templatePointer.getClass().getName().matches(".*Parser\\$Fm_.*")) {

                        if (!backtracking) {
                            decisionPoints.push(new MatcherState(selectedSubstitutions, selectedSubstitutionTokenCount,
                                appPointer, templatePointer));
                        }
                        backtracking = false;

                        // ####### normal placeholder rule
                        // goto next token as we are currently facing a the template language rule
                        templatePointer = LA(templatePointer, 1, true);
                        ParseTree nextTemplateToken = LA(templatePointer, 1, true);
                        Token token = ((TerminalNodeImpl) templatePointer).getSymbol();
                        if ("FM_PLACEHOLDER".equals(lexerVocabulary.getSymbolicName(token.getType()))) {

                            if (selectedSubstitutions.containsKey(token.getText())) {
                                System.out.println(
                                    ">>> Take substitution from selection: template['" + templatePointer.getText()
                                        + "'], app['" + selectedSubstitutions.get(token.getText()) + "'], count: "
                                        + selectedSubstitutionTokenCount.get(token.getText()));
                                appPointer = LA(appPointer, selectedSubstitutionTokenCount.get(token.getText()), true);
                                templatePointer = LA(templatePointer, 1, false);
                            } else {
                                ParseTree placeholderSubstitutionPointer = appPointer;
                                List<ParseTree> path = new ArrayList<>();
                                while (placeholderSubstitutionPointer != null) {
                                    path.add(placeholderSubstitutionPointer);

                                    if (path.get(path.size() - 1).getText().equals(nextTemplateToken.getText())) {
                                        String placeholderSubstitution = path.stream().limit(path.size() - 1)
                                            .filter(c -> c instanceof TerminalNodeImpl).map(t -> t.getText())
                                            .collect(Collectors.joining());

                                        // to not take decision twice after backtracking
                                        if (tokenSubstituitions.get(token.getText()) != null && tokenSubstituitions
                                            .get(token.getText()).contains(placeholderSubstitution)) {
                                            placeholderSubstitutionPointer =
                                                LA(placeholderSubstitutionPointer, 1, true);
                                            continue;
                                        } else if (tokenSubstituitions.get(token.getText()) == null) {
                                            tokenSubstituitions.put(token.getText(), new HashSet<>());
                                        }
                                        tokenSubstituitions.get(token.getText()).add(placeholderSubstitution);
                                        selectedSubstitutions.put(token.getText(), placeholderSubstitution);
                                        selectedSubstitutionTokenCount.put(token.getText(), path.size() - 1);

                                        System.out.println("Consume template['" + templatePointer.getText()
                                            + "'] and app['" + placeholderSubstitution + "']");
                                        System.out.println("Consume template['" + path.get(path.size() - 1).getText()
                                            + "'] and app['" + placeholderSubstitutionPointer.getText() + "']");

                                        appPointer = LA(placeholderSubstitutionPointer, 1, false);
                                        templatePointer = LA(nextTemplateToken, 1, false);
                                        break;
                                    }
                                    placeholderSubstitutionPointer = LA(placeholderSubstitutionPointer, 1, true);
                                }
                            }

                            if (LA(appPointer, 1, false) == null) {
                                throw new NoMatchException("NO MATCH FOUND FOR PLACEHOLDER");
                            }
                        }

                        // TODO check of *Star, *Opt, *Plus
                    } else {
                        String message = "NOT YET COVERED template: " + templatePointer.getClass().getSimpleName()
                            + "['" + templatePointer.getText() + "', '" + templatePointer.toStringTree() + "'], app: "
                            + appPointer.getClass().getSimpleName() + "['" + appPointer.getText() + "', '"
                            + appPointer.toStringTree() + "']";
                        System.out.println(message);
                        throw new NotYetImplementedException(message);
                    }
                }
                break;
            } catch (NoMatchException e) {
                if (decisionPoints.isEmpty()) {
                    System.out.println("NO MATCH: " + e.getMessage());
                    throw e;
                } else {
                    MatcherState latest = decisionPoints.pop();
                    appPointer = latest.getAppPointer();
                    templatePointer = latest.getTemplatePointer();
                    selectedSubstitutions = latest.getSelectedSubstitutions();
                    selectedSubstitutionTokenCount = latest.getSelectedSubstitutionTokenCount();
                    visited.clear();
                    System.out.println("NO MATCH: " + e.getMessage());
                    System.out.println("Backtracking...");
                    backtracking = true;
                }
            }
        }

        System.out.println("END");
        return selectedSubstitutions;
    }

    private ParseTree LA(ParseTree pointer, int la, boolean toNextToken) {
        // first lets try stepping down
        if (!visited.contains(pointer)) {
            ParseTree stepDown = stepDown(pointer, toNextToken);
            if (stepDown != null) {
                la--;
                if (la == 0) {
                    return stepDown;
                }
            }
        }

        // else try siblings, or step up
        if (pointer.getParent() != null) {
            List<ParseTree> siblings = ((ParserRuleContext) pointer.getParent()).children;
            int position = getIndex(pointer, siblings);
            while (la > 0) {
                if (position + 1 < siblings.size()) {
                    ParseTree next = siblings.get(position + 1);
                    if (!toNextToken || next.getChildCount() == 0) {
                        pointer = next;
                        la--;
                    } else {
                        pointer = stepDown(next, toNextToken);
                        la--;
                    }
                } else {
                    visited.add(pointer.getParent());
                    return LA(pointer.getParent(), la, toNextToken);
                }
            }
        } else {
            return null;
        }
        return pointer;
    }

    // private ParseTree LAToken(ParseTree pointer, int la) {
    // // first lets try stepping down
    // ParseTree stepDown = stepDownToNextToken(pointer);
    // if (stepDown != null) {
    // return stepDown;
    // }
    //
    // // else try siblings, or step up
    // if (pointer.getParent() != null) {
    // List<ParseTree> siblings = ((ParserRuleContext) pointer.getParent()).children;
    // int position = getIndex(pointer, siblings);
    // while (la > 0) {
    // if (position + 1 < siblings.size()) {
    // ParseTree next = siblings.get(position + 1);
    // if (next.getChildCount() == 0) {
    // pointer = next;
    // la--;
    // } else {
    // pointer = stepDownToNextToken(pointer);
    // la--;
    // }
    // } else {
    // return LAToken(pointer.getParent(), la);
    // }
    // }
    // }
    // return pointer;
    // }

    private ParseTree stepDown(ParseTree pointer, boolean toNextToken) {
        if (pointer.getChildCount() == 0) {
            return null;
        }

        ParseTree curr = pointer;
        do {
            curr = curr.getChild(0);
        } while (toNextToken && curr.getChildCount() > 0);
        return curr;
    }

    private int getIndex(ParseTree pointer, List<ParseTree> siblings) {
        for (int i = 0; i < siblings.size(); i++) {
            if (siblings.get(i).equals(pointer)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Should not be called currently if the pointer is not in list of siblings.");
    }
}
