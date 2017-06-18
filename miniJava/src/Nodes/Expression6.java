/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nodes;

public class Expression6 implements Expression{
    ExpressionRec exR1 ;
    Identifier id ;

    public Expression6(ExpressionRec exR1, Identifier id) {
        this.exR1 = exR1;
        this.id = id;
    }
    
    @Override
    public String getValue() {
        return id.getValue()+" " + exR1.getValue();
    }
    
    public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
