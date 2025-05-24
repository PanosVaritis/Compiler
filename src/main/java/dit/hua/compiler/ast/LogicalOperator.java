package dit.hua.compiler.ast;

public enum LogicalOperator {

    AND ("and"),
    NOT ("not"),
    OR ("or");

    private String type;

    private LogicalOperator (String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return type;
    }
}
