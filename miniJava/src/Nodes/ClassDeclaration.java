package Nodes;

public class ClassDeclaration {
//"class" <Identifier> <extends> "{" <VarDeclarationSTM> <MethodDeclarationSTM> "}"
	Identifier id;
	Extends ex;
	VarDeclarationSTM varDec ;
	MethodDeclarationSTM methodDec;
	
	public ClassDeclaration(Identifier id,Extends ex,VarDeclarationSTM varDec ,MethodDeclarationSTM methodDec){
		this.id=id;
		this.ex=ex;
		this.varDec=varDec;
		this.methodDec=methodDec;
	}
	
	public String getValue(){
		return Terminal.CLASS+" "+id.getValue()+" "+ex.getValue()+Terminal.LEFT_CURLY_B+"\n"+varDec.getValue()+
				methodDec.getValue()+"\n"+Terminal.RIGHT_CURLY_B;
	}
	
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
	
}
