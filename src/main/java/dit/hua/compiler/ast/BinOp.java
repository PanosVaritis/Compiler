package dit.hua.compiler.ast;

import dit.hua.compiler.errors.SemanticException;
import dit.hua.compiler.symbol.SymbolTable;
import dit.hua.compiler.type.BasicType;

public class BinOp extends Expression {

  public enum Operator {
    Plus,
    Minus,
    Multiple,
    Div,
    Mod
  };

  private Operator op;
  private Expression l, r;

  public BinOp(Operator o, Expression l, Expression r) {
    this.op = o;
    this.l = l;
    this.r = r;
  }

  public String toString() { return op + "(" + l + "," + r + ")"; }

  public void sem(SymbolTable tbl) throws SemanticException {
    l.typeCheck(tbl, BasicType.Int);
    r.typeCheck(tbl, BasicType.Int);
    type = BasicType.Int;
  }
    
}
