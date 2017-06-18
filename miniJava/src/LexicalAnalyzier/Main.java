package LexicalAnalyzier;

import java.util.ArrayList;

import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import Nodes.Goal;
import jTree.JTreee;

public class Main {

	public static void main(String[] args) {

		
		Files files =new Files();
		String file= files.readCode("code.txt");
	    Tokenizer t = new Tokenizer(file);
	    t.Tokenizer();
	    ArrayList<Token> tokens=t.getTokens();
	    ArrayList<Token> Errors=t.getErrors();
	    files.openFile("");
	    files.writeTokens(tokens);
	    files.writeTokens(Errors);
	    files.closeFile();
	     
	     
	    Parser parse=new Parser(tokens);
	     
	    Goal goal =parse.goal();	 
	     
	    files.openFile("ParseTreeGoal.txt");
	    files.writeParseTree(goal.getValue());
	    files.closeFile();

	    
	    ArrayList<Token> tokenns=files.readTokens("output.txt");
	    
	    if (goal!=null)
	    System.out.println(goal.getValue());
	    
	    DefaultMutableTreeNode root=parse.getRoot();
	    
	    SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	new JTreee(root);
            }
        });

	    
	     
	    
	}
		
	
}
