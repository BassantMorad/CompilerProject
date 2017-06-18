package Nodes;

public class STRING_LITERAL {

	String  value;
	
	public STRING_LITERAL(String  value){
		this.value=value;
		}
	public String  getValue(){
		return value;
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
