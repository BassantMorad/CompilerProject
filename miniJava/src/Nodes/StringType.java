package Nodes;

public class StringType implements Type {

	private Array array ;
	
	public StringType(Array ar) {
		this.array = ar;
	}
	
	public String getValue()
	{
		return Terminal.STRING+ array.getValue();
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
