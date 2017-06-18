package Nodes;

public class VarDeclarationSTM1 implements VarDeclarationSTM{
	VarDeclaration varDec;
	VarDeclarationSTM varStmt;

	public VarDeclarationSTM1(VarDeclaration varDec,VarDeclarationSTM varStmt) {
		this.varDec=varDec;
		this.varStmt=varStmt;
				
	}

	public String getValue() {
		return varDec.getValue()+varStmt.getValue();

	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
