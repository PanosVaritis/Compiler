package dit.hua.compiler.ast;

import dit.hua.compiler.errors.SemanticException;
import dit.hua.compiler.errors.TypeException;
import dit.hua.compiler.symbol.SymbolTable;
import dit.hua.compiler.type.DataType;

public class Expression extends AST {
  protected DataType type;

  public void typeCheck(SymbolTable tbl, DataType t) throws SemanticException {
    sem(tbl);
    if (!getType().equals(t)) {
      throw new TypeException("Type mismatch: " +
                              "Got: " + getType() + ", " +
                              "Expected: " + t);
    }
  }

  public DataType getType() { return type; }
}
