package dit.hua.compiler.ast;

public class BinaryCondition extends Condition{

    private Operator operator;
    private Expression expression1;
    private Expression expression2;


    public BinaryCondition(Operator operator, Expression expression1, Expression expression2) {
        this.operator = operator;
        this.expression1 = expression1;
        this.expression2 = expression2;
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


    public Expression getExpression2() {
        return expression2;
    }


    public void setExpression2(Expression expression2) {
        this.expression2 = expression2;
    }

}
