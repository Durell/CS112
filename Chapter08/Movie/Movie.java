/* 
  Chapter No. 8 - Project 2
  File Name:          Movie.java
  Programmer:         Durell Smith
  Date Last Modified: February 9, 2016

  Problem Statement:
  Create a Movie class that can be used with a video rental business to keep 
  track of different movies and assign different late fees to each.
  
  Overall Plan:
  1. Create base class Movie 
  2. Create 2 String variables for title and rating, an int variable
      for id, and double variable for lateFee in base class - all movies
      will have all of these variables.
  2. Add constructors to set title, rating, id, and late fee (if necessary)
  3. Variables will be private so accessor and mutator methods need to be made
  4. CalculateFees() can be abstracted if Movie class is never instantiated, but 
      not going to in case there are ever movies created that have no genre. Also 
      allows me to just write the method once.
  5. Create appropriate methods to override Object class toString() and equals() 
      methods. Two movies are equal if they have the same id.
  6. Create 3 derived classes called Action, Comedy, and Drama:
      - Different genres can have different late fees:
        • Default is $2, so that is what base class will set it to.
        • Action is $3, so lateFee needs to be changed in Action class
        • Comedy is $2.50, so lateFee will change in comedy
        • Drama is $2, so lateFee will not change

  Classes needed and Purpose:
  main class - Movie
*/

// Base class
public class Movie
{
  // variables:
  private String title, rating;
  private int id;
  private double lateFee;

  /**
  * Default Constructor; 
  */
  public Movie()
  {
    title = "NEEDS A TITLE";
    rating = "NEEDS RATING";
    id = 0;
    lateFee = 2.0;
  }

  public Movie(String t, String r, int i)
  {
    title = t;
    rating = r;
    id = i;
    lateFee = 2.0;
  }

  public Movie(String t, String r, int i, double l)
  {
    title = t;
    rating = r;
    id = i;
    lateFee = l;
  }

  // ======================
  // Various accessor and mutator methods
  // ======================
  public String getTitle()
  {
    return title;
  }

  public void setTitle(String t)
  {
    title = t;
  }

  public String getRating()
  {
    return rating;
  }

  public void setRating(String r)
  {
    rating = r;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int i)
  {
    id = i;
  }

  public void setLateFee(double l)
  {
    lateFee = l;
  }

  public double calculateFees(int days)
  {
    return lateFee * days;
  }

  public String toString()
  {
    return "Title: " + title + "\nRated: " + rating + "\nid: " + 
            id + "\nlate Fee: " + lateFee;
  }

  public boolean equals(Movie m)
  {
    return this.id == m.getId();
  }


} // ! end of class Movie