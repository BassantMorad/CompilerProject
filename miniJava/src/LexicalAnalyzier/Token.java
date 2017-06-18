package LexicalAnalyzier;

import java.util.Comparator;

public class Token implements Comparable<Token> {
	private String Type ;
	private String Value ;
	private int start ;
	private int end ;
	
	public Token(String type, String value, int start , int end) {
		Type = type;
		Value = value;
		this.start = start;
		this.end=end ;
		
	}
	public Token(String type, String value) {
		Type = type;
		Value = value;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end ) {
		this.end = end;
	}

	
	@Override
	public int compareTo(Token token) {
		if (getStart()>token.getStart())
			return 1;
		else if (getStart()<token.getStart())
			return -1;
		return 0;
	}
	
	
	@Override
	public String toString() {
		return "Token [Type=" + Type + ", Value=" + Value + ", start=" + start + ", end=" + end + "]";
	}
	
	
	
	
}
