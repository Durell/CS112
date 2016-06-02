// Greeting panel will greet user upon login
// Should ideally only appear on new login

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;


public class GreetingPanel extends JPanel
{

	public final String greeting = "Welcome to Flashy";

	private JButton enter;
	private JLabel uname; // username
	private JPanel decksPanel;
	private JPanel buttonPanel;
	private JLabel test;
	public static Vector<String> deckNames;
	public JList<String> decksList;

	public GreetingPanel()
	{
		setLayout(new BorderLayout());
		enter = new JButton("Enter");
		deckNames = new Vector<String>();
		deckNames.add("success!");
		deckNames.add("doubld!");
		uname = new JLabel();
		decksPanel = new JPanel();
		decksPanel.setLayout(new BoxLayout(decksPanel, BoxLayout.Y_AXIS));
		decksPanel.setBorder(BorderFactory.createEmptyBorder(30,0,15,0));
		showDecks();
		add(decksPanel, BorderLayout.CENTER);
		add(enter, BorderLayout.SOUTH);
		setVisible(true);
	}

	public void addDeck(String name)
	{
		deckNames.add(name);
	}

	public void showDecks()
	{
		decksList = new JList<String>(deckNames);
		ListModel<String> model = decksList.getModel();
 		for(int i = 0; i < model.getSize(); i++) 
 		{
    	decksPanel.add(new JButton(model.getElementAt(i)));
    }
	}

}