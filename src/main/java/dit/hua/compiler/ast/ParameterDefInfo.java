package dit.hua.compiler.ast;

import java.util.List;

import dit.hua.compiler.ast.types.Type;

public class ParameterDefInfo {
    
    public boolean isRef;
    public List<String> names;
    public Type type;
        
    public ParameterDefInfo(boolean isRef, List<String> names, Type type) {
        this.isRef = isRef;
        this.names = names;
        this.type = type;
    }
}
