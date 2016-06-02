// The Greeting Panel class is a specialized JPanel class. It displays a
// greeting for the application window.

import javax.swing.*;

public class GreetingPanel extends JPanel
{
	// Constructor
	public GreetingPanel()
	{
		// Create the label and add to this panel
		JLabel greeting = new JLabel("Welcome to Brandi's Bagel House");
		add(greeting);
	}
}