package Nodes;

public class Character {
	String  value;
	
	public Character(String  value){
		this.value=value;
		}
	public String  getValue(){
		return value;
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
