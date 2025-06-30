package dit.hua.compiler.ast.types;



/* 
 * Base class for all the types in grace language
 * Represents the 4 basic types that are supporters
 * int, char, array, nothing
 */

public abstract class Type {
    
    public Type(){

    }

    public abstract boolean equals (Object other);
    public abstract String toString();
    public abstract boolean isCompatible(Type other);
}
