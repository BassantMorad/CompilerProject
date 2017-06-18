package Nodes;

public class notElse implements ElseInterface{
	
	public String getValue(){
		return "";
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}

}
