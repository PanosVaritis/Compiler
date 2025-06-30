package dit.hua.compiler.ast.types;

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
    public boolean isCompatible(Type other) {
        return other instanceof NothingType;
    }
}
