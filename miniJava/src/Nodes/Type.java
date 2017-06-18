package Nodes;

public interface Type {
	
	public String getValue();
	public void accept(NodeVisitor nodeVisitor);
}
