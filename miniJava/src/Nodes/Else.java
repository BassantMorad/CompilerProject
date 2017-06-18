package Nodes;

public class Else implements ElseInterface {
 
	Statment stmt ;
	
	
	public Else(Statment stmt) {
		this.stmt = stmt;
	}


	public String getValue()
	{
		return "\n\t" + Terminal.ELSE+ stmt.getValue(); 
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
