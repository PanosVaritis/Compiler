package dit.hua.compiler.ast;

import dit.hua.compiler.symbol.SymbolTable;
import dit.hua.compiler.type.DataType;

public class Decleration {
   
    private String id;
    private DataType type;

    public Decleration(String id, DataType t) {
        this.id = id;
        this.type = t;
    }

    public String toString() { return "Decl(" + id + ":" + type + ")"; }

    public void sem(SymbolTable tbl) {
      tbl.addEntry(id, type);
    }


}