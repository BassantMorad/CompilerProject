package Nodes;

public interface Statment {
	
	 public String getValue();
	 public void accept(NodeVisitor nodeVisitor);
}
