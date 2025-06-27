package dit.hua.compiler.ast.expressions;

import dit.hua.compiler.ast.ASTVisitor;

/**
 * Represents array access like arr[i], matrix[x][y].
 * Matches: l_value ::= l_value "[" expr "]"
 */

public class ArrayAccessLValue extends LValue{

    private LValue array;
    private Expression index;
    
    public ArrayAccessLValue(LValue array, Expression index) {
        super();
        this.array = array;
        this.index = index;
    }
    
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
    
    public LValue getArray() { return array; }
    public Expression getIndex() { return index; }
    public void setArray(LValue array) { this.array = array; }
    public void setIndex(Expression index) { this.index = index; }
    
}
