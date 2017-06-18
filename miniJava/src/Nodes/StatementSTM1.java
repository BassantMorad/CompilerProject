package Nodes;

public class StatementSTM1 implements StatementSTM {

	Statment stmt ;
	StatementSTM stmtSTM ;
	
	public StatementSTM1(Statment stmt, StatementSTM stmtSTM) {
		super();
		this.stmt = stmt;
		this.stmtSTM = stmtSTM;
	}
	
	public String getValue() {
        return stmt.getValue() + stmtSTM.getValue();
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
