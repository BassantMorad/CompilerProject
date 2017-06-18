/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nodes;


public class Expression4 implements Expression{
    ExpressionRec exR1 ;

    public Expression4(ExpressionRec exR1) {
        this.exR1 = exR1;
    }
    
    @Override
    public String getValue() {
        return Terminal.TRUE +" "+ exR1.getValue();
    }
    
    public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
