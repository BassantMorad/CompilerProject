package Nodes;

public class Identifier {

	String ID;
	
	public Identifier(String id){
		ID=id;
	}
	public String getValue(){
		return ID;
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
