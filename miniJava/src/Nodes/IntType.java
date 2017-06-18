package Nodes;

public class IntType implements Type{

    private Array array ;
	
    public IntType(Array array) {
		this.array = array;
	}

	public String getValue()
	{
		return Terminal.INT+ array.getValue();
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
