/*
Chapter No. 12 - Project 2 (Page 708)
File Name:          Pizza.java
Programmer:         Durell Smith
Date Last Modified: March 2x, 2016

Problem Statement:
*/

public class Pizza
{
	// variables
	private boolean pepperoni, sausage, mushrooms;
	private char size;

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

  public boolean getPepp()
  {
    return pepperoni;
  }

  public boolean getSaus()
  {
    return sausage;
  }

  public boolean getMush()
  {
    return mushrooms;
  }

  public String toString()
  {
    return ("Size: " + size + ", Pepperoni: " + pepperoni +
            ", Sausage: " + sausage + ", Mushrooms: " + mushrooms);
  }

  public boolean equals(Object otherObject)
  {
    Pizza otherPizza = (Pizza)otherObject;
    return (size == otherPizza.getSize() 
            && pepperoni == otherPizza.getPepp()
            && sausage == otherPizza.getSaus()
            && mushrooms == otherPizza.getMush());
  }

} // end Pizza class
