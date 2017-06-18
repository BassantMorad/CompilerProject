/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nodes;

public class Constructor_1 implements Constructor_{
    Expression ex1 ;

    public Constructor_1(Expression ex1) {
        this.ex1 = ex1;
    }
    public String getValue() {
        return Terminal.INT + Terminal.LEFT_SQUARE_B + ex1.getValue() + Terminal.RIGHT_SQUARE_B; 
    }
    
    public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
