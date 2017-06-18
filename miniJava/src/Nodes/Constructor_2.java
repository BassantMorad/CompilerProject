/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nodes;

public class Constructor_2 implements Constructor_{
    Identifier id ;

    public Constructor_2(Identifier id) {
        this.id = id;
    }

    @Override
    public String getValue() {
        return id.getValue() + Terminal.LEFT_ROUND_B + Terminal.RIGHT_ROUND_B ;
    }
    
    public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
    
}
