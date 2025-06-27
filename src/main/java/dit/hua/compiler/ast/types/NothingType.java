package dit.hua.compiler.ast.types;

import dit.hua.compiler.ast.ASTVisitor;

//Class that represents the nothing type (when returned by a procedure)
//Matches ret_type ::= nothing

public class NothingType extends Type{

    @Override
    public boolean equals(Object other) {
        return other instanceof NothingType;
    }

    @Override
    public String toString() {
        return "nothing";
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
