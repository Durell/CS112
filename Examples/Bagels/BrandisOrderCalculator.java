// The BrandisOrderCalculator class creates the GUI for Brandi's
// Bagel House application.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class BrandisOrderCalculator extends JFrame
{
	// The following constant is for the sales tax rate.
	private final double TAX_RATE = 0.085;
	
	// The following variables will reference the custom panel objects.
	private BagelPanel bagels;
	private ToppingPanel toppings;
	private CoffeePanel coffee;
	private GreetingPanel message;
	
	// The following variables will reference objects, the button 
	// panel and the Calculate and Exit buttons.
	private JPanel buttonPanel;        // To hold the buttons
	private JButton calcButton;        // To calculate the total cost
	private JButton exitButton;        // To exit the application
	
	// Constructor
	public BrandisOrderCalculator()
	{
		// Display a title, action for close button
		super("Brandi's Order Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create a BorderLayout manager for the content pane
		setLayout(new BorderLayout());
		
		// Create the custom panels
		message = new GreetingPanel();
		bagels = new BagelPanel();
		toppings = new ToppingPanel();
		coffee = new CoffeePanel();
		
		// Call the buildButtonPanel method to create the button panel
		buildButtonPanel();
		
		// Add the components to the content pane
		add(message, BorderLayout.NORTH);
		add(bagels, BorderLayout.WEST);
		add(toppings, BorderLayout.CENTER);
		add(coffee, BorderLayout.EAST);
		add(buttonPanel, BorderLayout.SOUTH);
		
		// Pack the contents of the window and display it.
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	// The buildButtonPanel method builds the button panel.
	private void buildButtonPanel()
	{
		// Create a panel for the buttons
		buttonPanel = new JPanel();
		
		// Create the buttons
		calcButton = new JButton("Calculate");
		exitButton = new JButton("Exit");
		
		// Register the action Listeners
		calcButton.addActionListener(new CalcButtonListener());
		exitButton.addActionListener(new ExitButtonListener());
		
		// Add the buttons to the button panel
		buttonPanel.add(calcButton);
		buttonPanel.add(exitButton);
	}
	
	// Private inner class that handles the event when the user
	// clicks the Calculate button.
	private class CalcButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			double subtotal;        // The order subtotal
			double tax;             // The amount of sales tax
			double total;           // The order total
			
			// Calculate the subtotal, sales tax, and total bill
			subtotal = bagels.getBagelCost() +
			           toppings.getToppingCost() +
			           coffee.getCoffeeCost();
			           
			tax = subtotal * TAX_RATE;
			
			total = subtotal + tax;
			
			// Create a DecimalFormat object to format the total
			// as a dollar amount
			DecimalFormat dollar = new DecimalFormat("0.00");
			
			// Display the charges
			JOptionPane.showMessageDialog(null, "Subtotal: $" +
			            dollar.format(subtotal) + "\n" +
			            "Tax: $" + dollar.format(tax) + "\n" +
			            "Total: $" + dollar.format(total));
		}
	}	
		
	// Private inner class that handles the event when the user
	// clicks the Exit button.	
	private class ExitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// Exit the application
			System.exit(0);
		}
	}
}