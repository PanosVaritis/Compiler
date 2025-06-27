package dit.hua.compiler.ast.statements;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;

import dit.hua.compiler.ast.ASTVisitor;

/**
 * Represents function calls used as statements (procedures).
 * Matches: stmt ::= func_call SEMICOLON
 */

public class FunctionCallStatement extends Statement{

    private String functionName;
    private List<Expression> arguments;

    public FunctionCallStatement(String functionName, List<Expression> arguments) {
        super();
        this.functionName = functionName;
        this.arguments = new ArrayList<>(arguments);
    }
    
    public FunctionCallStatement(String functionName) {
        this(functionName, new ArrayList<>());
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    public void setArguments(List<Expression> arguments) {
        this.arguments = arguments;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
