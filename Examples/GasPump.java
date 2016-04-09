/*
 *	Author: Nicholas Warner
 *	Date: 3/23/2015
 *	Filename: GasPump.java
 *	Professor: June Porto
 *	Assignment: Midterm, "Gas Pump Simulation"
 *
 *	Problem: Create a Gas Pump class which simulates the
 *			actions of a gas pump.
 *				- Accept a credit card number
 *				- Assign a transaction ID
 *				- Display the amount of gas dispensed
 *				- Display the amount charged for the amount
 *					dispensed
 *				- Display the cost per gallon
 *				- Reset the amount dispensed and amount charged
 *				- Dispense the fuel
 *				- Stop dispensing the gas
 *
 *	Algorithm:
 *
 *		1. Declare the GasPump Class
 *		2. Declare a constant for one unit of gas
 *		3. Declare necessary instance variables
 *		4. Declare constructors
 *		5. Create Mutator Methods
 *		6. Create Accessor Methods
 *		7. Create Special Methods
 *		8. Create a main Method to begin the program
 *		9. Notify the user of what the program does
 *		10. Reset the pump
 *		11. Request a credit card
 *			- Validate the credit card
 *		12. Pump until they want to stop
 *		13. Show them how much they pumped at cost
 *		14. Write their pump object to the database
 *		15. Repeat steps 10-14 until the user stops
 *		16. Open the database file for analysis
 *		17. Read each object, display to the user, count
 *				the amount of gas and cost
 *		18. Notify the user the database is finished being read
 *		19. Notify the user of the total cost and total gas dispensed
 *
 *
 *
 *	Note on DecimalFormat; the NumberFormat class is actually
 *	preferred for formatting currency
 *
 *	Second note: Don't put your main method in the class itself,
 *				create a tester class / program separately
 *
 */

import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;

public class GasPump implements Serializable {

	// One unit of gas is 1/20 of a gallon
	public static final double ONE_UNIT = 0.05;
	// The Database File
	public static final String DATABASE_FILE = "gasPump.dat";

	// Instance variables
	private String creditCardNumber;
	private int transactionNumber;
	private double gasDispensed;
	private double amountCharged;
	private double costPerGallon;
	
	// Constructors
	public GasPump(double costPerGallon) {
		
		this.costPerGallon = costPerGallon;
		
		creditCardNumber = "";
		transactionNumber = 0;
		gasDispensed = 0.0;
		amountCharged = 0.0;
	}
	
	public GasPump() {
		
		costPerGallon = 5.02;
		creditCardNumber = "";
		transactionNumber = 0;
		gasDispensed = 0.0;
		amountCharged = 0.0;
	}

	// Mutator Methods
	public void setCreditCardNumber(String creditCardNumber) {
		
		this.creditCardNumber = creditCardNumber;
	}
	
	public void setTransactionNumber(int transactionNumber) {
		
		this.transactionNumber = transactionNumber;
	}
	
	public void setGasDispensed(double gasDispensed) {
		
		this.gasDispensed = gasDispensed;
	}
	
	public void setAmountCharged(double amountCharged) {
		
		this.amountCharged = amountCharged;
	}
	
	public void setCostPerGallon(double costPerGallon) {
		
		this.costPerGallon = costPerGallon;
	}
	
	// Accessor Methods
	public String getCreditCardNumber() {
		
		return creditCardNumber;
	}
	
	public int getTransactionNumber() {
		
		return transactionNumber;
	}
	
	public double getGasDispensed() {
		
		return gasDispensed;
	}
	
	public double getAmountCharged() {
		
		return amountCharged;
	}
	
	public double getCostPerGallon() {
		
		return costPerGallon;
	}
	
	// Reset Methods
	public void resetPump(boolean costPerGallonToo) {
		
		creditCardNumber = "";
		transactionNumber = 0;
		gasDispensed = 0.0;
		amountCharged = 0.0;
		
		if (costPerGallonToo) {
			
			costPerGallon = 0.0;
		}
	}
	
	public void resetPump() {
		
		creditCardNumber = "";
		transactionNumber = 0;
		gasDispensed = 0.0;
		amountCharged = 0.0;
		costPerGallon = 0.0;
	}
	
	/* Expected method to be called; transaction count
		remains intact									*/

	public void resetPumpUser() {
		
		creditCardNumber = "";
		gasDispensed = 0.0;
		amountCharged = 0.0;
	}

	// Pump Interaction Methods
	public void incrementPumpOnce() {
		
		gasDispensed += ONE_UNIT;
		amountCharged = gasDispensed * costPerGallon;
	}
	
	public double calculateCost() {
		
		return (gasDispensed * costPerGallon);
	}
	
	public void readyPump() {
		
		resetPumpUser();
		transactionNumber++;
	}
	
	// toString method
	public String toString() {
		
		DecimalFormat df = new DecimalFormat("#.00");
		String output = "";
		
		output += "Cost per Gallon: " + costPerGallon + "\n";
		output += "Current Transaction Number: " +
						transactionNumber + "\n";
		output += "Amount of Dispensed Gas: " +
					df.format(gasDispensed) + " gallons\n";
		output += "Charge for Gas Dispensed: $" +
					df.format(amountCharged) + "\n";
		output += "Charged to Credit Card: ####-" +
					creditCardNumber.substring(5);
		
		return output;
	}
	
	// equals method
	public boolean equals(GasPump pump) {
		
		if (this.toString().equals(pump.toString())) {
			
			return true;
		}
		
		return false;
	}
	
	public boolean testValidCreditCard(String card) {
		
		boolean goodCard = true;
		
		// Should already be trimmed, but let's be cautious
		card = card.trim();
		
		// Must be 9 characters in length
		if (card.length() == 9) {

			// Must have a hyphen in the middle
			if (card.charAt(4) == '-') {
				
				// Check that each character is a number
				for(int i = 0; i < card.length(); i++) {
					
					if (i != 4) {
						
						// If it's outside of 0-9, no good
						if (card.charAt(i) < '0' ||
							card.charAt(i) > '9') {
							
							goodCard = false;
						}
					}
				}
			}
			
			// No Hyphen
			else {
				
				goodCard = false;
			}			
		}
		
		// Length != 9
		else {
			
			goodCard = false;
		}
		
		return goodCard;
	}

	// Don't do this! Make a separate tester class
	public static void main(String[] args) {
		
		// Make it pretty
		DecimalFormat df = new DecimalFormat("#.00");
		
		// Our Gas Pump!
		GasPump pump = new GasPump();

		// Make sure the user gives us valid credit card info
		boolean badCreditCardInfo = true;
		// Loop to keep pumping
		boolean keepPumping = true;
		// Main Control loop
		boolean keepGoing = true;
		
		// First Write
		boolean firstWrite = true;

		// User Input Management
		Scanner keyboard = new Scanner(System.in);
		String userInput = "";
		
		double totalGallons = 0.0;
		double totalCost = 0.0;
		
		// Greeting
		System.out.println("Welcome to the Gas Pump Simulator.");
		System.out.println("This simulator will ask for information");
		System.out.println("regarding gas transactions. Please input");
		System.out.println("the desired information.");

		// Main Loop
		while(keepGoing) {

			// Clean up from the last time, prepare for next
			pump.readyPump();
	
			// Reset our loop condition
			badCreditCardInfo = true;

			// Keep looping until we get valid credit card info	
			while(badCreditCardInfo) {
	
				// Request the credit card
				System.out.print("Please insert your credit card: ");
			
				// Try catch if malformed credit card is input
				try {
					
					userInput = keyboard.nextLine().trim();
					
					// Test if it's the valid format, ####-####
					if (pump.testValidCreditCard(userInput)) {
						
						pump.setCreditCardNumber(userInput);
						badCreditCardInfo = false;
					}
					
					// If it isn't, throw the exception
					else {
						
						throw new BadCreditCardException();
					}
				}
				
				// The exception notifies the user what they did wrong
				catch (BadCreditCardException e) {
					
					System.out.println(e.getMessage());
					System.out.println("Please try again.");
				}		
			}
			
			// Reset our loop condition
			keepPumping = true;
			
			// Keep pumping until they input a 'q'
			while(keepPumping) {
				
				// Notify the user of how much they've pumped
				System.out.println("Pumped: " + 
									df.format(pump.getGasDispensed()) +
									" gallons for $" + 
									df.format(pump.getAmountCharged()));
									
				System.out.print("Press ENTER to simulate more pumping! " +
									"(q to quit)");
									
				// Grab their input, trim out spaces, ensure lower case
				userInput = keyboard.nextLine().trim().toLowerCase();
				
				// They decided to quit
				if (userInput.length() > 0 && userInput.charAt(0) == 'q') {
					
					keepPumping = false;
				}
				
				// They didn't quit
				else {
					
					pump.incrementPumpOnce();
				}
			}
			
			// Notify the user how much they've pumped, cost, etc.
			System.out.println(pump.toString());
			
			// First time we write to file, we don't append
			if (firstWrite) {
				
				// Try to open the file and write
				try {
					
					ObjectOutputStream outputFile =
						new ObjectOutputStream(
							new FileOutputStream(DATABASE_FILE));
					
					// Write the object to file
					outputFile.writeObject(pump);
					// Future writes, we'll use AppendObject
					firstWrite = false;
					
					// Always close our file!
					outputFile.close();
				}
				
				// Catch anything that went wrong
				catch(FileNotFoundException e) {
					
					System.out.println("Unable to open the database. Exiting...");
					System.exit(0);
				}
				
				catch(IOException e) {
					
					System.out.println("Unable to write to the database.");
					System.out.println("Exiting...");
					System.exit(0);
				}
			}
			
			// Not the first time we write to file, file exists, so we append
			else {
				
				// Try to open the file and append
				try {
					
					AppendObjectOutputStream outputFile =
						new AppendObjectOutputStream(
							new FileOutputStream(DATABASE_FILE, true));

					// Append the object to the file					
					outputFile.writeObject(pump);
					
					// Always close our file!
					outputFile.close();
				}

				// Catch anything that went wrong				
				catch (FileNotFoundException e) {
					
					System.out.println("Unable to open the database. Exiting...");
					System.exit(0);
				}
				
				catch (IOException e) {
					
					System.out.println("Unable to write to the database.");
					System.out.println("Exiting...");
					System.exit(0);
				}
			}

			// Ask the user if there will be another pump transaction			
			System.out.print("Continue with another transaction (y/n)? ");
			
			userInput = keyboard.nextLine().trim().toLowerCase();
			
			// If the user didn't say yes, we're done
			if (userInput.length() > 0 && userInput.charAt(0) != 'y') {
				
				// We change our condition to break out of the loop
				keepGoing = false;
				// Notify the user we're done
				System.out.println("Finished with transactions and writing to");
				System.out.println("the database file.");
			}

		} // keepGoing
		
		// Notify the user what we're doing
		System.out.println("Beginning Database Analysis!");
		
		// Try to open the file for reading
		try {
			
			ObjectInputStream inputFile = new ObjectInputStream(
											new FileInputStream(DATABASE_FILE));
			
			// Try to read every object from the file
			try {

				while(true) {
					
					GasPump onePump = (GasPump) inputFile.readObject();
					totalGallons += onePump.getGasDispensed();
					totalCost += onePump.getAmountCharged();
					System.out.println(onePump.toString());
				}	
			}
			
			// Catch our (E)nd (O)f (F)ile exception
			catch (EOFException e) {
			
				System.out.println("Finished analyzing the database.");
			}

			// Always close our file!
			inputFile.close();		
		}

		// Catch anything that went wrong
		catch (FileNotFoundException e) {
			
			System.out.println("Unable to open the database. Exiting...");
			System.exit(0);
		}

		catch (ClassNotFoundException e) {
			
			System.out.println("Issue with reading from the database.");
			System.out.println("Exiting...");			
			System.exit(0);
		}
					
		catch (IOException e) {
			
			System.out.println("Issue with reading from the database.");
			System.out.println("Exiting...");
			System.exit(0);			
		}

		// Notify the user of the total gas dispensed and funds collected		
		System.out.println("\n\tTotal Gas Dispensed: " + 
								df.format(totalGallons) + " gallons");
		System.out.println("\tTotal Cost of Gas Dispensed: $" + 
								df.format(totalCost));
	}
}