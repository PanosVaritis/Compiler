package dit.hua.compiler.ast.statements;

import dit.hua.compiler.ast.ASTNode;

/**
 * Base class for all statements in Grace.
 * Statements perform actions but don't return values.
 */

public abstract class Statement extends ASTNode{

    public Statement(int line, int column) {
        super(line, column);
    }
    
    public Statement() {
        super();
    }

}
