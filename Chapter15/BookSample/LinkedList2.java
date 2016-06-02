import java.util.NoSuchElementException;

public class LinkedList2
{
	private class Node
	{
		private String item;
		private Node link;
		public Node( )
		{
			item = null;
			link = null;
		}
		public Node(String newItem, Node linkValue)
		{
			item = newItem;
			link = linkValue;
		}
	} //End of Node inner class

	/**
	If the list is altered any iterators should invoke restart or
	the iterator's behavior may not be as desired.
	*/
	public class List2Iterator
	{
		private Node position;
		private Node previous; //previous value of position
		public List2Iterator( )
		{
			position = head; //Instance variable head of outer class.
			previous = null;
		}
		public void restart( )
		{
			position = head; //Instance variable head of outer class.
			previous = null;
		}
		public String next( )
		{
			if (!hasNext( ))
				throw new NoSuchElementException( );
			String toReturn = position.item;
			previous = position;
			position = position.link;
			return toReturn;
		}
		public boolean hasNext( )
		{
			return (position != null);
		}
		/**
		Returns the next value to be returned by next( ).
		Throws an IllegalStateExpression if hasNext( ) is false.
		*/
		public String peek( )
		{
			if (!hasNext( ))
				throw new IllegalStateException( );
			return position.item;
		}
		/**
		Adds a node before the node at location position.
		previous is placed at the new node. If hasNext( ) is
		false, then the node is added to the end of the list.
		If the list is empty, inserts node as the only node.
		*/
		public void addHere(String newData)
		{
			if (position == null && previous != null)
				// at end of the list, add to end
				previous.link = new Node(newData, null);
			else if (position == null || previous == null)
				// list is empty or position is head node
				;
			else
			{ // previous and position are consecutive nodes
				Node temp = new Node(newData, position);
				previous.link = temp;
				previous = temp;
			}
		}
		/**
		Changes the String in the node at location position.
		Throws an IllegalStateException if position is not at a node,
		*/

		/**     
		DEFINE THIS METHOD!!!!!!!!!!!!
		public void changeHere(String newData)
< Self-Test Exercise 13 asks you to complete the rest of the method changeHere.>
		*/
		/**
		Deletes the node at location position and
		moves position to the "next" node.
		Throws an IllegalStateException if the list is empty.
		*/
		public void delete( )
		{
			if (position == null)
			throw new IllegalStateException( );
			else if (previous == null)
			{ // remove node at head
				head = head.link;
				position = head;
			}
			else // previous and position are consecutive nodes
			{
				previous.link = position.link;
				position = position.link;
			}
		}
	}


	private Node head;
	
	public List2Iterator iterator( )
	{
		return new List2Iterator( );
	}
	/*
	Default Constructor
	*/
	public LinkedList2( )
	{
		head = null;
	}
	/**
	Adds a node at the start of the list with the specified data.
	The added node will be the first node in the list.
	*/
	public void addToStart(String itemName)
	{
		head = new Node(itemName, head);
	}
	/**
	Removes the head node and returns true if the list contains at
	least one node. Returns false if the list is empty.
	*/
	public boolean deleteHeadNode( )
	{
		if (head != null)
		{
			head = head.link;
			return true;
		}
		else
			return false;
	}
	/**
	Returns the number of nodes in the list.
	*/
	public int size( )
	{
		int count = 0;
		Node position = head;
		while (position != null)
		{
			count++;
			position = position.link;
		}
		return count;
	}
	public boolean contains(String item)
	{
		return (find(item) != null);
	}
	/**
	Finds the first node containing the target item, and returns a
	reference to that node. If target is not in the list, null isreturned.
	*/
	private Node find(String target)
	{
		Node position = head;
		String itemAtPosition;
		while (position != null)
		{
			itemAtPosition = position.item;
			if (itemAtPosition.equals(target))
			return position;
			position = position.link;
		}
		return null; //target was not found
	}
	public void outputList( )
	{
		Node position = head;
		while (position != null)
		{
			System.out.println(position.item );
			position = position.link;
		}
	}
	public boolean isEmpty( )
	{
		return (head == null);
	}
	public void clear( )
	{
		head = null;
	}
}