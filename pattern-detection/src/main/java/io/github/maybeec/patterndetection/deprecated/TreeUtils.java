package io.github.maybeec.patterndetection.deprecated;

import java.util.LinkedHashSet;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.ParseTree;

public class TreeUtils {

    public static LinkedHashSet<TreePath> flatten(ParserRuleContext root, Vocabulary parserVocabulary) {
        LinkedHashSet<TreePath> pathToValue = new LinkedHashSet<>();
        flatten(root, new TreePath(""), pathToValue, parserVocabulary);
        return pathToValue;
    }

    private static void flatten(ParseTree root, TreePath parentPath, LinkedHashSet<TreePath> pathToValue,
        Vocabulary parserVocabulary) {
        if (root instanceof ParserRuleContext) {
            TreePath path = parentPath.resolve(root.getClass().getSimpleName(), null);

            for (ParseTree child : ((ParserRuleContext) root).children) {
                flatten(child, path, pathToValue, parserVocabulary);
            }
        } else {
            TreePath childPath = parentPath
                .resolve(parserVocabulary.getSymbolicName(((Token) root.getPayload()).getType()), root.getText());
            pathToValue.add(childPath.getRoot());
        }

    }
}
