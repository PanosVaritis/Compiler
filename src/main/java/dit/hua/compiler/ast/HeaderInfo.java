package dit.hua.compiler.ast;

import java.util.List;

import dit.hua.compiler.ast.definitions.Parameter;
import dit.hua.compiler.ast.types.Type;

public class HeaderInfo {

    public String name;
    public List<Parameter> parameters;
    public Type returnType;
    
    public HeaderInfo(String name, List<Parameter> parameters, Type returnType) {
        this.name = name;
        this.parameters = parameters;
        this.returnType = returnType;
    }

}
