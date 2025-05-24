package dit.hua.compiler.ast;

public class ParenthesisCondition extends Condition{

    private Condition condition;

    public ParenthesisCondition (Condition condition){
        this.condition = condition;
    }


    public Condition geCondition(){
        return condition;
    }

    public void setCondition(Condition condition){
        this.condition = condition;
    }
}
