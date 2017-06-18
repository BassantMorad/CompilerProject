package Nodes;

public class MainClass {
	// <MainClass> -> "class" <Identifier> "{" "public" "static" "void" "main"
	// "(" "String" "[" "]" <Identifier> ")" "{" <Statement> "}" "}"

	Identifier id1;
	Identifier id2;
	Statment stmt;

	public MainClass(Identifier id1,Identifier id2,Statment stmt) {
		this.id1=id1;
		this.id2=id2;
		this.stmt=stmt;
	}

	public String getValue() {
		return Terminal.CLASS+" "+id1.getValue()+Terminal.LEFT_CURLY_B+"\n  "+Terminal.PUBLIC+
				" "+Terminal.STATIC+" "+Terminal.VOID+" "+Terminal.MAIN+
				Terminal.LEFT_ROUND_B+Terminal.STRING+Terminal.LEFT_SQUARE_B+Terminal.RIGHT_SQUARE_B+
				" "+id2.getValue()+ Terminal.RIGHT_ROUND_B+Terminal.LEFT_CURLY_B+"\n\t"+stmt.getValue()+
				"\n"+Terminal.RIGHT_CURLY_B+"\n"+Terminal.RIGHT_CURLY_B+"\n";

	}
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}