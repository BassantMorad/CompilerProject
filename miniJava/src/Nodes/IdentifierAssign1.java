/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nodes;

public class IdentifierAssign1 implements IdentifierAssign{

    Expression ex1 ;

    public IdentifierAssign1(Expression ex1) {
        this.ex1 = ex1;
    }
    
    @Override
    public String getValue() {
        return " "+Terminal.EQUAL +" "+ ex1.getValue()+" " + Terminal.SEMICOLON;
    }
    
    public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
    
}
