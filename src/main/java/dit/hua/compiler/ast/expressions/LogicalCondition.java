package dit.hua.compiler.ast.expressions;

import dit.hua.compiler.ast.ASTVisitor;
import dit.hua.compiler.ast.LogicalOperator;

/**
 * Represents logical operations like a and b, not c, x or y.
 * Matches: cond ::= "not" cond | cond ("and"|"or") cond
 */

public class LogicalCondition extends Condition {

    private LogicalOperator operator;
    private Condition left; //Might be null
    private Condition right;

    public LogicalCondition(LogicalOperator operator, Condition left, Condition right) {
        super();
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public LogicalCondition (LogicalOperator operator, Condition operand){
        super();
        this.operator = operator;
        this.left = null;
        this.right = operand;
    }

    public LogicalOperator getOperator() {
        return operator;
    }

    public void setOperator(LogicalOperator operator) {
        this.operator = operator;
    }

    public Condition getLeft() {
        return left;
    }

    public void setLeft(Condition left) {
        this.left = left;
    }

    public Condition getRight() {
        return right;
    }

    public void setRight(Condition right) {
        this.right = right;
    }

    public boolean isUnary(){
        return this.left == null;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
