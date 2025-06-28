package dit.hua.compiler.ast;

import dit.hua.compiler.ast.definitions.FunctionDefinition;

/*
 * This is the root node of the AST. From there the tree expands dowards
 * Matches program :: = func_def
 */

public class Program extends ASTNode{

    private FunctionDefinition mainFunction;

    public Program (FunctionDefinition mainFunction){
        super();
        this.mainFunction = mainFunction;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }

    public FunctionDefinition getMainFunction(){
        return mainFunction;
    }
}
