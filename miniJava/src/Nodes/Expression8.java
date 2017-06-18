/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nodes;


public class Expression8 implements Expression{
    ExpressionRec exR1 ;
    Constructor_ c ;

    public Expression8(ExpressionRec exR1, Constructor_ c) {
        this.exR1 = exR1;
        this.c = c;
    }
    
	@Override
    public String getValue() {
        return Terminal.NEW+" " + c.getValue() +  exR1.getValue() ;
    }
    
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
