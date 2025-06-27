package dit.hua.compiler.ast.definitions;

import java.util.ArrayList;
import java.util.List;

import dit.hua.compiler.ast.ASTVisitor;
import dit.hua.compiler.ast.types.Type;

/**
 * Represents forward function declarations.
 * Matches: func_decl ::= header SEMICOLON
 */

public class FunctionDeclaration extends LocalDefinition{

    private String name;
    private List<Parameter> parameters;
    private Type returnType;

    public FunctionDeclaration(String name, List<Parameter> parameters, Type returnType) {
        super();
        this.name = name;
        this.parameters = new ArrayList<>(parameters);
        this.returnType = returnType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public Type getReturnType() {
        return returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
