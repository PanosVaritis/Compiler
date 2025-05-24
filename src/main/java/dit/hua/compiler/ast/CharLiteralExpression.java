package dit.hua.compiler.ast;

public class CharLiteralExpression extends Expression {

    private char cliteral;

    public CharLiteralExpression (char cliteral){
        this.cliteral = cliteral;
    }

    public char getCliteral() {
        return cliteral;
    }

    public void setCliteral(char cliteral) {
        this.cliteral = cliteral;
    }
}
