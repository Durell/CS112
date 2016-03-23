/*
Chapter No. 12 - Project 2 (Page 708)
File Name:          PizzaOrder.java
Programmer:         Durell Smith
Date Last Modified: March 2x, 2016
*/

// imports

public class PizzaOrder
{
	// variables
	private static int MAXPIZZAS;
	private static int numPizzas;
	Pizza[] order;

	public PizzaOrder()
	{
		MAXPIZZAS = 10;
		numPizzas = 0;
		order = new Pizza[MAXPIZZAS];
	}

	// accessor and mutator methods
	public void addPizzaToOrder(char size, boolean pepp, boolean saus, boolean mush)
	{
		order[numPizzas] = new Pizza(size, pepp, saus, mush);
		numPizzas++;
	}

	public double calcCost()
	{
		double total = 0;
		for (int i = 0; i < numPizzas; i++)
		{
			total += order[i].getNumToppings();
			if (order[i].getSize() == 's')
				total += 8;
			else if (order[i].getSize() == 'm')
				total += 10;
			else if (order[i].getSize() == 'l')
				total += 12;
		}
		return total;
	}

	// main method
	public static void main(String[] args)
	{
		PizzaOrder pizzas = new PizzaOrder();
		pizzas.addPizzaToOrder('m', true, true, false);
		pizzas.addPizzaToOrder('l', true, false, false);
		pizzas.addPizzaToOrder('m', true, true, false);
		pizzas.addPizzaToOrder('s', false, false, false);
		pizzas.addPizzaToOrder('l', true, true, false);
		pizzas.addPizzaToOrder('s', true, true, false);
    for (int i = 0; i < pizzas.numPizzas; i++)
      System.out.println("Pizza " + (i + 1) + ": " + pizzas.order[i]);
		System.out.println("The above " + (pizzas.numPizzas) + 
                       " pizzas cost: " + pizzas.calcCost());
	} // end main method
} // end PizzaOrder class
