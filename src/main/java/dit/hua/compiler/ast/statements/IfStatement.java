package dit.hua.compiler.ast.statements;


import dit.hua.compiler.ast.ASTVisitor;
import dit.hua.compiler.ast.expressions.Condition;

/**
 * Represents if-then-else statements.
 * Matches: stmt ::= IF cond THEN stmt maybe_stmt
 */


public class IfStatement extends Statement{

    private Condition condition;
    private Statement thenStatement;
    private Statement elseStatement; //could be null

    public IfStatement(Condition condition, Statement thenStatement, Statement elseStatement) {
        super();
        this.condition = condition;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
    }
    
    public IfStatement(Condition condition, Statement thenStatement) {
        this(condition, thenStatement, null);
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Statement getThenStatement() {
        return thenStatement;
    }

    public void setThenStatement(Statement thenStatement) {
        this.thenStatement = thenStatement;
    }

    public Statement getElseStatement() {
        return elseStatement;
    }

    public void setElseStatement(Statement elseStatement) {
        this.elseStatement = elseStatement;
    }

    public boolean hasElse(){
        return elseStatement != null;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
