package Nodes;

public class Array1 implements Array{
	
	public Array1 (){
		
	}
	
	public String getValue()
	{
		return "";
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
