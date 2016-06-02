// The ToppingPanel class allows the user to select the toppings
// for the bagel.

import java.awt.*;
import javax.swing.*;

public class ToppingPanel extends JPanel
{
	// The following constants are used to indicate the cost of 
	// the toppings.
	public final double CREAM_CHEESE = 0.50;
	public final double BUTTER = 0.25;
	public final double GUAVA_JELLY = 0.75;
	public final double STRAWBERRY_JAM = 0.75;

	// Checkboxes for the available toppings
	private JCheckBox creamCheese;
	private JCheckBox butter;
	private JCheckBox guavaJelly;
	private JCheckBox strawberryJam;

	//Constructor
	public ToppingPanel()
	{
		// Create a GridLayout manager with four rows and one column
		setLayout(new GridLayout(4, 1));
	
		// Create the check boxes
		creamCheese = new JCheckBox("Cream Cheese");
		butter = new JCheckBox("Butter");
		guavaJelly = new JCheckBox("Guava Jelly");
		strawberryJam = new JCheckBox("Strawberry Jam");
		
		// Add a border around the panel
		setBorder(BorderFactory.createTitledBorder("Toppings"));
		
		// Add check boxes to this panel
		add(creamCheese);
		add(butter);
		add(guavaJelly);
		add(strawberryJam);
	}
	
	// The getToppingCost method returns the cost of the selected toppings
	public double getToppingCost()
	{
		// The following variable will hold the cost of the selected topping
		double toppingCost = 0.0;
		
		// Determine which of the toppings are selected.
		// More than one may be selected.
		if (creamCheese.isSelected())
		    toppingCost += CREAM_CHEESE;
		if (butter.isSelected())
		    toppingCost += BUTTER;
		if (guavaJelly.isSelected())
		    toppingCost += GUAVA_JELLY;
		if (strawberryJam.isSelected())
		    toppingCost += STRAWBERRY_JAM;
		    
		// Return the topping cost.
		return toppingCost;
	}
} 