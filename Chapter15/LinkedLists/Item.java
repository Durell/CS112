public class Item implements Comparable
{
	private int num;

	public Item(int n)
	{
		num = n;
	}

	public int getNum()
	{
		return num;
	}

	public int compareTo(Object other)
	{
		Item otherItem = (Item)other;
		if (num == otherItem.getNum())
			return 0;
		if (num > otherItem.getNum())
			return 1;
		else
			return -1;
	}

	public String toString()
	{
		return "Number: " + num;
	}
}