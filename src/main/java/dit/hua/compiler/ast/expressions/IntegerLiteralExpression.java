package dit.hua.compiler.ast.expressions;

import dit.hua.compiler.ast.ASTVisitor;

//Class that represents int literal expressions
//Matches the production exp:: = INT_LITERAL 
//For example: num

public class IntegerLiteralExpression extends Expression {

    private int value;

    public IntegerLiteralExpression(int value){
        super();
        this.value = value;
    }

    public IntegerLiteralExpression(int line, int column, int value){
        super(line, column);
        this.value = value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
