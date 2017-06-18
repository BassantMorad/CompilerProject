package Nodes;

public class INTEGRAL_LITERAL {
	String  value;
	
	public INTEGRAL_LITERAL(String string){
		this.value=string;
		}
	public String  getValue(){
		return value;
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
