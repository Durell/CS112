/*
  Chapter No. 8 - Exercise No. 3
  File Name:          MultiItemSale.java
  Programmer:         Durell Smith, Andres Segura, Alan Tapia, Sid Fernandez
  Date Last Modified: February 9, 2016

  Problem Statement:

  Define a class named MultiItemSale that represents a sale of multiple items of
  type Sale given in Display 8.1 (or of the types of any of its descendent classes).
  The class MultiItemSale will have an instance variable whose type is Sale[] ,
  which will be used as a partially filled array. There will also be another instance
  variable of type int that keeps track of how much of this array is currently used.
  The exact details on methods and other instance variables, if any, are up to you.
  Use this class in a program that obtains information for items of type Sale and of
  type DiscountSale ( Display 8.2 ) and that computes the total bill for the list of
  items sold.

  Overall Plan:
  1. Extend the Movie class
  2. Create an int for customerID and a Movie to store a customer's movie
  3. Modify calculateFees() to calculate fees from the movie the custer has

  Classes needed and Purpose:
  main class - MultiItemSale
   
*/

/**
* Class for a simple sale of one item with no tax, discount, or other adjustments.
* Class invariant: The price is always nonnegative; the name is a nonempty string.
*/
public class MultiItemSale
{
    Sale[] items;
    int numUsed;

    public MultiItemSale()
    {

    }

    public MultiItemSale(Sale[] i, int n)
    {
        this.items = i;
        numUsed = n;
    }
    /*
     Returns true if the bill for the calling object is less
     than the bill for otherSale; otherwise returns false.
    */
    public boolean lessThan (Sale otherSale)
    {
        if (otherSale == null)
        {
            System.out.println("Error: null Sale object.");
            System.exit(0);
        }
        //else
        return (bill( ) < otherSale.bill( ));
    }

    // REWRITE
    public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            Sale otherSale = (Sale)otherObject;
            return (name.equals(otherSale.name)
               && (price == otherSale.price));
        }
    }

    public Sale clone( )
	{
	    return new Sale(this );
    }
}
