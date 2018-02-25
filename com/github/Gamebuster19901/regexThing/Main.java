package com.github.Gamebuster19901.regexThing;

import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		try {
			Scanner s = new Scanner(System.in);
			
			String line1;
			String line2;
			String result;
			
			System.out.println("Enter 2 words. I will determine if the letters of the first word are contained in the second word.\nOr type \"terminate\" to terminate this program.");
			s.hasNextLine();
			line1 = s.nextLine().toLowerCase();
			if(line1.equals(("terminate"))){
				return;
			}
			
			System.out.println("Enter second word, or \"terminate\" to terminate this program.");
			s.hasNextLine();
			line2 = s.nextLine().toLowerCase();
			if(line2.equals(("terminate"))){
				return;
			}
			
			result = checkStrings(line1, line2) ? '\"' + line1 + "\" contains all letters of \"" + line2 + '\"' : '\"' + line1 + "\" does not contain all letters of \"" + line2 + '\"';
			
			System.out.println(result);
			
			main(new String[]{});
		}
		catch(StackOverflowError e) { //if you give me a small stack, I don't care, we can just clear the stack by catching StackOverflowError, and call main again.
			main(new String[]{});
		}
		
	}
	
	public static boolean checkStrings(String line1, String line2) {
		if(line2.length() == 0) {
			return true;
		}
		String regex = "[" + line2.charAt(0) + "]";
		if(line1.matches(".*" + regex + ".*")) {
			return checkStrings(line1.replaceFirst(regex, ""), line2.replaceFirst(regex, ""));
		}
		return false;
	}
	
}
