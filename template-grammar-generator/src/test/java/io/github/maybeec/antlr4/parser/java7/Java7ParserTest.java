package io.github.maybeec.antlr4.parser.java7;

import java.io.File;
import java.nio.file.Paths;

import org.antlr.parser.java7.Java7Lexer;
import org.antlr.parser.java7.Java7Parser;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.junit.BeforeClass;
import org.junit.Test;

import io.github.maybeec.antlr4.parser.common.AbstractTemplateParserTest;

public class Java7ParserTest extends AbstractTemplateParserTest {

    @BeforeClass
    public static void setJava7Parser() {
        parserClass = Java7Parser.class;
        lexerClass = Java7Lexer.class;
        parserGrammar = Paths.get("src/test/antlr4/Java7.g4");
    }

    @Test
    public void parseCompilationUnit_java7_parse_field_snippet() throws Exception {
        File file = new File("src/test/resources/templates/java8_parse_field_snippet.ftl");
        parse("compilationUnit", file, PredictionMode.LL);
        // do not fail
    }

}
