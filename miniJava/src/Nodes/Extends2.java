package Nodes;

public class Extends2 implements Extends {
	
	public Extends2(){
		
	}
	public String getValue(){
		return "";
	}

	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
