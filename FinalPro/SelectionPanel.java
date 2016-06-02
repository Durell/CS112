// Panel to allow users to select which deck to
// study out of decks added, or create a new one

import javax.swing.*;
import java.awt.*;

public class SelectionPanel extends JPanel
{

	public JLabel deckName;
	public JLabel options;
	public JPanel deckPanel;
	public static ArrayList<String> deckNames;
	// need to store list of decks somewhere
	// Let's make deck an object 

	public SelectionPanel()
	{
		options = new JLabel("Options");
		// Need a for loop to add menu items. 
		// Swing must have an api for this!!!
		deckPanel = new JPanel();
		deckPanel.setLayout(new GridLayout(0,2));
		JButton study;
		study = new JButton("Study");
		for (String s : deckNames)
		{
			add(s);
			add(new JButton("Advanced"));
		}

		add(options);

	}
}