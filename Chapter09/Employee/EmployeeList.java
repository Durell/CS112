/*
Chapter No. 8 - Exercise No. ???
File Name:          EmployeeList.java
Programmer:         Durell Smith
Date Last Modified: February 9, 2016
*/

// imports
import java.util.Scanner;
import java.util.InputMismatchException;

public class EmployeeList
{
	// variables
	private Employee[] employees;
	private int numEmployees, empAdded;

	/**
	* Default Constructor
	*/
	public EmployeeList()
	{
		numEmployees = 100;
		employees = new Employee[numEmployees];
		empAdded = 0;
	}

	public EmployeeList(int n)
	{
		employees = new Employee[n];
		empAdded = 0;
	}

	public void addEmployee(Employee e)
	{
		employees[empAdded] = e;
		empAdded++;
	}

	public void printArray()
	{
		String a = "";
		for (int i = 0; i < employees.length; i++)
		{
			a += employees[i];
		}

	}

    public static boolean isInteger(String s) 
    {
      boolean isValidInteger = false;
      try
      {
         Integer.parseInt(s);
 
         // s is a valid integer
 
         isValidInteger = true;
      }
      catch (NumberFormatException ex)
      {
         // s is not an integer
      }
 
      return isValidInteger;
    }

	public String toString()
	{
		String arrString = "";
		for (int i = 0; i < empAdded; i++)
		{
			arrString += employees[i].toString() + "\n";
		}
		return arrString;
	}

	// accessor and mutator methods

	// main method
	public static void main(String[] args)
	{
	/*
    // debugging
		EmployeeList list = new EmployeeList(10);
		Date bobBirth = new Date(4, 20, 1999);
		Employee bob = new Employee("Bob", bobBirth, 1111111111, 42000);
		list.addEmployee(bob);
		System.out.println(list);
		*/

    // begin program
    Scanner k = new Scanner(System.in);
	boolean done = false;
    System.out.println("I will add employee data to a list.");
    System.out.print("How many employees would you like to add (limit 10) ? > ");
    int n = k.nextInt();
    k.nextLine();
    EmployeeList list1 = new EmployeeList(n);
    while (!done)
    {
    	String name;
    	Date birth = new Date();
    	double sal = 0;
    	String ssString = "";
        int ssInt = 0;
    	System.out.println("Okay, give me info for the next employee.");
    	System.out.print("First give me the name. > ");
    	name = k.nextLine();
    	birth.readInput();
    	System.out.println(birth);
    	boolean done1 = false;
    	while (!done1)
    	{
    		try
    		{
	    		System.out.print("Next please input social security without dashes or spaces. > ");
    			ssString = k.nextLine();
                boolean num = isInteger(ssString);
    			if (!num)
    			{
    				throw new SSNCharacterException();
    			}
                else
                    ssInt = Integer.parseInt(ssString);

    			if (ssInt < 100000000)
    			{
    				throw new SSNLengthException("Not enough numbers!");
    			}
                else if (ssInt > 999999999)
                {
                    throw new SSNLengthException("Too many numbers!");
                }
    			else 
    				done1 = true;
    		}
            catch (SSNCharacterException e)
            {
                System.out.println("Entry contained a symbol!");
            }
    		catch (SSNLengthException e)
    		{
    			System.out.println(e.getMessage());
    		}
    	}
    	System.out.print("Please give me " + name + "'s salary. > ");
    	sal = k.nextDouble();
    	k.nextLine();
    	Employee empl = new Employee(name, birth, ssInt, sal);
    	list1.addEmployee(empl);
    	System.out.print("Continue? (y/n) > ");
    	name = k.nextLine();
    	if (name.toLowerCase().equals("n"))
    		done = true;
    }
    System.out.print(list1);

	} // end main method

} // end EmployeeList class
