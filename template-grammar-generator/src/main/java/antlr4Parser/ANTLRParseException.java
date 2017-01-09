package antlr4Parser;

/**
 *
 * @author fkreis (06.05.2016)
 */
public class ANTLRParseException extends RuntimeException {

    private int line;

    private int charPositionInLine;

    private String msg;

    /**
     * @param line
     * @param charPositionInLine
     * @param msg
     * @author fkreis (06.05.2016)
     */
    public ANTLRParseException(int line, int charPositionInLine, String msg) {
        this.line = line;
        this.charPositionInLine = charPositionInLine;
        this.msg = msg;
    }

    /**
     * Returns the field 'line'
     * @return value of line
     * @author fkreis (06.05.2016)
     */
    public int getLine() {
        return line;
    }

    /**
     * Returns the field 'charPositionInLine'
     * @return value of charPositionInLine
     * @author fkreis (06.05.2016)
     */
    public int getCharPositionInLine() {
        return charPositionInLine;
    }

    /**
     * Returns the field 'msg'
     * @return value of msg
     * @author fkreis (06.05.2016)
     */
    public String getMsg() {
        return msg;
    }

}
