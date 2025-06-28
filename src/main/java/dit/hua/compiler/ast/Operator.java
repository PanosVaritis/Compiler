package dit.hua.compiler.ast;

/*
 * Enumeration of all binary and unary operations
 * Matcher the operators defined in the grammar
 */


public enum Operator {

    PLUS ("+"),
    MINUS ("-"),
    MULTIPLY ("*"),
    MOD ("mod"),
    NEQUAL ("#"),
    EQUALS ("="),
    LT ("<"),
    GT (">"),
    LE ("<="),
    GE (">=");

    private String type;

    private Operator(String type){
        this.type = type;
    }


    public String getType (){
        return type;
    }

    @Override
    public String toString(){
        return type;
    }

}
