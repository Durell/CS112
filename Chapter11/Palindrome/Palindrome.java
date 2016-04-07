/*
Chapter No. 11 - Handout 3 Project 2
File Name:          Palindrome.java
Programmer:         Durell Smith
Date Last Modified: March 22, 2016

Problem Statement:
Write a recursive static method that takes a string input to determine if the input is a
palindrome (ignoring spaces, punctuation and case sensitivity) and if so returns true.

*/

// imports
import java.util.Scanner;

public class Palindrome
{
	public static int reducer = 1;
	public static int start = 0;
	public static boolean checkPalindrome(String a)
	{
		int end = a.length() - reducer;
		if (start > (end))
		{
			reducer = 1;
			start = 0;
			return true;
		}
		else if (a.charAt(start) == a.charAt(end))
		{
			reducer++;
			start++;
			return checkPalindrome(a);
		}
		else
			return false;
	}
	// main method
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String input = "";
		boolean done = false;

		System.out.println("I'll determine if your input is a palindrome.");
		while (!done)
		{
			System.out.println("Please give me a line:");
			input = keyboard.nextLine();
			input = input.replaceAll("[^a-zA-Z]", "").toLowerCase();
			System.out.println(checkPalindrome(input));
			System.out.print("Try again? (y/n) > ");
			input = keyboard.nextLine();
			if (input.trim().toLowerCase().equals("n"))
				done = true;
		}
	} // end main method
} // end Palindrome class
