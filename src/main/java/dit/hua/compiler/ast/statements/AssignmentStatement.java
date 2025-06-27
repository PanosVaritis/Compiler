package dit.hua.compiler.ast.statements;

import java.beans.Expression;

import dit.hua.compiler.ast.ASTVisitor;
import dit.hua.compiler.ast.expressions.LValue;

/**
 * Represents assignment statements like x <- 5, arr[i] <- value.
 * Matches: stmt ::= l_value PLIKE expr SEMICOLON
 */

public class AssignmentStatement extends Statement {

    private LValue target;
    private Expression value;

    public AssignmentStatement (LValue target, Expression value){
        super();
        this.target = target;
        this.value = value;
    }

    public LValue getTarget() {
        return target;
    }

    public void setTarget(LValue target) {
        this.target = target;
    }

    public Expression getValue() {
        return value;
    }

    public void setValue(Expression value) {
        this.value = value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
