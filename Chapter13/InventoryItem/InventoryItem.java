/*
Chapter No. 13 - Project 2 (Page 754)
File Name:          InventoryItem.java
Programmer:         Durell Smith
Date Last Modified: April 6, 2016

Problem Statement:

*/

// imports
import java.util.Random;

public class InventoryItem implements Comparable
{

	private String name;
	private int uniqueItemID;

	/**
	 * Constructors
	*/
	public InventoryItem()
	{
		name = "no name";
    Random ran = new Random();
    uniqueItemID = ((ran.nextInt(1000) - 300) * 3);
	}

	public InventoryItem(String n, int id)
	{
		name = n;
		uniqueItemID = id;
	}

	public String getName()
	{
		return name;
	}

	public int getID()
	{
		return uniqueItemID;
	}

	public void setName(String n)
	{
		name = n;
	}

	public String toString()
	{
		return name + " " + uniqueItemID;
	}

	public int compareTo(Object other)
	{
		InventoryItem otherItem = (InventoryItem)other;
		if (uniqueItemID == otherItem.getID())
			return 0;
		else if (uniqueItemID > otherItem.getID())
			return -1;
		else
			return 1;
	}

  public static void main(String[] args)
  {
		InventoryItem[] stock = new InventoryItem[5];
		stock[0] = new InventoryItem("UAV", 12);
		stock[1] = new InventoryItem("Mac", 2);
		stock[2] = new InventoryItem("Pack", 42);
		stock[3] = new InventoryItem("Shield", 10);
		stock[4] = new InventoryItem("R6", 32);

  	/***
		String[] stock = new String[5];
		stock[0] = new String("UAV");
		stock[1] = new String("Mac");
		stock[2] = new String("Pack");
		stock[3] = new String("Shield");
		stock[4] = new String("R6");
		*/

		System.out.println("Stock Before Sorting:");
		for (InventoryItem item : stock)
			System.out.print(item.toString() + " ");
		System.out.println();

		SelectionSort.sort(stock, stock.length);
		System.out.println("Stock After Sorting:");
		for (InventoryItem item : stock)
			System.out.print(item.toString() + " ");
		System.out.println();
  }
}