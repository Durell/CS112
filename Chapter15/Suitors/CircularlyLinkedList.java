import java.util.NoSuchElementException;

public class CircularlyLinkedList<T>
{
	private class TwoWayNode
	{
		private <T> item;
		private TwoWayNode previous;
		private TwoWayNode next;
		public TwoWayNode()
		{
			item = null;
			next = null;
			previous = null;
		}
		public TwoWayNode(<T> newItem, TwoWayNode previousNode,TwoWayNode nextNode)
		{
			item = newItem;
			next = nextNode;
			previous = previousNode;
		}
	} //End of TwoWayNode inner class

	public class CircularlyLinkedIterator
	{
		// We do not need a previous node when using a doubly linked list
		private TwoWayNode position = null;
		public CircularlyLinkedIterator( )
		{
			position = head;
		}
		public void restart( )
		{
			position = head;
		}
		public <T> next( )
		{
			if (!hasNext( ))
				throw new IllegalStateException( );
			<T> toReturn = position.item;
			position = position.next;
			return toReturn;
		}
		// The methods hasNext, peek, clear, and isEmpty from Display 15.17
		public boolean hasNext( )
		{
			return (position != null);
		}
		/**
		Returns the next value to be returned by next( ).
		Throws an IllegalStateExpression if hasNext( ) is false.
		*/
		public <T> peek( )
		{
			if (!hasNext( ))
				throw new IllegalStateException( );
			return position.item;
		}
		public boolean isEmpty( )
		{
			return (head == null);
		}
		public void clear( )
		{
			head = null;
		}
		public void insertHere(<T> newData)
		{
			if (position == null && head != null)
			{
				// Add to end. First move a temp
				// pointer to the end of the list
				TwoWayNode temp = head;
				while (temp.next != null)
					temp = temp.next;
				temp.next = new TwoWayNode(newData, temp, null);
			}
			else if (head == null || position.previous == null)
				// at head of list
				CircularlyLinkedList.this.addToStart (newData);
			else
			{
				// Insert before the current position
				TwoWayNode temp = new TwoWayNode(newData, position. previous, position);
				position.previous.next = temp;
				position.previous = temp;
			}
		}
		public void delete( )
		{
			if (position == null)
				throw new IllegalStateException( );
			else if (position.previous == null)
			{ // Deleting first node
				head = head.next;
				position = head;
			}
			else if (position.next == null)
			{ // Deleting last node
				position.previous.next = null;
				position = null;
			}
			else
			{
				position.previous.next = position.next;
				position.next.previous = position.previous;
				position = position.next;
			}
		}
	} // end CircularlyLinkedIterator

	private TwoWayNode head;
	public CircularlyLinkedIterator iterator( )
	{
		return new CircularlyLinkedIterator( );
	}
	public CircularlyLinkedList( )
	{
		head = null;
	}
	/**
	The added node will be the first node in the list.
	* NEEDS MODIFICATION
	*/
	public void addToStart(<T> itemName)
	{
		TwoWayNode newHead = new TwoWayNode(itemName, null, head);
		if (head != null)
		{
			head.previous = newHead;
		}
		head = newHead;
	}
} // CircularlyLinkedList
/*
<The methods hasNext, peek, clear, and isEmpty are identical
to those in Display 15.17. Other methods would also normally
be defined here, such as deleteHeadNode, size, outputList,
equals, clone, find, or contains. They have been left off to
simplify the example.>
*/