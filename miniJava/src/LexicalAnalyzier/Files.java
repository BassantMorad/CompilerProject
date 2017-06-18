package LexicalAnalyzier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;

public class Files {

	public String readCode(String path) {
		String File = "";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				File += sCurrentLine + "\n";
			}
			return File.substring(0, File.length()-1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	FileWriter fileWriter;
	BufferedWriter bufferedWriter;

	public void openFile(String fileName) {
		if (fileName.equals(""))
		 fileName = "output.txt";

		try {
			fileWriter = new FileWriter(fileName);
			bufferedWriter = new BufferedWriter(fileWriter);

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public void writeTokens(ArrayList<Token> tokens) {

		Collections.sort(tokens);

		for (Token i : tokens) {
			if (!(i.getType().equals("Space"))) {
				try {
					bufferedWriter.write("<"+i.getType()+">:");
					bufferedWriter.write(i.getValue());
					bufferedWriter.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public void closeFile() {
		try {
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public ArrayList<Token> readTokens(String path) {
		ArrayList<Token> Ar =new ArrayList<Token>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				String ar[]=sCurrentLine.split(":");
				int beg=ar[0].indexOf("<");
				int en=ar[0].lastIndexOf(">");
				String Type=ar[0].substring(beg, en).trim();
				String Value=ar[1].trim();
				Ar.add(new Token(Type,Value));
			}
			return Ar;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public void writeParseTree(String Goal){
		
		try {
			bufferedWriter.write(Goal);
			bufferedWriter.newLine();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
