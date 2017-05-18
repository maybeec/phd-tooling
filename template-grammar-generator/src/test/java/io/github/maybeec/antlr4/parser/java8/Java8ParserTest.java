package io.github.maybeec.antlr4.parser.java8;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import org.antlr.parser.java8.Java8Lexer;
import org.antlr.parser.java8.Java8Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.junit.BeforeClass;
import org.junit.Test;

import io.github.maybeec.antlr4.parser.common.AbstractTemplateParserTest;

public class Java8ParserTest extends AbstractTemplateParserTest {

    @BeforeClass
    public static void setJava8Parser() {
        parserClass = Java8Parser.class;
        lexerClass = Java8Lexer.class;
        parserGrammar = Paths.get("src/test/antlr4/Java8.g4");
    }

    @Test
    public void parseCompilationUnit_java8_parse_field_snippet() throws Exception {
        File file = new File("src/test/resources/templates/java8_parse_field_snippet.ftl");
        parse("compilationUnit", file, PredictionMode.LL);
        // do not fail
    }

    @Test
    public final void parserCompilationUnit_LL_EXACT_AMBIG_parse_java_methodinvocation() throws Exception {
        File template = new File("src/test/resources/templates/java8template_parse_java_methodinvokation.ftl");
        List<ParserRuleContext> trees = parseAmbiguities("compilationUnit", template, PredictionMode.LL);
        assertThat(trees).hasSize(1);
    }

}
