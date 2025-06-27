package dit.hua.compiler.ast.types;

//Matches the production data_type :: = int

import dit.hua.compiler.ast.ASTVisitor;

public class IntType extends Type{

    @Override
    public boolean equals(Object other) {
        return other instanceof IntType;
    }

    @Override
    public String toString() {
        return "int";
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
