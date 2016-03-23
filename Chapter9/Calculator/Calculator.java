/*
Chapter No. 9 - Exercise No. 6 (Page 575)
File Name:          Calculator.java
Programmer:         Durell Smith
Date Last Modified: February 9, 2016

Problem Statement:
Write a simple calculator program that will keep track of a single
number and let the user continue to operate on the number until results
are resquested. Will check if operator is either '*', '/', '+', '-',
if not the user is asked to reenter their last line (hopefully corrected).


Overall Plan:
1. 

Classes needed and Purpose:
main class - Calculator
*/

// imports
import java.util.Scanner;

public class Calculator
{
	// variables
	private double result;

	/**
	* Default Constructor
	*/
	public Calculator()
	{
		result = 0.0;
		System.out.println("Calculator is on.");
	}

	// accessor and mutator methods
	public double getResult()
	{
		return result;
	}

	public void reset()
	{
		result = 0.0;
	}

	public void calculate(char oper, double num)
	{
		// need to implement an input system to receive an operator and a number
		// let op be the variable assigned to the operator
		// let num be the number to be operated by
		// also need the try-catch to check for correct operator
		try
		{
			if (oper == '/' && num != 0)
			{
				result /= num;
			}
			else if (oper == '/' && num == 0)
			{
				System.out.println("Dividing by 0 is undefined!");
			}
			else if (oper == '*')
			{
				result *= num;
			}
			else if (oper == '+')
			{
				result += num;
			}
			else if (oper == '-')
			{
				result -= num;
			}
			else
				throw new UnknownOperatorError(oper);
		}
		catch(UnknownOperatorError e)
		{
			System.out.println(e.getMessage());
			System.out.println("Please try again with either '/', '*', '+', or '-' :");
		}
	}


	// main method
	public static void main(String[] args)
	{
		// declare variables
		Scanner darkly = new Scanner(System.in); // to get input from user
		Calculator calc = new Calculator(); // create a calculator object to use
		char op = 'x'; // char to store operator in
		double n = 0; // double to store the number to be operated with
		boolean repeat = true;

		// input
		while(repeat)
		{
			System.out.println("result = " + calc.getResult());
			String l = darkly.nextLine();
	
			// processing
			// if statement after trim().toLowerCase() to check if user is requesting result
			l = l.trim();
			if (l.toLowerCase().equals("r"))
			{
				String again;
				System.out.println("Final result = " + calc.getResult());
				calc.reset();
				System.out.println("Again? (y/n)");
				again = darkly.nextLine();
				if (again.toLowerCase().equals("n"))
					repeat = false;
			}
			else
			{
				op = l.charAt(0);
				l = l.substring(1).trim();
				n = Double.parseDouble(l);
				System.out.println(n);
				calc.calculate(op, n);
			}
	
			// output
			System.out.println("result " + op + " " + n + " = " + calc.getResult());
			System.out.println("updated result = " + calc.getResult());
		}

	} // end main method

} // end Calculator class
