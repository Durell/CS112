/*
Chapter No. 11 Recursion - Project 2 (Page 684)
File Name:          Handshakes.java
Programmer:         Durell Smith
Date Last Modified: February 9, 2016

Problem Statement:
Write a recursive function that will take in the number of people in a room and 
determine how many total handshake would occur if everyone were to shake hands
once.
*/

public class Handshakes
{
	public static int handshakes(int n)
	{
		if (n < 1)
		{
			System.out.println("Room must have at leaast 1 person.");
			return 0;
		}
		else if (n == 1)
			return 0;
		else
			return (handshakes(n - 1) + (n-1));
	}
	// main method
	public static void main(String[] args)
	{
		System.out.println("Supposing everyone in a room must shake hands: ");
		for (int i = 12; i >= 0; i--)
			System.out.println(i + " people will produce " + handshakes(i) + " handshakes.");
		System.out.println("What about -1? > " + handshakes(-1));
	} // end main method
} // end Handshakes class
