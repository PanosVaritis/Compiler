package dit.hua.compiler.ast.statements;



import dit.hua.compiler.ast.ASTVisitor;
import dit.hua.compiler.ast.expressions.Expression;

/**
 * Represents return statements with optional expression.
 * Matches: stmt ::= RETURN maybe_expr SEMICOLON
 */

public class ReturnStatement extends Statement {

    private Expression expression;// could be null

    public ReturnStatement(Expression expression) {
        super();
        this.expression = expression;
    }
    
    public ReturnStatement() {
        this(null);
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public boolean hasExpression (){
        return expression != null;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
