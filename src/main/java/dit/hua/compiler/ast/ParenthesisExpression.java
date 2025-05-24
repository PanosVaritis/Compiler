package dit.hua.compiler.ast;

public class ParenthesisExpression extends Expression{
    private Expression expression;

    public ParenthesisExpression(Expression expression){
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
