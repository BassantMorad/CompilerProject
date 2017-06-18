package Nodes;

public class ExpressionSTM_2 implements  ExpressionSTM_  {

	@Override
	public String getValue() {
		return "";
	}

	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
