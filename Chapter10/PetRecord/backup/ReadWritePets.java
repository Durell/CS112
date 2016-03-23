/*
Chapter No. 10 - Handout 2 Project 2
File Name:          ReadWritePets.java
Programmer:         Durell Smith
Date Last Modified: February 9, 2016

Problem Statement:
Write a program that allows user to write and read records
of type PetRecord to or from a file they specify.

Classes needed and Purpose:
main class - ReadWritePets
*/

// imports
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.IOException;
import java.io.EOFException;
import java.io.Serializable;

public class ReadWritePets implements Serializable
{

  public static void main(String[] args)
  {
    boolean done = false;
    Scanner keyboard = new Scanner(System.in);
    String userResponse = "";
    String fileName = "";

    // keep going until user requests to exit
    System.out.print("Hi, I can write and read PetRecords to/from a file.");
    while (!done)
    {
      System.out.println("Would you like to read from a file or write to a file?");
      System.out.println("Enter r to read, w to write or q to quit.");
      userResponse = keyboard.nextLine();

      // if they want to write a file
      if (userResponse.trim().toLowerCase().equals("w"))
      {
        System.out.print("Please give me the text file name. > ");
        userResponse = keyboard.nextLine();
        File fileObject = new File(userResponse);
        boolean append = false;
        // if the file already exists, ask if they want to add to it or overwrite
        if (fileObject.exists())
        {
          System.out.println("File already exists. Append or overwrite file?");
          System.out.print("To append enter 'a'. To overwrite enter 'o'. > ");
          userResponse = keyboard.nextLine();
          append = userResponse.trim().toLowerCase().equals("a");
          System.out.println("confirm two lines print");
        }
          System.out.println("if 'a' was selected, this should state TRUE!!! > " + append);
          System.out.println("otherwise should be false: > " + append);
        // now we're ready to open the file
        ObjectOutputStream outputStream;
        try
        {
          outputStream = new ObjectOutputStream(new FileOutputStream(fileObject, append));
          boolean doneAdding = false;
          while (!doneAdding)
          {
            System.out.println("Please give me the pet's name.");
            String name = keyboard.nextLine();
            System.out.println("What is the age of the pet?");
            int age = keyboard.nextInt();
            keyboard.nextLine();
            System.out.println("How much does it weigh?");
            double weight = keyboard.nextDouble();
            keyboard.nextLine();
            PetRecord addPet = new PetRecord(name, age, weight);
            System.out.println(addPet);
            outputStream.writeObject(addPet);
            System.out.println("Would you like to add another (y/n)?");
            name = keyboard.nextLine();
            if (name.trim().toLowerCase().equals("n"))
              doneAdding = true;
          }
          fileName = fileObject.getName();
          outputStream.close();
        }
        catch(IOException e)
        {
          System.out.println("File " + userResponse + " was not found");
          System.out.println("or could not be opened");
          System.exit(0);
        }
        // we need a String name, int age, and double weight
      }

      // if they want to read a file
      else if (userResponse.trim().toLowerCase().equals("r"))
      {
        System.out.print("Please give me the text file name. > ");
        userResponse = keyboard.nextLine();
        // make sure the file exists since we want to read
        File fileObject = new File(userResponse);
        while (!fileObject.exists())
        {
          System.out.println("No file named: " + userResponse);
          System.out.println("Please give me a valid file name: ");
          userResponse = keyboard.nextLine();
          fileObject = new File(userResponse);
        }
        ObjectInputStream inputStream;
        try
        {
          inputStream = new ObjectInputStream(new FileInputStream(userResponse));
          System.out.println("Reading from " + userResponse);
          try
          {
            while (true)
            {
              PetRecord pet = (PetRecord)inputStream.readObject();
              System.out.println(pet);
            }
          }
          catch(EOFException e)
          {
          System.out.println("No more numbers in the file.");
          }
          inputStream.close();
        }
        catch(ClassNotFoundException e)
        {
          System.out.println("class not found");
        }
        catch(FileNotFoundException e)
        {
        System.out.println("Cannot find file numbers.dat.");
        }
        catch(IOException e)
        {
        System.out.println("Problem with input from file numbers.dat.");
        }
      }
      else if (userResponse.trim().toLowerCase().equals("q"))
        done = true;
    }
    // STEP 2:
    ObjectInputStream inputStream;
    try
    {
      int youngest = 10000;
      double smallest = 10000;
      inputStream = new ObjectInputStream(new FileInputStream(fileName));
      System.out.println("Reading from " + userResponse);
      PetRecord largestPet = new PetRecord("");
      PetRecord smallestPet = new PetRecord(10000.0);
      PetRecord oldestPet = new PetRecord("al"); 
      PetRecord youngestPet = new PetRecord(1000);
      try
      {
        while (true)
        {
          PetRecord pet = (PetRecord)inputStream.readObject();
          if (pet.getWeight() > largestPet.getWeight())
            largestPet = pet.clone();
          if (pet.getWeight() < smallestPet.getWeight())
            smallestPet = pet.clone();
          if (pet.getAge() > oldestPet.getAge())
            oldestPet = pet.clone();
          if (pet.getAge() < youngestPet.getAge())
            youngestPet = pet.clone();
        }
      }
      catch(EOFException e)
      {
      System.out.println("No more numbers in the file.");
      }
    System.out.println("The oldest pet is: " + oldestPet);
    System.out.println("The youngest pet is: " + youngestPet);
    System.out.println("The largest pet is: " + largestPet);
    System.out.println("The smallest pet is: " + smallestPet);
      inputStream.close();
    }
    catch(ClassNotFoundException e)
    {
      System.out.println("class not found");
    }
    catch(FileNotFoundException e)
    {
    System.out.println("Cannot find file " + userResponse);
    }
    catch(IOException e)
    {
    System.out.println("Problem with input from file numbers.dat.");
    }




  } // end main() method
} // end ReadWritePets class
