/*
Chapter No. 12 - Project 2 (Page 708)
File Name:          Pizza.java
Programmer:         Durell Smith
Date Last Modified: March 2x, 2016

Problem Statement:
*/

// imports

public class Pizza
{
	// variables
	private boolean pepperoni, sausage, mushrooms;
	private char size;

	/**
	* Default Constructor
	*/
	public Pizza(char size, boolean pepp, boolean saus, boolean mush)
	{
		this.size = size;
		pepperoni = pepp;
		sausage = saus;
		mushrooms = mush;
	}

	// accessor and mutator methods
	public char getSize()
	{
		return size;
	}

	public int getNumToppings()
	{
		int numToppings = 0;
		if (pepperoni)
			numToppings++;
		if (sausage)
			numToppings++;
		if (mushrooms)
			numToppings++;
		return numToppings;
	}

	// main method
	public static void main(String[] args)
	{
	} // end main method

} // end Pizza class
