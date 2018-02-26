package com.github.Gamebuster19901.regexThing;

import java.util.Scanner;

/*
 * OBJECTIVE:
 * 
 * Write a program that takes in two words, and then recursively determines if the letters of the first word are contained, in any order, in the second word.
 * if the size of the first word is larger than the second then it should automatically return false. Also if both strings are empty then it should return true.
 * 
 * You May NOT:
 * 		*Use any iterative loops. In other words, no for-loops, no while-loops, no do-while loops, no for-each loops.
 *		*Use the string method .contains(String)  ***(It's actually .contains(CharSequence), but I know what you mean)***
 * You May:
 * 		Use the string method .charAt(Index) ***(It's actually CharSequence.charAt(Index), but I know what you mean)***
 */

public class Main {
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		
		String line1;
		String line2;
		String result;
		
		System.out.println("Enter 2 words. I will determine if the letters of the first word are contained in the second word.\nOr type \"terminate\" to terminate this program.");
		s.hasNextLine();
		line1 = s.nextLine();
		if(line1.equals(("terminate"))){
			return;
		}
		
		System.out.println("Enter second word, or \"terminate\" to terminate this program.");
		s.hasNextLine();
		line2 = s.nextLine();
		if(line2.equals(("terminate"))){
			return;
		}
		
		result = checkStrings(line1, line2) ? '\"' + line1 + "\" contains all letters of \"" + line2 + '\"' : '\"' + line1 + "\" does not contain all letters of \"" + line2 + '\"';
		
		System.out.println(result);
		
		main(new String[]{});
	}
	
	public static boolean checkStrings(String line1, String line2) {
		if(line2.length() == 0) {return true;}
		String regex = "(?i)(" + line2.charAt(0) + ")";
		if(line1.matches(".*" + regex + ".*")) {
			return checkStrings(line1.replaceFirst(regex, ""), line2.replaceFirst(regex, ""));
		}
		return false;
	}
	
}
