package dit.hua.compiler.ast.expressions;

import dit.hua.compiler.ast.ASTVisitor;

/*
 * Class that represents expressions inside parenthesis
 * Matches:
 * expr::= LPAREN expr RPAREN
 */


public class ParenthesisExpression extends Expression{
   
    private Expression expression;

    public ParenthesisExpression(Expression expression){
        super();
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
