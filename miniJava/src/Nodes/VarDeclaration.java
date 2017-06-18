package Nodes;

public class VarDeclaration {
	Type type;
	Identifier id;

	public VarDeclaration(Type type, Identifier id) {
		this.type=type;
		this.id=id;
	}
	public String getValue(){
		return "\t"+ type.getValue()+" "+id.getValue()+Terminal.SEMICOLON+"\n";
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
