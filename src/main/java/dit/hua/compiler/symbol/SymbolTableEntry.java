package dit.hua.compiler.symbol;

import dit.hua.compiler.type.DataType;

public class SymbolTableEntry {
    private String s;
    private DataType t;

    public SymbolTableEntry(String s, DataType t){
        this.s = s;
        this.t = t;
    }

    public DataType getType() { 
        return t; 
    }
    
}
