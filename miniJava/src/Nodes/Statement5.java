package Nodes;

public class Statement5 implements Statment{

	Identifier id ;
	IdentifierAssign idA ;
	public Statement5(Identifier id ,IdentifierAssign idA){
		this.id=id ;
		this.idA=idA;
	}
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "    "+id.getValue()+" "+idA.getValue();
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}

}
