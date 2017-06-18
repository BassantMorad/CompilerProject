package Nodes;

public class FloatType implements Type {

	private Array array ;
	
	public FloatType(Array array) {
		this.array = array;
	}

	public String getValue()
	{
		return Terminal.FLOAT+ array.getValue();
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
