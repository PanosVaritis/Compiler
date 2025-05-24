package dit.hua.compiler.ast;

public class UnaryExpression extends Expression {

    private Operator operator;
    private Expression expression1;


    public UnaryExpression (Operator operator, Expression expression1){
        this.operator = operator;
        this.expression1 = expression1;
    }


    public Operator getOperator() {
        return operator;
    }


    public void setOperator(Operator operator) {
        this.operator = operator;
    }


    public Expression getExpression1() {
        return expression1;
    }


    public void setExpression1(Expression expression1) {
        this.expression1 = expression1;
    }

}
