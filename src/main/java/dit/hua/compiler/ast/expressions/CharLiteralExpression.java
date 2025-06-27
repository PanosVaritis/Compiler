package dit.hua.compiler.ast.expressions;

import dit.hua.compiler.ast.ASTVisitor;

//Class used to represent character literal constants like: 'a' ,'\n',..
//Matches the production: expr :: = CHAR_LITERAL

public class CharLiteralExpression extends Expression {

    private String value;

    public CharLiteralExpression(String value){
        super();
        this.value = value;
    }

    public CharLiteralExpression (int line, int column, String value){
        super (line, column);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
   
    /**
     * Gets the actual character value (without quotes)
     */
    public char getCharValue() {
        if (value.length() == 3) { // 'a'
            return value.charAt(1);
        } else { // escape sequence like '\n'
            String escaped = value.substring(1, value.length() - 1);
            return parseEscapeSequence(escaped);
        }
    }
    
    private char parseEscapeSequence(String escaped) {
        switch (escaped) {
            case "\\n": return '\n';
            case "\\t": return '\t';
            case "\\r": return '\r';
            case "\\0": return '\0';
            case "\\\\": return '\\';
            case "\\'": return '\'';
            case "\\\"": return '\"';
            default:
                if (escaped.startsWith("\\x")) {
                    String hex = escaped.substring(2);
                    return (char) Integer.parseInt(hex, 16);
                }
                return escaped.charAt(0);
        }
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
