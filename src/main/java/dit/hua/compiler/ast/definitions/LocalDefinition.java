package dit.hua.compiler.ast.definitions;

import dit.hua.compiler.ast.ASTNode;

/**
 * Base class for local definitions (variables, functions, declarations).
 * Matches: local_def ::= func_def | func_decl | var_def
 */

public abstract class LocalDefinition extends ASTNode{

    public LocalDefinition(int line, int column){
        super(line, column);
    }

    public LocalDefinition(){
        super();
    }
}
