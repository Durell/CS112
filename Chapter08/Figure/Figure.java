/*
Chapter No. 8 - Exercise No. 6
File Name:          Figure.java
Programmer:         Durell Smith
Date Last Modified: February 9, 2016

Problem Statement:
 
Overall Plan:
1. Create a class figure with methods draw() and erase()
2. Create derived classes triangle and rectangle with methods
	that override draw() and erase() plus have a method
	center() to center the figure

Classes needed and Purpose:
main class - Figure
*/

// imports

public class Figure
{
	// Draw method 
	public void draw()
	{
		System.out.println("Figure draw() maethod");
	}

	public void erase()
	{
		System.out.println("\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n");
	}


	public void center()
	{
		erase();
		draw();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
	}
	// accessor and mutator methods

} // end Figure class