package Nodes;

public class Statement4 implements Statment{

	Expression expr ;
    
	public Statement4(Expression expr) {
		this.expr = expr;
		
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "System.out.println" + "("+" " + expr.getValue() +" "+ ")" + ";"+"\n\t";
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
 
}
