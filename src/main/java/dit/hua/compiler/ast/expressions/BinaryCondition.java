package dit.hua.compiler.ast.expressions;

import dit.hua.compiler.ast.ASTVisitor;
import dit.hua.compiler.ast.Operator;

/**
 * Represents comparison operations like a=b, x<y, i>=j.
 * Matches: cond ::= expr ("="|"#"|"<"|">"|"<="|">=") expr
 */


public class BinaryCondition extends Condition{

    private Operator operator;
    private Expression left;
    private Expression right;


    public BinaryCondition(Operator operator, Expression left, Expression right) {
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
