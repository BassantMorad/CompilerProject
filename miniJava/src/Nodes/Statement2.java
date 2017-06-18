package Nodes;

public class Statement2 implements Statment{
    Expression expr ;
    Statment stmt ;
    ElseInterface else1 ;
    
	public Statement2(Expression expr, Statment stmt, ElseInterface else1) {
		super();
		this.expr = expr;
		this.stmt = stmt;
		this.else1 = else1;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return " if" +" "+ "(" +" "+ expr.getValue()+" "+ ")"+"\n\t"+
				stmt.getValue() +"\t"+ else1.getValue()+"\t";
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
