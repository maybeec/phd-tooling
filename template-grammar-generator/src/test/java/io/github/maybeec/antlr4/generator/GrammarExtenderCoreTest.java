package io.github.maybeec.antlr4.generator;

import java.util.HashSet;

import org.junit.Test;

public class GrammarExtenderCoreTest {

    @Test
    public void extendJava8Grammar() throws Exception {

        // define template grammar properties
        String newGrammarName = "Java8Template";
        String placeHolderName = "PLACEHOLDER";
        String metaLangPrefix = "fm_";
        String targetPackage = "io.github.maybeec.antlr4.templateparser.java8";
        Tactics customTactic = Tactics.ALL_PARSER_CUSTOM_LEXER;
        HashSet<String> tokenNames = new HashSet<>();
        tokenNames.add("Identifier");
        customTactic.addTokens(tokenNames);

        // transform grammar
        GrammarExtenderCore.extendGrammar("src/main/antlr4/Java8.g4",
            "target/generated-sources/antlr4/" + targetPackage.replace(".", "/") + "/", customTactic,
            "src/main/antlr4/SimpleFreeMarker.g4", newGrammarName, metaLangPrefix, placeHolderName, targetPackage,
            "ANY");
    }

    @Test
    public void extendJava7Grammar() throws Exception {

        // define template grammar properties
        String newGrammarName = "Java7Template";
        String placeHolderName = "PLACEHOLDER";
        String metaLangPrefix = "fm_";
        String targetPackage = "io.github.maybeec.antlr4.templateparser.java7";
        Tactics customTactic = Tactics.ALL_PARSER_CUSTOM_LEXER;
        HashSet<String> tokenNames = new HashSet<>();
        tokenNames.add("Identifier");
        customTactic.addTokens(tokenNames);

        // transform grammar
        GrammarExtenderCore.extendGrammar("src/main/antlr4/Java7.g4",
            "target/generated-sources/antlr4/" + targetPackage.replace(".", "/") + "/", customTactic,
            "src/main/antlr4/SimpleFreeMarker.g4", newGrammarName, metaLangPrefix, placeHolderName, targetPackage,
            "ANY");
    }

}
