package dit.hua.compiler.ast;

/*
 * Base class for all AST nodes in the grace language
 * They provide the common!!
 */

public abstract class ASTNode {

    protected int line;
    protected int column;

    public ASTNode (int line, int column){
        this.line = line;
        this.column = column;
    }

    public ASTNode(){
        this(0,0);
    }

    public abstract void accept (ASTVisitor visitor);

    public int getLine(){
        return line;
    }

    public int getColumn(){
        return column;
    }
}
