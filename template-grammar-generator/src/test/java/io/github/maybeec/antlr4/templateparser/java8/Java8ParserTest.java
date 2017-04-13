package io.github.maybeec.antlr4.templateparser.java8;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.junit.Test;

import io.github.maybeec.antlr4.analysis.ANTLRParseException;
import io.github.maybeec.antlr4.analysis.ErrorListener;

public class Java8ParserTest {

    @Test
    public void parseCompilationUnit_java8() throws Exception {
        PredictionMode.resetAmbiguityData();

        // template parsing
        File template = new File("src/test/resources/templates/java8_snippet.ftl");
        Reader reader = new FileReader(template);
        Java8TemplateLexer lexer = new Java8TemplateLexer(new ANTLRInputStream(reader));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Java8TemplateParser parser = new Java8TemplateParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());
        parser.getInterpreter().setPredictionMode(PredictionMode.LL);

        int count = 0;
        long start = System.nanoTime();
        ParserRuleContext tree;
        System.out.println("start parsing");
        try {
            tree = parser.compilationUnit();
        } catch (ANTLRParseException e) {
            System.out.println("parsing not successfull!");
            System.err.println(e.getMsg());
            fail(e.getMsg());
        }
        System.out.println("parsing complete");
        parser.reset();
        System.out.println("Number of ambiguities detected: " + PredictionMode.getAmbiguityCounter());

        count++;

        // Generates the GUI
        // Future<JFrame> future = Trees.inspect(tree, parser);
        // while (future.get().isVisible()) {
        // try {
        // Thread.sleep(100);
        // } catch (InterruptedException e) {
        // }
        // }
        long end = System.nanoTime();

        System.out.println(count + " trees parsed in " + ((end - start) / Math.pow(10, 9)) + "s");

    }

}
