/*
Chapter No. 13 - Project 2 (Page 754)
File Name:          InventoryItem.java
Programmer:         Durell Smith
Date Last Modified: April 6, 2016

Problem Statement:

*/

// imports

public class InventoryItem
{

	Private String name;
	private int uniqueItemID;

	/**
	 * Constructors
	*/
	public InventoryItem()
	{
		name = "no name";
		uniqueItemID = null;
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

  public static void main(String[] args)
  {
  }
}