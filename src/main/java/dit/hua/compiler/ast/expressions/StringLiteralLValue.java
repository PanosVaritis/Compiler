package dit.hua.compiler.ast.expressions;

import dit.hua.compiler.ast.ASTVisitor;

/*
 * l_value ::= STRING_LITERAL
 * Represents string literals
 */


public class StringLiteralLValue extends LValue{

    private String value; //including quotes

    public StringLiteralLValue (String value){
        super();
        this.value = value;
    }

    public StringLiteralLValue (int line, int column, String value){
        super(line, column);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
    * Gets the string content without quotes
    */
    public String getStringValue() {
        if (value.length() >= 2) {
            return value.substring(1, value.length() - 1);
        }
        return value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
