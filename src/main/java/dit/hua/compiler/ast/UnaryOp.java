package dit.hua.compiler.ast;

import dit.hua.compiler.errors.SemanticException;
import dit.hua.compiler.symbol.SymbolTable;
import dit.hua.compiler.type.BasicType;

public class UnaryOp extends Expression {
    public enum Operator {
        Plus, Minus
    }

    private Operator op;
    private Expression expr;
    
    public UnaryOp(Operator op, Expression expr) {
        this.op = op;
        this.expr = expr;
    }

    public void sem(SymbolTable tbl) throws SemanticException {
        expr.typeCheck(tbl, BasicType.Int);
        type = BasicType.Int;
    }

    public String toString() {
        return "UnaryOp(" + op + ", " + expr + ")";
    }
}
