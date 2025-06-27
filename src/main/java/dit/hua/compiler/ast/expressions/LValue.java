package dit.hua.compiler.ast.expressions;

/* Basic class for the left values */

public abstract class LValue extends Expression {

    public LValue (int line, int column){
        super(line, column);
    }

    public LValue(){
        super();
    }
}
