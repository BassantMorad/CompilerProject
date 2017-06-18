package Nodes;

public class MethodDeclarationSTM2 implements MethodDeclarationSTM {
	public MethodDeclarationSTM2(){
		
	}
	public String getValue(){
		return "";
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}

}
