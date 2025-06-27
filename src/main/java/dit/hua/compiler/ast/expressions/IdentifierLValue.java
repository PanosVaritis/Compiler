package dit.hua.compiler.ast.expressions;

import dit.hua.compiler.ast.ASTVisitor;

/**
 * Represents variable/parameter names like x, myVar.
 * Matches: l_value ::= id
 */

public class IdentifierLValue extends LValue{

    private String name;

    public IdentifierLValue(String name) {
        super();
        this.name = name;
    }
    
    public IdentifierLValue(int line, int column, String name) {
        super(line, column);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);        
    }
}
