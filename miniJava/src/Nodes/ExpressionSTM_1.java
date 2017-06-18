/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nodes;

public class ExpressionSTM_1 implements ExpressionSTM_{
    ExpressionSTM exStm ;
    Expression ex1 ;

    public ExpressionSTM_1(ExpressionSTM exStm, Expression ex1) {
        this.exStm = exStm;
        this.ex1 = ex1;
    }
    public String getValue(){
        return ex1.getValue()+ exStm.getValue() ; 
    }
    
    public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
