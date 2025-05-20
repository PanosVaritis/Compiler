package dit.hua.compiler.ast;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

import dit.hua.compiler.errors.SemanticException;
import dit.hua.compiler.symbol.SymbolTable;

public class Program extends AST {
    private List<Statement> stmts;
    private List<Decleration> decls;

    public Program (List<Statement> stmts){
        this(Collections.emptyList(), stmts);
    }

    public Program (List<Decleration> decls,List<Statement> stmts){
        this.decls = decls;
        this.stmts = stmts;
    }

    public String toString() {
      StringBuilder sb = new StringBuilder();
      StringJoiner sj = new StringJoiner(",", "Program(", ")");
      for (Decleration d : decls) sj.add(d.toString());
      for (Statement s : stmts) sj.add(s.toString());
      return sj.toString();
    }

  public void sem(SymbolTable tbl) throws SemanticException {
    for (Decleration d : decls) d.sem(tbl);
    for (Statement s : stmts) s.sem(tbl);
  }

  public void sem() throws SemanticException {
    this.sem(new SymbolTable());
  }
    
}
