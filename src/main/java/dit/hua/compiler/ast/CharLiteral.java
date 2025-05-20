package dit.hua.compiler.ast;

import dit.hua.compiler.type.BasicType;

public class CharLiteral extends Expression {
    private char value;

    public CharLiteral(char value) {
        this.value = value;
        this.type = BasicType.Char;
    }

    public String toString() {
        return "CharLiteral(" + value + ")";
    }
}
