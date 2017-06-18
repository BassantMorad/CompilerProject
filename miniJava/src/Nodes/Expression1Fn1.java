/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nodes;

public class Expression1Fn1 implements Expression1Fn{
    ExpressionRec exR1 ;

    public Expression1Fn1(ExpressionRec exR1) {
        this.exR1 = exR1;
    }
    
    public String getValue(){
        return Terminal.LENGTH + exR1.getValue() ; 
    }
    
    public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
    
}
