package dit.hua.compiler.ast;

import java.util.ArrayList;
import java.util.List;

import dit.hua.compiler.errors.SemanticException;
import dit.hua.compiler.errors.TypeException;
import dit.hua.compiler.symbol.*;

public class LValue extends Expression {
  private String name;
  private List<Expression> indices;

  public LValue(String name){
    this.name = name;
    this.indices = new ArrayList<>();
  }

  public LValue(LValue base,Expression index){
    this.name = base.name;
    this.indices = new ArrayList<>(base.indices);
    this.indices.add(index);
  }

  public String toString() {
    return "LValue(" + name + indices + ")";
  }
}
