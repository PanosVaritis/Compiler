package dit.hua.compiler.ast.expressions;

import dit.hua.compiler.ast.ASTNode;

/**
 * Base class for boolean conditions used in if/while statements.
 * Conditions evaluate to true/false values.
 */

public abstract class Condition extends ASTNode{
    
    public Condition (int line, int column){
        super(line, column);
    }

    public Condition (){
        super();
    }

}
