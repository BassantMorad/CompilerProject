package Nodes;

public class FLOAT_LITERAL {
	String  value;
	
	public FLOAT_LITERAL(String value){
		this.value=value;
		}
	public String getValue(){
		return value;
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
