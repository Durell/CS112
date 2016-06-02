// Panel to display flash cards being reviewed
// Probably have an initial panel and after an
// event will display the "other side" of the card

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FlashcardPanel extends JPanel
{
	private boolean flipCard;
	private JButton flip;
	public JLabel front;
	public JLabel back;
	public JPanel cards;
	public static Deck deck;
	public String frontString, backString;

	public FlashcardPanel()
	{
		// basic layout setup decent so far
		// still needs formatting: terms centered
		// Will need an ActionListener that will display 
		// the other side
		deck = new Deck("Chinese");
		Card temp = new Card("你好", "Hello");
		deck.addCard(temp);
		cards = new JPanel();
		setLayout(new BorderLayout());
		setBackground(Color.white);
		front = new JLabel("Foo", JLabel.CENTER);
		back = new JLabel("Bar", JLabel.CENTER);
		cards.setLayout(new GridLayout(2,1));
		cards.add(front);
		cards.add(back);
		back.setVisible(false);
		flip = new JButton("Flip");
		flip.addActionListener(new FlipCardListener());
		add(cards, BorderLayout.CENTER);
		add(flip, BorderLayout.SOUTH);
	}

	public void cycleCards(Deck d)
	{
		//for(Card c: deck.cards)
	}

	private class FlipCardListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// "flip" card - Display associated info
			if (!back.isVisible())
				back.setVisible(true);
			else
				//show next card
			{
				front.setText(""); // set text to next element
 				back.setText(""); 
			}
		}
	}
}