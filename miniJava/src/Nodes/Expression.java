/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nodes;

public interface Expression {
    public String getValue();
    public void accept(NodeVisitor nodeVisitor) ;
}
