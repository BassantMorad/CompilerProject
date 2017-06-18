/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nodes;

public class ExpressionRec1 implements ExpressionRec{
    Operator op ;
    Expression ex1 ;
    ExpressionRec exR1 ;

    public ExpressionRec1(Operator op, Expression ex1, ExpressionRec exR1) {
        this.op = op;
        this.ex1 = ex1;
        this.exR1 = exR1;
    }
    
    public String getValue(){
        return op.getValue()+" " + ex1.getValue() + exR1.getValue() ; 
    }
    
    public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
