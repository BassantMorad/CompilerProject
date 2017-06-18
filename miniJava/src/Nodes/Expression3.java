/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nodes;

public class Expression3 implements Expression{
    ExpressionRec exR1 ;
    INTEGRAL_LITERAL intLit ;

    public Expression3(ExpressionRec exR1, INTEGRAL_LITERAL intLit) {
        this.exR1 = exR1;
        this.intLit = intLit;
    }
    
    
    @Override
    public String getValue() {
        return intLit.getValue()+" " + exR1.getValue();
    }
    
    public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
