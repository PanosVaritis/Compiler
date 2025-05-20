package dit.hua.compiler.symbol;

import java.util.HashMap;
import java.util.Map;

public class Scope {

    public Scope() {
        locals = new HashMap<String,SymbolTableEntry>();
    }

    public SymbolTableEntry lookupEntry(String sym) {
        return locals.get(sym);
    }

    public void addEntry(String sym, SymbolTableEntry entry) {
        locals.put(sym, entry);
    }

    private Map<String, SymbolTableEntry> locals;
    
}
