/*
Chapter No. 9 - Handout#1 Project 2
File Name:          Employee.java
Programmer:         Durell Smith
Date Last Modified: February 9, 2016

Problem Statement:
Write an Employee class derived from class Person that allows users to enter
employee information including social security number and salary into an array
of up to 100 employees. User must input social security information correctly
otherwise program must advices user of mistake and request to re-enter.
 
Overall Plan:

Classes needed and Purpose:
main class - Employee derived from class Person
*/

// imports

public class Employee extends Person
{
	// variables
	private int social;
	private double salary;

	public Employee(String name, Date birthDate, int soc, double sal)
	{
		super(name, birthDate, null);
		social = soc;
		salary = sal;
	}

	// accessor and mutator methods
	public int getSocial()
	{
		return social;
	}

	public void setSocial(int ss)
	{
		social = ss;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double s)
	{
		salary = s;
	}

  public String toString( )
  {
      String diedString;
      if (getDeathDate() == null)
          diedString = ""; //Empty string
      else
          diedString = getDeathDate().toString( );
  
      return (getName() + ", " + getBirthDate() + " " + diedString + ", " + social + ", " + salary);
  }

	// main method
	public static void main(String[] args)
	{
	} // end main method

} // end Employee class
