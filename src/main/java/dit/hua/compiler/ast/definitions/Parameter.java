package dit.hua.compiler.ast.definitions;

import java.lang.reflect.Type;

import dit.hua.compiler.ast.ASTVisitor;

/**
 * Represents function parameters with type and pass-by mode.
 * Matches: fpar_def ::= ["ref"] id ("," id)* ":" fpar_type
 * fpar_def ::= maybe_ref IDENTIFIER id_list COLON fpar_type;
 * maybe_ref ::= Empty |REF 
 * id_list ::= Empty | id_list COMMA IDENTIFIER
 */

public class Parameter extends LocalDefinition{

    private String name;
    private Type type;
    private boolean isReference;

    public Parameter(String name, Type type, boolean isReference) {
        super();
        this.name = name;
        this.type = type;
        this.isReference = isReference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isReference() {
        return isReference;
    }

    public void setReference(boolean isReference) {
        this.isReference = isReference;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
