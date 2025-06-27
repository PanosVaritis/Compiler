package dit.hua.compiler.ast.expressions;

import dit.hua.compiler.ast.ASTVisitor;

/**
 * Represents parenthesized conditions like (a and b).
 * Matches: cond ::= LPAREN cond RPAREN
 */

public class ParenthesisCondition extends Condition{

    private Condition condition;

    public ParenthesisCondition (Condition condition){
        super();
        this.condition = condition;
    }

    public Condition geCondition(){
        return condition;
    }

    public void setCondition(Condition condition){
        this.condition = condition;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
