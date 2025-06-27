package dit.hua.compiler.ast.expressions;

import dit.hua.compiler.ast.ASTVisitor;
import dit.hua.compiler.ast.Operator;

/*
 * Class that represents any unary expression 
 * For example -,+ var
 * Matches the production: expr:: PLUS/MINUS expr
 */

public class UnaryExpression extends Expression {

    private Operator operator;
    private Expression operand;

    public UnaryExpression (Operator operator, Expression operand){
        super();
        this.operand = operand;
        this.operator = operator;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Expression getOperand() {
        return operand;
    }

    public void setOperand(Expression operand) {
        this.operand = operand;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
