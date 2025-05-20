package dit.hua.compiler.ast;

import dit.hua.compiler.errors.SemanticException;
import dit.hua.compiler.symbol.SymbolTable;

public abstract class AST {
    
      public void sem(SymbolTable tbl) throws SemanticException { }

}
