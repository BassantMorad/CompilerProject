package Nodes;

public class ExpressionRec4 implements ExpressionRec{

	public ExpressionRec4() {
		// TODO Auto-generated constructor stub
	}
	
	public String getValue(){
		return "";
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
