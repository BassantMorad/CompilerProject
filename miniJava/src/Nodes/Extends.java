package Nodes;

public interface Extends {
	public String getValue();
	public void accept(NodeVisitor nodeVisitor);
}
