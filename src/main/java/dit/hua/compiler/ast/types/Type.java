package dit.hua.compiler.ast.types;

import dit.hua.compiler.ast.ASTNode;

/* 
 * Base class for all the types in grace language
 * Represents the 4 basic types that are supporters
 * int, char, array, nothing
 */

public abstract class Type extends ASTNode {
    
    public Type(){
        super();
    }

    public abstract boolean equals (Object other);
    public abstract String toString();
}
