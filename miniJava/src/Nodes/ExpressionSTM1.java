/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nodes;

public class ExpressionSTM1 implements ExpressionSTM{
    ExpressionSTM exStm ;
    Expression ex1 ;

    public ExpressionSTM1(ExpressionSTM exStm, Expression ex1) {
        this.exStm = exStm;
        this.ex1 = ex1;
    }
    public String getValue(){
        return Terminal.COMMA +" "+ ex1.getValue()+ exStm.getValue() ; 
    }
    
    public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
    
}
