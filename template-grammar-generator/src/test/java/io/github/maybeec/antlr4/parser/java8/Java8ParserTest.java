package io.github.maybeec.antlr4.parser.java8;

import java.io.File;

import org.antlr.parser.java8.Java8Lexer;
import org.antlr.parser.java8.Java8Parser;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.junit.BeforeClass;
import org.junit.Test;

import io.github.maybeec.antlr4.parser.common.AbstractTemplateParserTest;

public class Java8ParserTest extends AbstractTemplateParserTest {

    @BeforeClass
    public static void setJava8Parser() {
        parserClass = Java8Parser.class;
        lexerClass = Java8Lexer.class;
    }

    @Test
    public void parseCompilationUnit_java8_parse_field_snippet() throws Exception {
        File file = new File("src/test/resources/templates/java8_parse_field_snippet.ftl");
        parse(file, PredictionMode.LL, false);
    }

}
