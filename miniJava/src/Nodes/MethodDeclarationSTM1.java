package Nodes;

public class MethodDeclarationSTM1 implements MethodDeclarationSTM {

	MethodDeclaration method;
	MethodDeclarationSTM methodStm;
	
	public MethodDeclarationSTM1(MethodDeclaration method,MethodDeclarationSTM methodStm){
		this.method=method;
		this.methodStm=methodStm;
	}
	
	public String getValue(){
		return method.getValue()+methodStm.getValue();
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
