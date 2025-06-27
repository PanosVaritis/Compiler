package dit.hua.compiler.ast.statements;

import dit.hua.compiler.ast.ASTVisitor;
import dit.hua.compiler.ast.expressions.Condition;

/**
 * Represents while-do loop statements.
 * Matches: stmt ::= "WHILW cond DO stmt
 */


public class WhileStatement extends Statement{

    private Condition condition;
    private Statement body;

    public WhileStatement(Condition condition, Statement body) {
        super();
        this.condition = condition;
        this.body = body;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Statement getBody() {
        return body;
    }

    public void setBody(Statement body) {
        this.body = body;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
