package dit.hua.compiler.ast;


import dit.hua.compiler.ast.ASTVisitor;
import dit.hua.compiler.ast.definitions.FunctionDeclaration;
import dit.hua.compiler.ast.definitions.FunctionDefinition;
import dit.hua.compiler.ast.definitions.LocalDefinition;
import dit.hua.compiler.ast.definitions.Parameter;
import dit.hua.compiler.ast.definitions.VariableDeclaration;
import dit.hua.compiler.ast.expressions.ArrayAccessLValue;
import dit.hua.compiler.ast.expressions.BinaryCondition;
import dit.hua.compiler.ast.expressions.BinaryExpression;
import dit.hua.compiler.ast.expressions.CharLiteralExpression;
import dit.hua.compiler.ast.expressions.FunctionCallExpression;
import dit.hua.compiler.ast.expressions.IdentifierLValue;
import dit.hua.compiler.ast.expressions.IntegerLiteralExpression;
import dit.hua.compiler.ast.expressions.LogicalCondition;
import dit.hua.compiler.ast.expressions.ParenthesisCondition;
import dit.hua.compiler.ast.expressions.ParenthesisExpression;
import dit.hua.compiler.ast.expressions.StringLiteralLValue;
import dit.hua.compiler.ast.expressions.UnaryExpression;
import dit.hua.compiler.ast.statements.AssignmentStatement;
import dit.hua.compiler.ast.statements.BlockStatement;
import dit.hua.compiler.ast.statements.EmptyStatement;
import dit.hua.compiler.ast.statements.FunctionCallStatement;
import dit.hua.compiler.ast.statements.IfStatement;
import dit.hua.compiler.ast.statements.ReturnStatement;
import dit.hua.compiler.ast.statements.Statement;
import dit.hua.compiler.ast.statements.WhileStatement;
import dit.hua.compiler.ast.types.ArrayType;
import dit.hua.compiler.ast.types.CharType;
import dit.hua.compiler.ast.types.IntType;
import dit.hua.compiler.ast.types.NothingType;
import dit.hua.compiler.ast.types.Type;

public class ASTPrettyPrinter implements ASTVisitor{

    private int indentLevel = 0;
    private StringBuilder output = new StringBuilder();

    private void print(String text){
        output.append(text);
    }

    private void println(String text){
        output.append(text).append("\n");
    }

    private void printIndent(){
        for (int i = 0;i < indentLevel;i++){
            output.append(" ");
        }
    }

    private void indent(){
        indentLevel++;
    }

    private void dedent(){
        indentLevel--;
    }

    public String getOutput() { 
        return output.toString(); 
    }

    public void reset() { 
        output.setLength(0); 
        indentLevel = 0; 
    }

    private void printType(Type type){
        print(type.toString());
    }

    //===Implementaion of the interface methods

    @Override
    public void visit(Program program) {
        println("Program:");   
        indent();
        program.getMainFunction().accept(this);
        dedent();     
    }

    @Override
    public void visit(FunctionDefinition funcDef) {
        printIndent();
        print("FuntionDef: "+funcDef.getName()+"("); 
        
        for (int i = 0;i < funcDef.getParameters().size();i++){
            if (i > 0) {
                print(", ");
            }
            funcDef.getParameters().get(i).accept(this);
        }
        print(") : ");
        printType(funcDef.getReturnType());
        println("");
        indent();


        // Local definitions
        if (!funcDef.getLocalDefinitions().isEmpty()) {
            printIndent();
            println("LocalDefinitions:");
            indent();
            for (LocalDefinition localDef : funcDef.getLocalDefinitions()) {
                localDef.accept(this);
            }
            dedent();
        }


        // Body
        printIndent();
        println("Body:");
        indent();
        funcDef.getBody().accept(this);
        dedent();
        
        dedent();
 }

    @Override
    public void visit(VariableDeclaration varDecl) {
        printIndent();
        print("VarDecl: ");
        for (int i = 0; i < varDecl.getNames().size(); i++) {
            if (i > 0) print(", ");
            print(varDecl.getNames().get(i));
        }
        print(" : ");
        printType(varDecl.getType());
        println("");
    }

    @Override
    public void visit(FunctionDeclaration funcDecl) {
        printIndent();
        print("FunctionDecl: " + funcDecl.getName() + "(");
        
        for (int i = 0; i < funcDecl.getParameters().size(); i++) {
            if (i > 0) print(", ");
            funcDecl.getParameters().get(i).accept(this);
        }
        print(") : ");
        printType(funcDecl.getReturnType()); 
        println("");
    }

    @Override
    public void visit(Parameter parameter) {
        if (parameter.isReference()) print("ref ");
        print(parameter.getName() + " : ");
        printType(parameter.getType());
    }

    @Override
    public void visit(IntegerLiteralExpression intLit) {
        print(String.valueOf(intLit.getValue()));
    }

    @Override
    public void visit(CharLiteralExpression charLit) {
        print(charLit.getValue());
    }

    @Override
    public void visit(BinaryExpression binExpr) {
        print("(");
        binExpr.getLeft().accept(this);
        print(" " + binExpr.getOperator().toString().toLowerCase() + " ");
        binExpr.getRight().accept(this);
        print(")");
    }

    @Override
    public void visit(UnaryExpression unaryExpr) {
        print("(" + unaryExpr.getOperator().toString().toLowerCase());
        unaryExpr.getOperand().accept(this);
        print(")");
    }

    @Override
    public void visit(FunctionCallExpression funcCall) {
        print(funcCall.getFunctionName() + "(");
            for (int i = 0; i < funcCall.getArguments().size(); i++) {
                if (i > 0) print(", ");
                funcCall.getArguments().get(i).accept(this);
            }
        print(")");
    }

    @Override
    public void visit(ParenthesisExpression parenExpr) {
        print("(");
        parenExpr.getExpression().accept(this);
        print(")");
    }

    @Override
    public void visit(IdentifierLValue idLValue) {
        print(idLValue.getName());
    }

    @Override
    public void visit(StringLiteralLValue strLValue) {
        print(strLValue.getValue());
    }

    @Override
    public void visit(ArrayAccessLValue arrayAccess) {
        arrayAccess.getArray().accept(this);
        print("[");
        arrayAccess.getIndex().accept(this);
        print("]");
    }

    @Override
    public void visit(AssignmentStatement assignment) {
        printIndent();
        assignment.getTarget().accept(this);
        print(" <- ");
        assignment.getValue().accept(this);
        // assignment.getValue().accept((ASTVisitor) this); 
        println(";");
    }

    @Override
    public void visit(BlockStatement block) {
        printIndent();
        println("{");
        indent();
        for (Statement stmt : block.getStatements()) {
            stmt.accept(this);
        }
        dedent();
        printIndent();
        println("}");        
    }

    @Override
    public void visit(IfStatement ifStmt) {
        printIndent();
        print("if ");
        // ifStmt.getCondition().accept(this);
        ifStmt.getCondition().accept((ASTVisitor) this);
        println(" then");
        indent();
        ifStmt.getThenStatement().accept(this);
        dedent();
        
        if (ifStmt.hasElse()) {
            printIndent();
            println("else");
            indent();
            ifStmt.getElseStatement().accept(this);
            dedent();
        }
    }

    @Override
    public void visit(WhileStatement whileStmt) {
        printIndent();
        print("while ");
        whileStmt.getCondition().accept(this);
        println(" do");
        indent();
        whileStmt.getBody().accept(this);
        dedent();
    }

    @Override
    public void visit(ReturnStatement returnStmt) {
        printIndent();
        print("return");
        if (returnStmt.hasExpression()) {
            print(" ");
            returnStmt.getExpression().accept(this);
        }
        println(";");
    }

    @Override
    public void visit(FunctionCallStatement funcCallStmt) {
        printIndent();
        print(funcCallStmt.getFunctionName() + "(");
        for (int i = 0; i < funcCallStmt.getArguments().size(); i++) {
            if (i > 0) print(", ");
            funcCallStmt.getArguments().get(i).accept(this);
        }
        println(");"); 
    }

    @Override
    public void visit(EmptyStatement emptyStmt) {
        printIndent();
        println(";");
    }

    @Override
    public void visit(BinaryCondition binCond) {
        print("(");
        binCond.getLeft().accept(this);
        print(" " + binCond.getOperator().toString().toLowerCase() + " ");
        binCond.getRight().accept(this);
        print(")");
    }

    @Override
    public void visit(LogicalCondition logCond) {
        if (logCond.isUnary()) {
            print("(not ");
            logCond.getRight().accept(this);
            print(")");
        } else {
            print("(");
            logCond.getLeft().accept(this);
            print(" " + logCond.getOperator().toString().toLowerCase() + " ");
            logCond.getRight().accept(this);
            print(")");
        }
    }

    @Override
    public void visit(ParenthesisCondition parenCond) {
        print("(");
        parenCond.getCondition().accept(this);
        print(")");
    }
}
