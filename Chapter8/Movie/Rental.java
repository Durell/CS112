/*
  Chapter No. 8 - Exercise No. 3
  File Name:          Rental.java
  Programmer:         Durell Smith
  Date Last Modified: February 9, 2016

  Problem Statement:
  Extend Movie class with Rental class to store a movie, a customer, and how many 
  days late the movie is.

  Overall Plan:
  1. Extend the Movie class
  2. Create two int variables for customerID and daysLate, also create a Movie
      variable to store the customer's movie
  3. Modify calculateFees() to calculate fees from the movie the customer has
  4. Create a lateFeesOwed() method that takes in an array of Rental[] and adds
      the late fees for each Rental object stored in the array.

  Classes needed and Purpose:
  main class - Rental used to store movies and associate with a customer
*/

public class Rental
{

  // variables:
  Movie m;
  int customerId, daysLate;

  /**
  * Default Constructor; 
  */
  public Rental()
  {
    m = new Movie();
    customerId = 0;
    daysLate = 0;
  }

  public Rental(Movie r, int id, int days)
  {
    m = r;
    customerId = id;
    daysLate = days;
  }

  // ======================
  // Various accessor and mutator methods
  // ======================

  public double calculateFees()
  { 
    return m.calculateFees(daysLate);
  }

  public static double lateFeesOwed(Rental[] r)
  { 
    double total = 0;
    for (int i = 0; i < r.length; i++)
    {
      total += r[i].calculateFees();
    }
    return total;
  }


  public static void main (String[] args)
  {

    Movie c = new Comedy("Zombieland", "R", 2211);
    Movie a = new Action("StarWars", "PG-13", 1111);
    Movie d = new Drama("Shawshank Redemption", "R", 1221);
    Rental cr = new Rental(c, 2, 4);
    Rental ar = new Rental(a, 2, 3);
    Rental dr = new Rental(d, 2, 5);

    Rental[] total = {cr, ar, dr};

    double tot = lateFeesOwed(total);
    System.out.println("lateFeesOwed() will be: \n(4•2.5) + (3•3) + (5•2) = 29\n> " + tot);

  } // ! end of main()

} // ! end of class Rental