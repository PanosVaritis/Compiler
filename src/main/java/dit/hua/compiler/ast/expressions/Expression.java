package dit.hua.compiler.ast.expressions;

import java.lang.reflect.Type;

import dit.hua.compiler.ast.ASTNode;

/* 
 * Base class for all the expressions
 * An expression can have a type (must) and produces r-values
 */

public abstract class Expression extends ASTNode{

    protected Type type;

    public Expression (int line, int column){
        super(line, column);
    }

    public Expression(){
        super();
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
