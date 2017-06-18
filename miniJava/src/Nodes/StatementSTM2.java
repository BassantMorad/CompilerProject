package Nodes;

public class StatementSTM2  implements StatementSTM{

	public StatementSTM2(){
		
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
