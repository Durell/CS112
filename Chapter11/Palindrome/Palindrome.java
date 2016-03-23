/*
Chapter No. 11 - Handout 3 Project 2
File Name:          Palindrome.java
Programmer:         Durell Smith
Date Last Modified: March 22, 2016

Problem Statement:
Write a recursive static method that takes a string input to determine if the input is a
palindrome (ignoring spaces, punctuation and case sensitivity) and if so returns true.

1. Write a static recursive method definition for a method that takes one parameter of type
String and returns a boolean value. The method return true if the argument is a
palindrome and false otherwise. A palindrome is a string that reads the same forward
and backward, such as “radar”. Disregard spaces and punctuation marks, and consider
upper- and lowercase versions of the same letter to be equal. For example, the following
would be considered a palindrome by your method.
“Straw? No, too stupid a fad, I put soot on warts.”
Your method need not check that the string is correct English phrase or word. The string
“xyzczyx” will be considered a palindrome by your method. Embed the method in a
program and test it.

*/

// imports
import java.util.Scanner;

public class Palindrome
{
	public static boolean determinePalindrome(String a)
	{
		if (first letter = last letter)
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
			determinePalindrome(input);
			System.out.print("Try again? (y/n) > ");
			input = keyboard.nextLine();
			if (input.trim().toLowerCase().equals("n"))
				done = true;
		}
	} // end main method
} // end Palindrome class
