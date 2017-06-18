package Nodes;

public class ClassDeclarationSTM2 implements ClassDeclarationSTM {



	public ClassDeclarationSTM2() {
	}

	public String getValue() {
		return "";
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
