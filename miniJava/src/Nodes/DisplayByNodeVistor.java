package Nodes;

public class DisplayByNodeVistor implements NodeVisitor{

	@Override
	public void visit(Array1 array1) {
		// TODO Auto-generated method stub
		System.out.println(array1.getValue());
	}

	@Override
	public void visit(Array2 array2) {
		// TODO Auto-generated method stub
		System.out.println(array2.getValue());
	}

	@Override
	public void visit(Goal goal) {
		// TODO Auto-generated method stub
		
		System.out.println(goal.getValue());
		
	}

	@Override
	public void visit(ClassDeclaration classDeclaration) {
		// TODO Auto-generated method stub
		System.out.println(classDeclaration.getValue());
		System.out.print("\n");
	}

	@Override
	public void visit(MainClass mainClass) {
		// TODO Auto-generated method stub
		System.out.println(mainClass.getValue());
		System.out.print("\n");
	}

	@Override
	public void visit(BooleanType booleanType) {
		// TODO Auto-generated method stub
		System.out.println(booleanType.getValue());
	}

	@Override
	public void visit(CharType charType) {
		// TODO Auto-generated method stub
		System.out.println(charType.getValue());
	}

	@Override
	public void visit(FloatType floatType) {
		// TODO Auto-generated method stub
		System.out.println(floatType.getValue());
	}

	@Override
	public void visit(IntType intType) {
		// TODO Auto-generated method stub
		System.out.println(intType.getValue());
	}

	@Override
	public void visit(StringType stringType) {
		// TODO Auto-generated method stub
		System.out.println(stringType.getValue());
	}

	@Override
	public void visit(Character character) {
		// TODO Auto-generated method stub
		System.out.println(character.getValue());
	}

	@Override
	public void visit(ClassDeclarationSTM1 classDeclarationSTM1) {
		// TODO Auto-generated method stub
		System.out.println(classDeclarationSTM1.getValue());
	}

	@Override
	public void visit(ClassDeclarationSTM2 classDeclarationSTM2) {
		// TODO Auto-generated method stub
		System.out.println(classDeclarationSTM2.getValue());
	}

	@Override
	public void visit(Constructor_1 constructor_1) {
		// TODO Auto-generated method stub
		System.out.println(constructor_1.getValue());
	}

	@Override
	public void visit(Constructor_2 constructor_2) {
		// TODO Auto-generated method stub
		System.out.println(constructor_2.getValue());
	}

	@Override
	public void visit(Else else1) {
		// TODO Auto-generated method stub
		System.out.println(else1.getValue());
	}

	@Override
	public void visit(notElse notElse) {
		// TODO Auto-generated method stub
		System.out.println(notElse.getValue());
	}

	@Override
	public void visit(Expression1Fn1 expression1Fn1) {
		// TODO Auto-generated method stub
		System.out.println(expression1Fn1.getValue());
	}

	@Override
	public void visit(Expression1Fn2 expression1Fn2) {
		// TODO Auto-generated method stub
		System.out.println(expression1Fn2.getValue());
	}

	@Override
	public void visit(Expression1 expression1) {
		// TODO Auto-generated method stub
		System.out.println(expression1.getValue());
	}

	@Override
	public void visit(Expression2 expression2) {
		// TODO Auto-generated method stub
		System.out.println(expression2.getValue());
	}

	@Override
	public void visit(Expression3 expression3) {
		// TODO Auto-generated method stub
		System.out.println(expression3.getValue());
	}

	@Override
	public void visit(Expression4 expression4) {
		// TODO Auto-generated method stub
		System.out.println(expression4.getValue());
	}

	@Override
	public void visit(Expression5 expression5) {
		// TODO Auto-generated method stub
		System.out.println(expression5.getValue());
	}

	@Override
	public void visit(Expression6 expression6) {
		// TODO Auto-generated method stub
		System.out.println(expression6.getValue());
	}

	@Override
	public void visit(Expression7 expression7) {
		// TODO Auto-generated method stub
		System.out.println(expression7.getValue());
	}

	@Override
	public void visit(Expression8 expression8) {
		// TODO Auto-generated method stub
		System.out.println(expression8.getValue());
	}

	@Override
	public void visit(ExpressionRec1 expressionRec1) {
		// TODO Auto-generated method stub
		System.out.println(expressionRec1.getValue());
	}

	@Override
	public void visit(ExpressionRec2 expressionRec2) {
		// TODO Auto-generated method stub
		System.out.println(expressionRec2.getValue());
	}

	@Override
	public void visit(ExpressionRec3 expressionRec3) {
		// TODO Auto-generated method stub
		System.out.println(expressionRec3.getValue());
	}

	@Override
	public void visit(ExpressionRec4 expressionRec4) {
		// TODO Auto-generated method stub
		System.out.println(expressionRec4.getValue());
	}

	@Override
	public void visit(ExpressionSTM_1 expressionSTM_1) {
		// TODO Auto-generated method stub
		System.out.println(expressionSTM_1.getValue());
	}

	@Override
	public void visit(ExpressionSTM_2 expressionSTM_2) {
		// TODO Auto-generated method stub
		System.out.println(expressionSTM_2.getValue());
	}

	@Override
	public void visit(ExpressionSTM1 expressionSTM1) {
		// TODO Auto-generated method stub
		System.out.println(expressionSTM1.getValue());
	}

	@Override
	public void visit(ExpressionSTM2 expressionSTM2) {
		// TODO Auto-generated method stub
		System.out.println(expressionSTM2.getValue());
	}

	@Override
	public void visit(Extends1 extends1) {
		// TODO Auto-generated method stub
		System.out.println(extends1.getValue());
	}

	@Override
	public void visit(Extends2 extends2) {
		// TODO Auto-generated method stub
		System.out.println(extends2.getValue());
	}

	@Override
	public void visit(FLOAT_LITERAL float_LITERAL) {
		// TODO Auto-generated method stub
		System.out.println(float_LITERAL.getValue());
	}

	@Override
	public void visit(Identifier identifier) {
		// TODO Auto-generated method stub
		System.out.println(identifier.getValue());
	}

	@Override
	public void visit(IdentifierAssign1 identifierAssign1) {
		// TODO Auto-generated method stub
		System.out.println(identifierAssign1.getValue());
	}

	@Override
	public void visit(IdentifierAssign2 identifierAssign2) {
		// TODO Auto-generated method stub
		System.out.println(identifierAssign2.getValue());
	}

	@Override
	public void visit(INTEGRAL_LITERAL integral_LITERAL) {
		// TODO Auto-generated method stub
		System.out.println(integral_LITERAL.getValue());
	}

	@Override
	public void visit(MethodDeclaration methodDeclaration) {
		// TODO Auto-generated method stub
		System.out.println(methodDeclaration.getValue());
	}

	@Override
	public void visit(MethodDeclarationSTM1 methodDeclarationSTM1) {
		// TODO Auto-generated method stub
		System.out.println(methodDeclarationSTM1.getValue());
	}

	@Override
	public void visit(MethodDeclarationSTM2 methodDeclarationSTM2) {
		// TODO Auto-generated method stub
		System.out.println(methodDeclarationSTM2.getValue());
	}

	@Override
	public void visit(Operator1 operator1) {
		// TODO Auto-generated method stub
		System.out.println(operator1.getValue());
	}

	@Override
	public void visit(Operator2 operator2) {
		// TODO Auto-generated method stub
		System.out.println(operator2.getValue());
	}

	@Override
	public void visit(Operator3 operator3) {
		// TODO Auto-generated method stub
		System.out.println(operator3.getValue());
	}

	@Override
	public void visit(Operator4 operator4) {
		// TODO Auto-generated method stub
		System.out.println(operator4.getValue());
	}

	@Override
	public void visit(Operator5 operator5) {
		// TODO Auto-generated method stub
		System.out.println(operator5.getValue());
	}

	@Override
	public void visit(Operator6 operator6) {
		// TODO Auto-generated method stub
		System.out.println(operator6.getValue());
	}

	@Override
	public void visit(Paramerter1 paramerter1) {
		// TODO Auto-generated method stub
		System.out.println(paramerter1.getValue());
	}

	@Override
	public void visit(Paramerter2 paramerter2) {
		// TODO Auto-generated method stub
		System.out.println(paramerter2.getValue());
	}

	@Override
	public void visit(ParamerterSTM1 paramerterSTM1) {
		// TODO Auto-generated method stub
		System.out.println(paramerterSTM1.getValue());
	}

	@Override
	public void visit(ParamerterSTM2 paramerterSTM2) {
		// TODO Auto-generated method stub
		System.out.println(paramerterSTM2.getValue());
	}

	@Override
	public void visit(Private private1) {
		// TODO Auto-generated method stub
		System.out.println(private1.getValue());
	}

	@Override
	public void visit(Public public1) {
		// TODO Auto-generated method stub
		System.out.println(public1.getValue());	
	}

	@Override
	public void visit(Statement1 statement1) {
		// TODO Auto-generated method stub
		System.out.println(statement1.getValue());
	}

	@Override
	public void visit(Statement2 statement2) {
		// TODO Auto-generated method stub
		System.out.println(statement2.getValue());
	}

	@Override
	public void visit(Statement3 statement3) {
		// TODO Auto-generated method stub
		System.out.println(statement3.getValue());
	}

	@Override
	public void visit(Statement4 statement4) {
		// TODO Auto-generated method stub
		System.out.println(statement4.getValue());
	}

	@Override
	public void visit(Statement5 statement5) {
		// TODO Auto-generated method stub
		System.out.println(statement5.getValue());
	}

	@Override
	public void visit(StatementSTM1 statementSTM1) {
		// TODO Auto-generated method stub
		System.out.println(statementSTM1.getValue());
	}

	@Override
	public void visit(StatementSTM2 statementSTM2) {
		// TODO Auto-generated method stub
		System.out.println(statementSTM2.getValue());
	}

	@Override
	public void visit(STRING_LITERAL string_LITERAL) {
		// TODO Auto-generated method stub
		System.out.println(string_LITERAL.getValue());
	}

	@Override
	public void visit(Terminal terminal) {
		// TODO Auto-generated method stub
		//System.out.println(terminal); /////////////////////////////////msh 3arfa a print feha a  
	}

	@Override
	public void visit(VarDeclaration varDeclaration) {
		// TODO Auto-generated method stub
		System.out.println(varDeclaration.getValue());
	}

	@Override
	public void visit(VarDeclarationSTM1 varDeclarationSTM1) {
		// TODO Auto-generated method stub
		System.out.println(varDeclarationSTM1.getValue());
	}

	@Override
	public void visit(VarDeclarationSTM2 varDeclarationSTM2) {
		// TODO Auto-generated method stub
		System.out.println(varDeclarationSTM2.getValue());
	}

}
