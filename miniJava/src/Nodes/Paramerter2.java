package Nodes;

public class Paramerter2 implements Paramerter {
	public Paramerter2(){
		
	}
	public String getValue(){
		return "";
	}
	public void accept(NodeVisitor nodeVisitor) {
			nodeVisitor.visit(this);
	}
}
