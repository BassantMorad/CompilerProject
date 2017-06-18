/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nodes;


public class Expression2 implements Expression{

    Expression ex1 ;
    ExpressionRec exR1 ;

    public Expression2(Expression ex1, ExpressionRec exR1) {
        this.ex1 = ex1;
        this.exR1 = exR1;
    }
    
    @Override
    public String getValue() {
        return Terminal.LEFT_ROUND_B +" "+ ex1.getValue()+" "
        		+ Terminal.RIGHT_ROUND_B +" "+ exR1.getValue()+" ";
    }
    
    public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
