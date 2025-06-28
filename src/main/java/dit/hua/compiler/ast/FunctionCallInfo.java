package dit.hua.compiler.ast;

import java.util.List;

import dit.hua.compiler.ast.expressions.Expression;

public class FunctionCallInfo {

    public String name;
    public List<Expression> arguments;
    
    public FunctionCallInfo(String name, List<Expression> arguments) {
        this.name = name;
        this.arguments = arguments;
    }

}
