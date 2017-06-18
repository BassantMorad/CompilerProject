/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nodes;

public class IdentifierAssign2 implements IdentifierAssign{

     Expression ex1 ;
     Expression ex2 ;

    public IdentifierAssign2(Expression ex1, Expression ex2) {
        this.ex1 = ex1;
        this.ex2 = ex2;
    }
     
     
    @Override
    public String getValue() {    
        return Terminal.LEFT_SQUARE_B +" "+ ex1.getValue() +" "+
        		Terminal.RIGHT_SQUARE_B +" "+ Terminal.EQUAL +" "+ 
                ex2.getValue() + Terminal.SEMICOLON;
    }
    
    public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
