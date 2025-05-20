package dit.hua.compiler.symbol;

import java.util.Deque;
import java.util.LinkedList;

import dit.hua.compiler.type.DataType;

public class SymbolTable {
    private Deque<Scope> scopes;

    public SymbolTable(){
        scopes = new LinkedList<>();

        openScope();
    }

    public SymbolTableEntry lookup(String sym) {
        Scope s = scopes.getFirst();
        return s.lookupEntry(sym);
    }

    public SymbolTableEntry lookupRec(String sym) {
        for (Scope s : scopes) {
            SymbolTableEntry e = s.lookupEntry(sym);
            if (e != null)
                return e;
        }
        return null;
    }

    public void addEntry(String sym, DataType t){
        Scope s = scopes.getFirst();
        s.addEntry(sym, new SymbolTableEntry(sym, t));
    }

    public void openScope(){
        scopes.addFirst(new Scope());
    }

    public void closeScope() {
        scopes.removeFirst();
    }
    
}
