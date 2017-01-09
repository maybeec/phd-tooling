package antlr4Parser;

import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 *
 * @author fkreis (06.05.2016)
 */
public class ErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
        int charPositionInLine, String msg, RecognitionException e) {
        List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
        Collections.reverse(stack);

        String newMsg = "line " + line + ":" + charPositionInLine + ": " + msg;

        throw new ANTLRParseException(line, charPositionInLine, newMsg);
    }

}
