package Nodes;

public class Private implements Visiblity {

	public Private() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getValue() {
		return "private";
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}

}
