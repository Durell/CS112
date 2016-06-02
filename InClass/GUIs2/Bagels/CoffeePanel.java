// The CoffeePanel class allows the user to select a type of coffee.

import java.awt.*;
import javax.swing.*;

public class CoffeePanel extends JPanel
{
	// The following constants are used to indicate the cost of 
	// the coffee.
	public final double NO_COFFEE = 0.0;
	public final double REG_COFFEE = 1.25;
	public final double DECAF_COFFEE = 1.25;
	public final double CAPPUCCINO = 2.00;

	// The following variables will reference radio buttons for the 
	// available coffee
	private JRadioButton noCoffee;
	private JRadioButton regCoffee;
	private JRadioButton decafCoffee;
	private JRadioButton cappuccino;
	

	// The following variable will reference a ButtonGroup object to group
	// the radio buttons.
	private ButtonGroup bg;

	//Constructor
	public CoffeePanel()
	{
		// Create a GridLayout manager with four rows and one column
		setLayout(new GridLayout(4, 1));
	
		// Create the radio buttons
		noCoffee = new JRadioButton("None");
		regCoffee = new JRadioButton("Regular Coffee", true);
		decafCoffee = new JRadioButton("Decaf Coffee");
		cappuccino = new JRadioButton("Cappuccino");
		
		// Group the radio buttons
		bg = new ButtonGroup();
		bg.add(noCoffee);
		bg.add(regCoffee);
		bg.add(decafCoffee);
		bg.add(cappuccino);
		
		// Add a border around the panel
		setBorder(BorderFactory.createTitledBorder("Coffee"));
		
		// Add radio buttons to this panel
		add(noCoffee);
		add(regCoffee);
		add(decafCoffee);
		add(cappuccino);
	}
	
	// The getCoffeeCost method returns the cost of the selected coffee
	public double getCoffeeCost()
	{
		// The following variable will hold the cost of the selected coffee
		double coffeeCost = 0.0;
		
		// Determine which of the coffees is selected.
		// Only one may be selected.
		if (noCoffee.isSelected())
		    coffeeCost += NO_COFFEE;
		else if (regCoffee.isSelected())
		    coffeeCost += REG_COFFEE;
		else if (decafCoffee.isSelected())
		    coffeeCost += DECAF_COFFEE;
		else if (cappuccino.isSelected())
		    coffeeCost += CAPPUCCINO;
		    
		// Return the coffee cost.
		return coffeeCost;
	}
} 