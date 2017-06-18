/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nodes;

public class Expression1Fn2 implements Expression1Fn{
    Identifier id ;
    ExpressionSTM_ exStm_;
    ExpressionRec exR1 ;
    
    
    public Expression1Fn2(Identifier id, ExpressionSTM_ exStm_, ExpressionRec exR1) {
		super();
		this.id = id;
		this.exStm_ = exStm_;
		this.exR1 = exR1;
	}


	public String getValue(){
        return id.getValue() + Terminal.LEFT_ROUND_B + exStm_.getValue() + Terminal.RIGHT_ROUND_B + exR1.getValue() ;
    }
    
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
