package dit.hua.compiler.ast.expressions;

import dit.hua.compiler.ast.ASTVisitor;
import dit.hua.compiler.ast.Operator;

/*
 * Represents binary expressions 
 * Two operands and one operator
 * Matches the productions expr :: = expr operator expr
 */

public class BinaryExpression extends Expression {

    private Operator operator;
    private Expression left;
    private Expression right;

    public BinaryExpression (Operator operator, Expression left, Expression right){
        super();
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
