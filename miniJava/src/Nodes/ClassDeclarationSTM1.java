package Nodes;

public class ClassDeclarationSTM1 implements ClassDeclarationSTM {
	// <ClassDeclarationSTM> -> <ClassDeclaration> <ClassDeclarationSTM> | $

	ClassDeclaration classDec;
	ClassDeclarationSTM classDecStmt;


	public ClassDeclarationSTM1(	ClassDeclaration classDec,ClassDeclarationSTM classDecStmt) {
		this.classDec = classDec;
		this.classDecStmt= classDecStmt;
	}

	public String getValue() {
		return classDec.getValue() + classDecStmt.getValue();
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}