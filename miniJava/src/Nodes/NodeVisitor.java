package Nodes;

public interface NodeVisitor {

	public void visit(Array1 array1);
	public void visit(Array2 array2);
	public void visit(Goal goal);
	public void visit(ClassDeclaration classDeclaration);
	public void visit(MainClass mainClass);
	public void visit(BooleanType booleanType);
	public void visit(CharType charType);
	public void visit(FloatType floatType);
	public void visit(IntType intType);
	public void visit(StringType stringType);
	public void visit(Character character);
	public void visit(ClassDeclarationSTM1 classDeclarationSTM1);
	public void visit(ClassDeclarationSTM2 classDeclarationSTM2);
	public void visit(Constructor_1 constructor_1);
	public void visit(Constructor_2 constructor_2);
	public void visit(Else else1);
	public void visit(notElse notElse);
	public void visit(Expression1Fn1 expression1Fn1);
	public void visit(Expression1Fn2 expression1Fn2);
	public void visit(Expression1 expression1);
	public void visit(Expression2 expression2);
	public void visit(Expression3 expression3);
	public void visit(Expression4 expression4);
	public void visit(Expression5 expression5);
	public void visit(Expression6 expression6);
	public void visit(Expression7 expression7);
	public void visit(Expression8 expression8);
	public void visit(ExpressionRec1 expressionRec1);
	public void visit(ExpressionRec2 expressionRec2);
	public void visit(ExpressionRec3 expressionRec3);
	public void visit(ExpressionRec4 expressionRec4);
	public void visit(ExpressionSTM_1 expressionSTM_1);
	public void visit(ExpressionSTM_2 expressionSTM_2);
	public void visit(ExpressionSTM1 expressionSTM1);
	public void visit(ExpressionSTM2 expressionSTM2);
	public void visit(Extends1 extends1);
	public void visit(Extends2 extends2);
	public void visit(FLOAT_LITERAL float_LITERAL);
	public void visit(Identifier identifier);
	public void visit(IdentifierAssign1 identifierAssign1);
	public void visit(IdentifierAssign2 identifierAssign2);
	public void visit(INTEGRAL_LITERAL integral_LITERAL);
	public void visit(MethodDeclaration methodDeclaration);
	public void visit(MethodDeclarationSTM1 methodDeclarationSTM1);
	public void visit(MethodDeclarationSTM2 methodDeclarationSTM2);
	public void visit(Operator1 operator1);
	public void visit(Operator2 operator2);
	public void visit(Operator3 operator3);
	public void visit(Operator4 operator4);
	public void visit(Operator5 operator5);
	public void visit(Operator6 operator6);
	public void visit(Paramerter1 paramerter1);
	public void visit(Paramerter2 paramerter2);
	public void visit(ParamerterSTM1 paramerterSTM1);
	public void visit(ParamerterSTM2 paramerterSTM2);
	public void visit(Private private1);
	public void visit(Public public1);
	public void visit(Statement1 statement1);
	public void visit(Statement2 statement2);
	public void visit(Statement3 statement3);
	public void visit(Statement4 statement4);
	public void visit(Statement5 statement5);
	public void visit(StatementSTM1 statementSTM1);
	public void visit(StatementSTM2 statementSTM2);
	public void visit(STRING_LITERAL string_LITERAL);
	public void visit(Terminal terminal);
	public void visit(VarDeclaration varDeclaration);
	public void visit(VarDeclarationSTM1 varDeclarationSTM1);
	public void visit(VarDeclarationSTM2 varDeclarationSTM2);
	
	

}
