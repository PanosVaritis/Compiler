package dit.hua.compiler.ast;


import dit.hua.compiler.ast.expressions.*;
import dit.hua.compiler.ast.statements.*;
import dit.hua.compiler.ast.definitions.*;

/*
 * Visitor interface for traversing the ast
 */

public interface ASTVisitor {

    void visit(Program program);
    void visit(FunctionDefinition funcDef);
    void visit(VariableDeclaration varDecl);
    void visit(FunctionDeclaration funcDecl);
    void visit(Parameter parameter);

    
    void visit(IntegerLiteralExpression intLit);
    void visit(CharLiteralExpression charLit);
    void visit(BinaryExpression binExpr);
    void visit(UnaryExpression unaryExpr);
    void visit(FunctionCallExpression funcCall);
    void visit(ParenthesisExpression parenExpr);


    void visit(IdentifierLValue idLValue);
    void visit(StringLiteralLValue strLValue);
    void visit(ArrayAccessLValue arrayAccess);

    
    void visit(AssignmentStatement assignment);
    void visit(BlockStatement block);
    void visit(IfStatement ifStmt);
    void visit(WhileStatement whileStmt);
    void visit(ReturnStatement returnStmt);
    void visit(FunctionCallStatement funcCallStmt);
    void visit(EmptyStatement emptyStmt);
    

    void visit(BinaryCondition binCond);
    void visit(LogicalCondition logCond);
    void visit(ParenthesisCondition parenCond);
}
