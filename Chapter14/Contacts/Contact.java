/*
Chapter No. 14 - Project 2 (Page 799)
File Name:          Contact.java
Programmer:         Durell Smith
Date Last Modified: April x, 2016

Problem Statement:
Write a program that uses an ArrayList of parameter type Contact to store a
database of contacts. 

*/

// imports
import java.util.ArrayList;
import java.util.Scanner;

public class Contact
{

	String firstName, lastName, email, phoneNum;

	public Contact(String first, String last, String e, String phone)
	{
		firstName = first;
		lastName = last;
		email = e;
		phoneNum = phone;
	}

	public String getFirst()
	{
		return firstName;
	}

	public String getLast()
	{
		return lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public String getPhone()
	{
		return phoneNum;
	}

	public String toString()
	{
		return firstName + " " + lastName + "\n" + 
						"email: " + email + "\n" +
						"phone: " + phoneNum;
	}

  public static void main(String[] args)
  {
  	Scanner input = new Scanner(System.in);
  	ArrayList<Contact> contacts = new ArrayList<Contact>(0);
  	System.out.println("Hello, I store contacts.");
  	boolean done = false;

  	while(!done)
  	{
	  	try
  		{
  			System.out.println("What would you like to do?");
  			System.out.println("Add Contact (add)");
  			System.out.println("Display all Contacts (display)");
  			System.out.println("Find and display matching contacts (find)");
  			System.out.println("Find and delete a contact (delete)");
  			System.out.println("Quit (q)");
  			System.out.print("> ");
  			String command = input.nextLine();
  			if (command.toLowerCase().charAt(0) == 'a')
  			{
  				System.out.println("Please give me the first name:");
  				String fn = input.nextLine();
  				System.out.println("Please give me the last name:");
  				String ln = input.nextLine();
  				System.out.println("Please give me an email:");
  				String e = input.nextLine();
  				System.out.println("Please give me a phone number:");
  				String p = input.nextLine();
  				contacts.add(new Contact(fn, ln, e, p));
  			}
  			else if (command.toLowerCase().contains("dis"))
  			{
  				int count = 1;
  				System.out.println("----------");
  				for (Contact index : contacts)
  				{
  					System.out.println("#" + count + ":");
  					System.out.println(index);
	  				System.out.println("----------");
  					count++;
  				}
  			}
  			else if (command.substring(0,1).equalsIgnoreCase("f"))
  			{
  				System.out.println("Please give me a string to search for.");
  				String find = input.nextLine();
  				boolean displayed = false;
  				System.out.println("----------");
  				for (Contact index : contacts)
  				{
  					if (index.toString().contains(find))
  					{
  						System.out.println(index);
		  				System.out.println("----------");
  						displayed = true;
  					}
  				}
  				if (!displayed)
  				{
  					System.out.println("No matching contact found.");
  					System.out.println("----------");
  				}
  			}
  			else if (command.toLowerCase().contains("del"))
  			{
  				System.out.println("Please give me a string to search for.");
  				String find = input.nextLine();
  				int count = 0;
  				for (Contact index : contacts)
  				{
  					if (index.toString().contains(find))
  					{
  						System.out.println("Delete " + index.getFirst() + " " + index.getLast() + "? (y/n)");
  						String ans = input.nextLine();
		  				System.out.println("----------");
  						if (ans.toLowerCase().substring(0,1).equals("y"))
  							{
  								contacts.remove(count);
  								System.out.println("Contact Removed!");
  							}
  						else
  							System.out.println("Contact not deleted.");
  					}
  					count++;
  				}
  				System.out.println("----------");
  			}
  			else if (command.substring(0,1).equalsIgnoreCase("q"))
  			{
  				done = true;
  			}
  			else
  				System.out.println("--Did not understand input--");
  		}
  		catch (StringIndexOutOfBoundsException e)
  		{
  			System.out.println("----------");
  			System.out.println("No input received, try again.");
  			System.out.println("----------");
  		}
/* copy/paste to expedite testing:
a
bill
li
bli@b
33333333
a
jill
la
jla@j
4839392392
*/
  	}
  }
}
