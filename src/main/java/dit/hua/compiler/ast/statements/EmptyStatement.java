package dit.hua.compiler.ast.statements;

import dit.hua.compiler.ast.ASTVisitor;

/**
 * Represents empty statements (just semicolon).
 * Matches: stmt ::= SEMICOLON
 */

public class EmptyStatement extends Statement{

    public EmptyStatement (){
        super();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
