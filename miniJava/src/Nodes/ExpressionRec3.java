/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nodes;

public class ExpressionRec3 implements ExpressionRec{
    Expression1Fn exFn ;

    public ExpressionRec3(Expression1Fn exFn) {
        this.exFn = exFn;
    }
    public String getValue(){
        return Terminal.DOT + exFn.getValue() ; 
    }
    
    public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
