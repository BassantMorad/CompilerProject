package Nodes;

public class Public implements Visiblity  {

	public Public() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getValue() {
		return "public";
	}

	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
