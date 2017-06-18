package jTree;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import Nodes.Array2;
import Nodes.Goal;
import Nodes.IntType;

public class JTreee extends JFrame
{
    private JTree tree;
    public JTreee(DefaultMutableTreeNode root)
    {
       
        
        tree = new JTree(root);
        add(tree);
        tree.setShowsRootHandles(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Example");       
        this.pack();
        this.setVisible(true);
        this.setSize(700, 700);
        add(new JScrollPane(tree));
        tree.setShowsRootHandles(true);
        tree.setRootVisible(true);


    }
     
        
}