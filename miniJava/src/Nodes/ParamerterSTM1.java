package Nodes;

public class ParamerterSTM1 implements ParamerterSTM {
	Type type ;
	Identifier id ;
	Paramerter par ;
	
	public ParamerterSTM1(Type type, Identifier id, Paramerter par) {
		this.type = type;
		this.id = id;
		this.par = par;
	}
	
	public String getValue() {
        return " "+type.getValue()+" "+id.getValue()+" "+par.getValue();
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
