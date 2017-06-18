package Nodes;

public class Extends1 implements Extends{
	Identifier id ;
	public Extends1(Identifier id){
		this.id=id;
	}
	public String getValue(){
		return Terminal.EXTENDS+" "+ id.getValue();
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}

}
