package Nodes;

public class ParamerterSTM2 implements ParamerterSTM {

	public ParamerterSTM2(){
		
	}
	 public String getValue(){
		 return "";
	 }
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
	 
}
