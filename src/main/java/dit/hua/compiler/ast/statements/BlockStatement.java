package dit.hua.compiler.ast.statements;

import java.util.ArrayList;
import java.util.List;

import dit.hua.compiler.ast.ASTVisitor;

/**
 * Represents compound statements with multiple statements in braces.
 * Matches: block ::= LCURLY stmt_list RCURLY
 */


public class BlockStatement extends Statement{

    private List<Statement> statements;

    public BlockStatement(List<Statement> statements) {
        super();
        this.statements = new ArrayList<>(statements);
    }

    public BlockStatement (){
        this(new ArrayList<>());
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    public void addStatement (Statement stmt){
        statements.add(stmt);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
