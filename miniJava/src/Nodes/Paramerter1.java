package Nodes;

public class Paramerter1 implements Paramerter {
	Type type ;
	Identifier id ;
	Paramerter par ;
	
	public Paramerter1(Type type, Identifier id, Paramerter par) {
		this.type = type;
		this.id = id;
		this.par = par;
	}
	
	
	public String getValue() {
        return Terminal.COMMA +" "+ type.getValue()+" " + id.getValue()+" " +par.getValue();
	}
	
	 public void accept(NodeVisitor nodeVisitor) {
			nodeVisitor.visit(this);
	}
}
