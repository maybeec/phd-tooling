package io.github.maybeec.antlr4.parser.java8;

import java.io.File;

import org.antlr.v4.runtime.atn.PredictionMode;
import org.junit.Test;

import io.github.maybeec.antlr4.common.ParserTestUtil;

public class Java8ParserTest {

    @Test
    public void parseCompilationUnit_java8() throws Exception {
        File file = new File("src/test/resources/templates/java8_snippet.ftl");
        ParserTestUtil.parse(file, PredictionMode.LL, false);
    }

}
