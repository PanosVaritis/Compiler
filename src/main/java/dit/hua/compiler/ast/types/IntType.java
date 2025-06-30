package dit.hua.compiler.ast.types;

//Matches the production data_type :: = int


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
    public boolean isCompatible(Type other) {
        return other instanceof IntType;
    }
}
