package Nodes;

public class MethodDeclaration {

	// <Visiblity> <Type> <Identifier> "(" <ParamerterSTM> ")" "{"
	// <VarDeclarationSTM> <StatementSTM> "return" <Expression> ";" "}"
	Visiblity vis;
	Type type;
	Identifier id;
	ParamerterSTM prm;
	VarDeclarationSTM varStm;
	StatementSTM stmt;
	Expression Exp;

	public MethodDeclaration(Visiblity vis, Type type, Identifier id, ParamerterSTM prm, VarDeclarationSTM varStm,
			StatementSTM stmt, Expression Exp) {

		this.vis = vis;
		this.type = type;
		this.id = id;
		this.prm = prm;
		this.varStm = varStm;
		this.stmt = stmt;
		this.Exp = Exp;
	}
	
	public String getValue(){
		return vis.getValue()+" "+type.getValue()+" "+id.getValue()+" "+
				Terminal.LEFT_ROUND_B+prm.getValue()+Terminal.RIGHT_ROUND_B+
				Terminal.LEFT_CURLY_B+"\n\t"+varStm.getValue()+stmt.getValue()+"\n\t"+
				Terminal.RETURN+" "+Exp.getValue()+Terminal.SEMICOLON+"\n  "+
				Terminal.RIGHT_CURLY_B;
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
