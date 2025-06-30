package dit.hua.compiler.ast.definitions;

import java.util.ArrayList;
import java.util.List;

import dit.hua.compiler.ast.ASTVisitor;
import dit.hua.compiler.ast.types.Type;

/**
 * Represents variable declarations like var x, y : int;
 * Matches: var_def ::= "var" id ("," id)* ":" type ";"
 var_def ::= VAR IDENTIFIER id_list COLON type SEMICOLON;
*/

public class VariableDeclaration extends LocalDefinition{

    private List<String> names;
    private Type type;

    public VariableDeclaration(List<String> names, Type type) {
        super();
        this.names = new ArrayList<>(names);
        this.type = type;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
