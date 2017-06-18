package Nodes;

public class Statement1 implements Statment{

	private StatementSTM stmt ;
	
	public Statement1(StatementSTM stmt) {
		super();
		this.stmt = stmt;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "{" +"\n\t "+ stmt.getValue() +"\n "+"}";
		
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}

}
