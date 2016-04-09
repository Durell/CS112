/*
 *	Author: Nicholas Warner
 *	Date: 3/23/2015
 *	Filename: BadCreditCardException.java
 *	Professor: June Porto
 *	Assignment: Midterm, "Gas Pump Simulation"
 *
 *	Problem: Create an Exception Class to Manage Bad
 *				Credit Card value exceptions
 *
 *	Algorithm: Create the Exception Class.
 */

public class BadCreditCardException extends Exception {
	
	public BadCreditCardException() {
		
		super("Invalid Credit Card Information! Must be ####-####");
	}
	
	public BadCreditCardException(String msg) {
		
		super(msg);
	}	
}