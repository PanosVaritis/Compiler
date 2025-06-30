package dit.hua.compiler.ast.types;


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
    public boolean isCompatible(Type other) {
        return other instanceof CharType;
    }
}
