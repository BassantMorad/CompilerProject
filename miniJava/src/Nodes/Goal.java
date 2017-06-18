package Nodes;

public class Goal {
	// <Goal> -> <MainClass> <ClassDeclarationSTM> <EOF>

	MainClass mainClass ;
	ClassDeclarationSTM classStmt;
	

	public Goal(MainClass mainClass,ClassDeclarationSTM classStmt) {
		this.mainClass=mainClass;
		this.classStmt = classStmt;
	}

	public String getValue() {
		return mainClass.getValue()+classStmt.getValue();

	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
