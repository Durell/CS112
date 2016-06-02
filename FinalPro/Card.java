public class Card
{
	String front;
	String back;
	String tag;

	public Card(String f, String b)
	{
		front = f;
		back = b;
		tag = null;
	}
	public Card(String f, String b, String t)
	{
		front = f;
		back = b;
		tag = t;
	}

	public String toString()
	{
		return "Front: " + front + "\nBack: " + back;
	}
}

