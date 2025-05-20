package dit.hua.compiler.type;

public class BasicType extends DataType{
    
    private enum BasicTypeEnum{INT,CHAR};
    private BasicTypeEnum type;

    private BasicType(BasicTypeEnum e) {
        type = e;
    }

    static public BasicType Int = new BasicType(BasicTypeEnum.INT);
    static public BasicType Char = new BasicType(BasicTypeEnum.CHAR);

    public String toString() { return type.toString(); }


    public boolean equals(DataType t){
        if (t instanceof BasicType){
            BasicType that = (BasicType)t;
            return this.type == that.type;
        }
        return false;
    }

}
