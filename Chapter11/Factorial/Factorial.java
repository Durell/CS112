/*
Chapter No. 11 - Handout 3 Project 1
File Name:          Factorial.java
Programmer:         Durell Smith
Date Last Modified: March 22, 2016

Problem Statement:
Write a static method that implements recursion to calculate
the factorial of a whole number supplied by the user.
*/

// imports
import java.util.Scanner;
import java.util.InputMismatchException;

public class Factorial
{
	public static int calculateFactorial(int n)
	{
		/**
		* must take a number from 0 to 16
		*/
		if (n > 0)
			return (calculateFactorial(n-1) * n);
		else
			return (1);
	}
	// main method
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int num = 0;
		boolean done = false;
		String cont = ""; 

		System.out.println("I can calculate factorials for " +
							"whole numbers (n!).");
		while (!done)
		{
			System.out.print("Please give me a number > ");
			boolean entered = false;

			while (!entered)
			{
				// Make sure user inputs an int
				try
				{
					num = keyboard.nextInt();
					keyboard.nextLine();
				}
				catch (InputMismatchException e)
				{
					keyboard.nextLine();
					System.out.println("Not a correctly entered integer.");
					System.out.print("Please try again > ");
				}
				// largest factorial that fits in int is 16
				if (num > 16)
				{
					System.out.println("Can't calculate factorials " +
										"over 16...");
					entered = false;
					System.out.print("Please try again > ");
				}
				// factorial of a negative number is undefined
				else if (num < 0)
				{
					System.out.println("Illegal argument, negative factorial undefined here.");
					entered = false;
					System.out.print("Please try again > ");
				}
				else
					entered = true;
			}
			System.out.println(" " + num + "! = " + 
								calculateFactorial(num));
			System.out.print("Continue? (y/n) > ");
			cont = keyboard.nextLine();
			if (cont.trim().toLowerCase().equals("n"))
				done = true;
		}
	} // end main method
} // end Factorial class
