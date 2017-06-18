package Nodes;

public class Statement3 implements Statment {

	Expression expr ;
	Statment stmt ;
    
	public Statement3(Expression expr, Statment stmt) {
		super();
		this.expr = expr;
		this.stmt = stmt;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "while" + "(" +" "+ expr.getValue()+" "+ ")" +"\n\t"+stmt.getValue()+"\n\t";
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
	
}
