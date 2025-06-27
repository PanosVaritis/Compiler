package dit.hua.compiler.ast.types;

import dit.hua.compiler.ast.ASTVisitor;

//Matches data_type :: = char

public class CharType extends Type{

    @Override
    public boolean equals(Object other) {
        return other instanceof CharType;
    }

    @Override
    public String toString() {
        return "char";
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }

}
