package LexicalAnalyzier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
	String str = "int x=5;";
	ArrayList<Token> Tokens = new ArrayList<Token>();
	ArrayList<Token> Error = new ArrayList<Token>();

	public Tokenizer(String File) {
		this.str = File;
	}

	public ArrayList<Token> getTokens() {
		return Tokens;
	}
	public ArrayList<Token> getErrors() {
		return Error;
	}
	
	private void Sort(ArrayList<Token>tokens) {
		Collections.sort(tokens);
	}

	/*************************************
	 * Data Types
	 ****************************************************/

	private void check_Int() {
		String RE = "(\\bint\\b)";
		Pattern ptr = Pattern.compile(RE);
		// Matcher m=null;
		// if (!(i.getValue().substring(0, 2).equals("/*") ||
		// i.getValue().substring(0, 2).equals("//")))
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("INT", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}

	}

	private void check_string() {
		String RE = "(\\bString\\b)";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("String", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void check_char() {
		String RE = "(\\bchar\\b)";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("CHAR", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void check_Float() {
		String RE = "(\\bfloat\\b)";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("FLOAT", value, start, end);
			Tokens.add(token);
		}
	}

	private void check_boolean() {
		String RE = "(\\bboolean\\b)";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("BOOLEAN", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	/************************************ Values ****************************************************/

	private void check_A_CHAR() {
		String RE = "[\'](.|\n)[\']"; // ? mmkn ykon el character m4 mogod
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("ACHAR", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}

	}

	private void check_INTEGRAL_LITERAL() {
		String RE = "\\b(?<![.\\d])\\d+(?![.\\d])\\b";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("INTEGRAL_LITERAL", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void check_FLOAT_LITERAL() {
		String RE = "(\\b[0-9]+)(\\.[0-9]+)?\\b";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("FLOAT_LITERAL", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void check_STRING_LITERAL() {
	    String RE = "[\"].*[\"]";
	   // String RE = "[\"][.*\n*][\"]";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			// " DDFFF "
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("STRING_LITERAL", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void check_FALSE() {
		String RE = "(\\bfalse\\b)";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("FALSE", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Check_TRUE() {
		String RE = "\\btrue\\b";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("True", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);

		}
	}

	/*************************************
	 * Variables Names/IDs
	 ****************************************************/

	private void check_ID() {
		String RE = "\\b[a-zA-Z_][a-zA-Z0-9_]*";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("ID", value, start, end);
			if (check_Boundry(start, end, value))

				Tokens.add(token);
		}
	}

	/***********************
	 * Reserved and Unique names and split by space
	 **************************************/

	private void check_class() {
		String RE = "\\bclass\\b";
		// String RE="\\bclass\\b";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("CLASS", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void check_public() {
		String RE = "\\bpublic\\b";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("PUBLIC", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Check_Void() {
		String RE = "\\bvoid\\b";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("VOID", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private ArrayList<Token> Check_Main() {
		String RE = "\\bmain\\b";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		ArrayList<Token> Tokens = new ArrayList<Token>();
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("MAIN", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
		return Tokens;
	}

	private void check_static() {
		String RE = "\\bstatic\\b";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("STATIC", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void check_extends() {
		String RE = "\\bextends\\b";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("Extends", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void check_New() {
		String RE = "\\bnew\\b";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("NEW", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void check_while() {
		String RE = "\\bwhile\\b";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("WHILE", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Check_IFCondition() {
		String RE = "\\bif\\b";

		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("IF_CONDITION", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Check_Else() {
		String RE = "\\belse\\b";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("< ELSE > : ", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void check_length() {
		String RE = "\\blength\\b)";
		Pattern ptr = Pattern.compile("length ");
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("LENGTH", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Check_This() {
		String RE = "(\\bthis\\b)";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("THIS", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void check_RETURN() {
		String RE = "(\\breturn\\b)";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("RETURN", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void check_print() {
		String RE = "(\\bSystem.out.println\\b)";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("System.out.println", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	/******************************************** Comments ***********************************************/
	private void check_COMMENT1() {
		String RE = "//.*$";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("COMMENT_1", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void check_COMMENT2() {
		String RE = "(/\\*([^*]|[\r\n]|(\\*+([^*/]|[\r\n])))*\\*+/)|(//.*)";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("COMMENT_2", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void check_COMMENT_L() { // /*
		String RE = "/[*]";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("COMMENT_L", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void check_COMMENT_R() {
		String RE = "([*]/)";

		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("COMMENT_R", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	/******************************************** Quotes ***********************************************/

	private void check_DQUOTE() {
		String RE = "\"";

		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("DQUOTE", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void check_SQUOTE() {
		String RE = "\'";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("SQUOTE", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	/******************************************** operations ***********************************************/
	private void check_Plus() {
		Pattern ptr = Pattern.compile("\\+");
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("PLUS", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Check_Minus() {

		Pattern ptr = Pattern.compile("\\-");
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("MINUS", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Check_Multiply() {

		Pattern ptr = Pattern.compile("\\*");
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("MULTIPLY", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Check_EQual() {

		Pattern ptr = Pattern.compile("\\=");
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("EQUAL", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	/******************************************** Symbols ***********************************************/

	private void Check_Comma() {
		Pattern ptr = Pattern.compile(",");
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("COMMA", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Check_SemiColon() {
		Pattern ptr = Pattern.compile(";");
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("SEMICOLON", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Check_Dot() {

		Pattern ptr = Pattern.compile("[\\.]");/// btala3 lma ykon 3.3
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("DOT", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Check_NOT() {

		Pattern ptr = Pattern.compile("!");
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("NOT", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Check_AND() {

		Pattern ptr = Pattern.compile("\\&&");
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("AND", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Check_EOL() {
		String RE = "$|\n";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("EOL", "End OF Line", start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	/******************************************** Comparison ***********************************************/

	private void Check_LessThan() {
		String RE = "\\>";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("LESS", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Check_GreaterThan() {
		String RE = "\\<";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("GREATER_THAN", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	/******************************************** Brackets ***********************************************/

	private void Left_Curly_B() {
		String RE = "\\{";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("LEFT_CURLY_BRACT", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Right_Curly_B() {
		String RE = "\\}";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {

			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("RIGHT_CURLY_BRACKET", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Left_Square_B() {
		String RE = "\\[";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("LEFT_SQUARE_BRACKERT", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Right_Square_B() {
		String RE = "\\]";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("RIGHT_SQUARE_BRACKET", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Left_Round_B() {
		String RE = "\\(";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("LEFT_ROUND_BRACKET", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	private void Right_Round_B() {
		String RE = "\\)";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			int start = m.start();
			int end = m.end();
			Token token = new Token("RIGHT_ROUND_B", value, start, end);
			if (check_Boundry(start, end, value))
				Tokens.add(token);
		}
	}

	/******************************************** Space ***********************************************/
	private void Split_With_Spaces() {
		String RE = " ";
		Pattern ptr = Pattern.compile(RE);
		Matcher m = ptr.matcher(str);
		while (m.find()) {
			String value = m.group(0);
			Token token = new Token("Space", value, m.start(),m.end());
			Tokens.add(token);
		}
	}

	/********************************************For matching **********************************************/

	private boolean check_Boundry(int start, int end, String Value) {
		
		for (int i = 0 ; i < Tokens.size() ; i++) {
			// if (i.getStart() == start && i.getEnd()== end)//ignore
			if (Tokens.get(i).getStart() <= start && Tokens.get(i).getEnd() >= end) // ignore
				return false;
			else if (Tokens.get(i).getStart() >= start && Tokens.get(i).getEnd() < end) {// delete old  add new
				Tokens.remove(Tokens.get(i));
				i--;
			}
			else if (Tokens.get(i).getStart() > start && Tokens.get(i).getEnd() <= end) {// delete old  add new
				Tokens.remove(Tokens.get(i));
				i--;
			}
			else if (Tokens.get(i).getStart() > start && Tokens.get(i).getEnd() < end) {// delete old  add new
				Tokens.remove(Tokens.get(i));
				i--;
			}
		}
	
		return true;

	}
/************************************************   Error  ************************************************************/
	private ArrayList<Token> Handle_Error(){
		
		for (int i= 0 ;i<Tokens.size();i++){
			if (i==0&&Tokens.get(i).getStart()!=0){
				String ErrorStr=str.substring(0,Tokens.get(i).getStart());
                 if (!ErrorStr.trim().equals("")){
				Token t=new Token("ERROR" ,ErrorStr,0,Tokens.get(i).getStart());
				Error.add(t);}
			}
			else if (i!=0&&Tokens.get(i-1).getEnd()< Tokens.get(i).getStart()){
				String ErrorStr=str.substring(Tokens.get(i-1).getEnd(),Tokens.get(i).getStart());
                if (!ErrorStr.trim().equals("")){
				Token t=new Token("ERROR" ,ErrorStr,Tokens.get(i-1).getEnd(),Tokens.get(i).getStart());
				Error.add(t);}
			}
			
		}
		return Error;
	}

	/******************************************** Calling **********************************************/
	private void Perform_Operations() {
		
		Split_With_Spaces();	
		check_COMMENT1();
		check_COMMENT2();
//		// Literal
		check_STRING_LITERAL();
		check_A_CHAR();
		check_INTEGRAL_LITERAL();
		check_FLOAT_LITERAL();
//		// // Brackets
		Left_Curly_B();
		Right_Curly_B();
		Left_Round_B();
		Right_Round_B();
		Left_Square_B();
		Right_Square_B();
		// //Symbols and operation
		check_Plus();
		Check_SemiColon();
		Check_AND();
		Check_Minus();
		Check_Multiply();
		
		Check_Dot();
		Check_NOT();
		Check_EQual();
		Check_GreaterThan();
		Check_LessThan();
		Check_Comma();
		Check_EOL();
		// Reserved words
		check_print();
		Check_Else();
		Check_IFCondition();
		check_char();
		check_Int();
		check_extends();
		check_while();
		Check_TRUE();
		check_boolean();
		check_string();
		check_static();
		Check_Void();
		Check_This();
		check_New();
		check_class();
		check_length();
		check_Float();
		check_RETURN();
		check_FALSE();
		check_public();
		Check_Main();
		check_ID();
		check_SQUOTE();
		check_DQUOTE();
		check_COMMENT_L();
		check_COMMENT_R();
		
	}
	
	public void Tokenizer(){
		Perform_Operations();
		Sort(Tokens);
		Handle_Error();
		Sort(Error);
		
	}
	
	
	
	
	
	
}
