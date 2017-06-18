package Nodes;

public class CharType implements Type {

	private Array array ;
	
	
	public CharType(Array array) {
		super();
		this.array = array;
	}


	public String getValue()
	{
		return Terminal.A_CHAR+ array.getValue();
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
