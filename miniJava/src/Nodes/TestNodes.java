package Nodes;

public class TestNodes {

	public static void main(String[] args) {
		//a=5+3;b=10*2;print(a);print(b)
		
		INTEGRAL_LITERAL I1=new INTEGRAL_LITERAL(Integer.toString(5));
		INTEGRAL_LITERAL I2=new INTEGRAL_LITERAL(Integer.toString(3));
		Operator op =new Operator3(); //+
		Expression ex2=new Expression3(new ExpressionRec4(),I2); 
		ExpressionRec Ex=new ExpressionRec1(op,ex2, new ExpressionRec4());
		Expression ex3=new Expression3(Ex,I1); 
		
		System.out.println(ex3.getValue());
		Identifier idName=new Identifier("a");
		IdentifierAssign id=new IdentifierAssign1(ex3);
		Statment stmt=new Statement5(idName, id);
		
		System.out.println(stmt.getValue());
		
		
		
		
	}

}
