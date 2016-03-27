/*
Chapter No. 10 - Exercise No. 11
File Name:          TrackPeople.java
Programmer:         Durell Smith
Date Last Modified: February 9, 2016

Problem Statement:
*/

// imports
import java.util.Scanner;
import java.io.*;

public class TrackPeople implements Serializable
{
	// main method
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		Date today = new Date();
		today.readInput(); // determine current day to determine ages
		String response = "";
		boolean done = false;

		File checkNew = new File("People.txt");
		if(!checkNew.exists())
		{
			try
			{
				ObjectOutputStream test = new ObjectOutputStream(new FileOutputStream("People.txt"));
				test.close();
			}
			catch (IOException e)
			{
				System.out.println("Something went wrong!");
			}
		}

		while (!done)
		{
			System.out.println("What would you like to do next?");
			System.out.println("Add Record, Delete Record, Get Person, Get People or Quit");
			response = keyboard.nextLine();
			String[] command = response.split(" ");

			// Add a Person to the record
			if (command[0].toLowerCase().charAt(0) == 'a')
			{
				System.out.println("Please give me the name of person you'd like to add");
				String name = keyboard.nextLine();
				Date birth = new Date();
				birth.readInput();
				Date death = null;
				Person addThis = new Person(name, birth, death);
				AppendObjectOutputStream output;
				try
				{
					output = new AppendObjectOutputStream(new FileOutputStream("People.txt", true));
					output.writeObject(addThis);
				}
				catch(IOException e)
				{
					System.out.println("Problem adding " + addThis.getName());
				}
        output.close();
			}
			else if (command[0].toLowerCase().charAt(0) == 'd')
			{
				System.out.println("Please give me the name of the person you'd like to remove.");
				String name = keyboard.nextLine();
				// 
				ObjectInputStream inStream;
				ObjectOutputStream outStream;
				try
				{
					inStream = new ObjectInputStream(new FileInputStream("People.txt"));
					try
					{
						while (true)
						{
							Person checkPerson = (Person)inStream.readObject();
							if (check.getName().equals(name));
							{
								System.out.println(checkPerson);
							}
						}
					}
					catch(EOFException e)
					{
						System.out.println("Reached end of records.");
					}
					inStream.close();
				}
				catch(ClassNotFoundException e)
				{
					System.out.println("Class not found.");
				}
				catch(IOException e)
				{
					System.out.println("Problem opening file");

				}
			}
			else if (command[0].toLowerCase().charAt(0) == 'g' && command[1].toLowerCase().equals("person"))
			{
				System.out.println("Please give me the name on the record you'd like to retrieve.");
				String name = keyboard.nextLine();
				ObjectInputStream inStream;
				ObjectOutputStream outStream;
				try
				{

          // I need to find a way to write:
          // if inStream.getName() != name
          //   outStream.writeObject(inputStream's object)
          // else
          //   don't writeObject
          
          inStream = new ObjectInputStream(new FileInputStream("People.txt"));
          outStream = new ObjectOutputStream(new FileOutputStream("People.txt"));
					while(true)
					{
						Person checkPerson = (Person)inStream.readObject();
						if (check.getName().equals(name))
						{
							System.out.println(checkPerson);
						}
					}
				}
				catch (EOFException e)
				{
					System.out.println("Reached end of file");
				}
				inStream.close();
			}
			else if (command[0].toLowerCase().charAt(0) == 'g' && command[1].toLowerCase().equals("people"))
			{
				System.out.println("I'll retrieve people within an age range.");
				System.out.println("What is the youngest age you'd like to retrieve?");
				int youngest = keyboard.nextInt();
				System.out.println("What is the youngest age you'd like to retrieve?");
				int oldest = keyboard.nextInt();
				ObjectInputStream inStream;
				Date minDate = new Date(today);
				oldest = minDate.getYear() - oldest;
				minDate.setYear(oldest);
				Date maxDate = new Date(today);
				youngest = maxDate.getYear() - youngest;
				maxDate.setYear(youngest);
				try
				{
					inStream = new ObjectInputStream(new FileInputStream("People.txt"));
					try
					{
						while(true)
						{
							Person check = (Person)inStream.readObject();
							if ( !check.getBirthDate().precedes(minDate) && check.getBirthDate().precedes(maxDate) )
							{
								System.out.println(check);
							}
						}
					}
					catch (EOFException e)
					{
						System.out.println("Reached end of file");
					}
          inStream.close();
				}
				catch(ClassNotFoundException e)
				{
					System.out.println("Class not found.");
				}
				catch(IOException e)
				{
					System.out.println("Problem opening file");

				}
			}
			else if (command[0].toLowerCase().charAt(0) == 'q')
			{
				System.exit(0);
			}

		}
	} // end main method
} // end TrackPeople class
