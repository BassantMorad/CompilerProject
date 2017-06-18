package Nodes;

public class VarDeclarationSTM2 implements VarDeclarationSTM {

	public VarDeclarationSTM2() {

	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "";
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}

}
