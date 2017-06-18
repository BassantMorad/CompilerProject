package Nodes;

public class Array2 implements Array {
	public Array2 (){
		
	}

	public String getValue() {
		return Terminal.LEFT_SQUARE_B +Terminal.RIGHT_SQUARE_B;
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
