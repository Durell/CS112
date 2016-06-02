// Deck class to create deck objects

import java.util.ArrayList;

public class Deck
{

	public static ArrayList<Card> cards;
	String deckName;

	public Deck(String n)
	{
		deckName = n;
		cards = new ArrayList<>();
	}

	public void addCard(Card c)
	{
		cards.add(c);
	}

	public String toString()
	{
		return deckName;
	}

	public static void main(String[] args)
	{
		Deck newDeck = new Deck("temp");
		Card card1 = new Card("Foo", "Bar");
		newDeck.addCard(card1);
		for (Card card : cards)
			System.out.println(card);
	}

}