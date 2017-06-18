package Nodes;

public class ExpressionSTM2 implements ExpressionSTM {

	@Override
	public String getValue() {
		return "";
	}

	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
