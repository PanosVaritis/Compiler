package dit.hua.compiler.ast.expressions;

import dit.hua.compiler.ast.ASTVisitor;

/* Basic class for the left values */

public abstract class LValue extends Expression {

    public LValue (int line, int column){
        super(line, column);
    }

    public LValue(){
        super();
    }

    @Override
    public abstract void accept(ASTVisitor visitor);
}
