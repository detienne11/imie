package fr.imie.cdi13.dav;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		System.setProperty("file.encoding", "UTF32");
		System.out.println("Hello world : \u265e " + args[0]);
		
		LineNumberReader lineCounter = new LineNumberReader(new InputStreamReader(System.in));

	    String nextLine = null;
	    System.out.println("Type any text and press return. Type 'exit' to quit the program.");
	    try {
	      while ((nextLine = lineCounter.readLine()).indexOf("exit") == -1) {
	        if (nextLine == null)
	          break;
	        System.out.print(lineCounter.getLineNumber());
	        System.out.print(": ");
	        System.out.println(nextLine);
	      }
	    } catch (Exception done) {
	      done.printStackTrace();
	    }

	}

	public static String trace(List<String> listeCases) {
		
		StringBuffer str = new StringBuffer();
		str.append("--- --- --- --- --- --- --- ---\n");
		for (String string : listeCases) {
			str.append(String.format(" %s ", string));
			str.append("|");
			str.append("\n");
		}
		
		return str.toString();
	}
	
}
