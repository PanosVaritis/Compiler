package dit.hua.compiler.ast;

import dit.hua.compiler.type.BasicType;

public class IntLiteral extends Expression {

    private int value;

    public IntLiteral(int value) {
        this.value = value;
        this.type = BasicType.Int;
    }

    public String toString() {
        return "IntLiteral(" + value + ")";
    }
}
