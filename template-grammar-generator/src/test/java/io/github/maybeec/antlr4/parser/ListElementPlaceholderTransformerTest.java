package io.github.maybeec.antlr4.parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.nio.file.Path;
import java.util.HashSet;

import org.antlr.v4.runtime.misc.MultiMap;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import io.github.maybeec.antlr4.generator.GrammarExtenderCore;
import io.github.maybeec.antlr4.generator.Tactics;

/**
 *
 */
public class ListElementPlaceholderTransformerTest {

    @Rule
    public TemporaryFolder tmpFolderFactory = new TemporaryFolder();

    @Test
    public void testIsListPattern() throws Exception {

        // define template grammar properties
        String grammarName = "BasicListPattern";
        String newGrammarName = "BasicListPatternTemplate";
        String placeHolderName = "PLACEHOLDER";
        String metaLangPrefix = "fm_";
        Tactics customTactic = Tactics.ALL_PARSER_CUSTOM_LEXER;
        HashSet<String> tokenNames = new HashSet<>();
        tokenNames.add("Identifier");
        customTactic.addTokens(tokenNames);

        File folder = tmpFolderFactory.newFolder();

        // transform grammar
        GrammarExtenderCore.extendGrammar("src/test/antlr4/" + grammarName + ".g4", folder.getAbsolutePath() + "/",
            customTactic, "src/test/antlr4/SimpleFreeMarker.g4", newGrammarName, metaLangPrefix, placeHolderName,
            "ANY");

        Path generatedGrammar = folder.toPath().resolve(newGrammarName + ".g4");
        MultiMap<String, String> detectedListPatternRules =
            new ListPatternCollector(generatedGrammar).detectListPatternInstantiations();

        assertThat(detectedListPatternRules).containsOnlyKeys("Identifier");
        assertThat(detectedListPatternRules.get("Identifier")).containsExactly("packageSegmentList", "DOT");
    }
}
