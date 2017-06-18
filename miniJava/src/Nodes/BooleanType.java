package Nodes;

public class BooleanType implements Type {
	
	private Array array ;
	
	public BooleanType(Array array) {
		this.array = array;
	}

	public String getValue()
	{
		return Terminal.BOOLEAN+ array.getValue();
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
