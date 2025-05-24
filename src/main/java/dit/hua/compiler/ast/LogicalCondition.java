package dit.hua.compiler.ast;

public class LogicalCondition extends Condition {

    private LogicalOperator operator;
    private Condition condition1;
    private Condition condition2;


    public LogicalCondition(LogicalOperator operator, Condition condition1) {
        this.operator = operator;
        this.condition1 = condition1;
    }

    public LogicalCondition(LogicalOperator operator, Condition condition1, Condition condition2) {
        this.operator = operator;
        this.condition1 = condition1;
        this.condition2 = condition2;
    }
    

    public LogicalOperator getOperator() {
        return operator;
    }

    public void setOperator(LogicalOperator operator) {
        this.operator = operator;
    }
    
    public Condition getCondition1() {
        return condition1;
    }

    public void setCondition1(Condition condition1) {
        this.condition1 = condition1;
    }

    public Condition getCondition2() {
        return condition2;
    }

    public void setCondition2(Condition condition2) {
        this.condition2 = condition2;
    }

}
