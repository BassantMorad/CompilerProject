/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nodes;

/**
 *
 * @author Dalia
 */
public class Terminal {
    public static final String EOL = "\\n" ;
    public static final String EOF = "$" ;
    public static final String PLUS= "+" ;
    public static final String LEFT_CURLY_B = "{" ;
    public static final String RIGHT_CURLY_B = "}" ;
    public static final String LEFT_SQUARE_B = "[" ;
    public static final String RIGHT_SQUARE_B = "]" ;
    public static final String LEFT_ROUND_B = "(" ;
    public static final String RIGHT_ROUND_B = ")" ;
    public static final String COMMA = "," ;
    public static final String SEMICOLON = ";" ;
    public static final String DOT = "." ;
    public static final String NOT = "!" ;
    public static final String EQUAL = "=" ;
    public static final String AND = "&&" ;
    public static final String MINUS = "-" ;
    public static final String MULTIPLY = "*" ;
    public static final String LESSTHAN = "<" ;
    public static final String GREATERTHAN = ">" ;
    public static final String IF = "if" ;
    public static final String INT = "int" ;
    public static final String A_CHAR = "char";
    public static final String ELSE = "else" ;
    public static final String MAIN = "main" ;
    public static final String THIS = "this" ;
    public static final String TRUE = "true" ;
    public static final String VOID = "void" ; 
    public static final String CLASS = "class" ;
    public static final String FALSE = "false" ;
    public static final String WHILE = "while" ;
    public static final String LENGTH = "length";
    public static final String PUBLIC = "public";
    public static final String PRIVATE = "private";
    public static final String RETURN = "return";
    public static final String STATIC = "static";
    public static final String NEW = "new";
    public static final String STRING = "String";
    public static final String FLOAT = "float";
    public static final String BOOLEAN = "boolean";
    public static final String EXTENDS = "extends";
    public static final String SYSTEM_OUT_PRINTLN = "System.out.println";
    public static final String COMMENT1 = "//";
    public static final String COMMENT2 = "/* any comment here */";
    public static final String SQUOTE = "'";
    public static final String DQUOTE = "\"";
    public static final String COMMENT_L = "/*";
    public static final String COMMENT_R = "*/";

    
    public static final String Identifier = "ID";
    public static final String INTEGRAL_LITERAL = "INTEGRAL_LITERAL";
    public static final String FLOAT_LITERAL = "FlOAT_LITERAL";
    public static final String STRING_LITERAL = "STRING_LITERAL"; 
    public static final String CHARACTER = "CHAR";
    
    public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
    
}
