package dit.hua.compiler.ast.definitions;

import java.util.ArrayList;
import java.util.List;

import dit.hua.compiler.ast.ASTVisitor;
import dit.hua.compiler.ast.statements.BlockStatement;
import dit.hua.compiler.ast.types.Type;

/**
 * Represents complete function definitions with body.
 * Matches: func_def ::= header (local_def)* block
 */

public class FunctionDefinition extends LocalDefinition{

    private String name;
    private List<Parameter> parameters;
    private Type returnType;
    private List<LocalDefinition> localDefinitions;
    private BlockStatement body;


    public FunctionDefinition(String name, List<Parameter> parameters, Type returnType,List<LocalDefinition> localDefinitions, BlockStatement body) {
        super();
        this.name = name;
        this.parameters = new ArrayList<>(parameters);
        this.returnType = returnType;
        this.localDefinitions = new ArrayList<>(localDefinitions);
        this.body = body;
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

    public List<LocalDefinition> getLocalDefinitions() {
        return localDefinitions;
    }

    public void setLocalDefinitions(List<LocalDefinition> localDefinitions) {
        this.localDefinitions = localDefinitions;
    }

    public BlockStatement getBody() {
        return body;
    }

    public void setBody(BlockStatement body) {
        this.body = body;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
