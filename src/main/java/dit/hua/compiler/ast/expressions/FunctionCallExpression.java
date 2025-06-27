package dit.hua.compiler.ast.expressions;

import java.util.ArrayList;
import java.util.List;

import dit.hua.compiler.ast.ASTVisitor;

/*
 * Class that represents a function call that return values
 * for example could be something like: sum (x, t)
 * Matches the production expr :: = func_call
 */


public class FunctionCallExpression extends Expression{

    private String functionName;
    private List<Expression> arguments;

    public FunctionCallExpression(String functionName, List<Expression> arguments){
        super();
        this.functionName = functionName;
        this.arguments = new ArrayList<>(arguments);
    }

    public FunctionCallExpression (String functionName){
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
