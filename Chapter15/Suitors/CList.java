
public class CList
{

    private class Node
    {
        private String data;
        private Node link;

        public Node( )
        {
             data = null;
             link = null;
        }

        public Node(String newData, Node linkValue)
        {
            data = newData;
            link = linkValue;
        }
     }//End of Node inner class

    public class CIterator
    {
        private Node position, previous;
        public void next()
        {
            previous = position;
            position = position.link;
        }

        public void delete()
        {
            if (tail == null)
                throw new IllegalStateException();
            else if (size() == 1)
                tail = null;
            else
            {
                previous.link = position.link;
                position = position.link;
            }

        }
    }

    private Node tail;

    public CIterator iterator()
    {
        return new CIterator();
    }

    public CList()
    {
        tail = null;
    }

    /**
     Adds a node at the start of the list with the specified data.
     The added node will be the first node in the list.
    */
    public void add(String itemData)
    {
        Node s = new Node();
        s.data = itemData;
        if (tail == null)
        {
            tail = s;
            tail.link = tail;
        }
        else
        {
            s.link = tail.link;
            tail.link = s;
        }
    }

    /**
     Removes the tail node and returns true if the list contains at least
     one node. Returns false if the list is empty.
    */
    public boolean deleteHeadNode( )
    {
        if (tail != null)
        {
            tail = tail.link.link;
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
        Node position = tail;
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
     reference to that node. If target is not in the list, null is returned.
    */
    private Node find(String target)
    {
        Node position = tail;
        String itemAtPosition;
        while (position != null)
        {
            itemAtPosition = position.data;
            if (itemAtPosition.equals(target))
                return position;
            position = position.link;
        }
        return null; //target was not found
    }

    /**
     Finds the first node containing the target and returns a reference
      to the data in that node. If target is not in the list, null is returned.
    */
    public String findData(String target)
    {
        return find(target).data;
    }

    public void outputList( )
    {
        Node position = tail;
        while (position != null)
        {
            System.out.println(position.data);
            position = position.link;
        }
    }

    public boolean isEmpty( )
    {
        return (tail == null);
    }

    public void clear( )
    {
        tail = null;
    }

   /*
    For two lists to be equal they must contain the same data items in
    the same order. The equals method of T is used to compare data items.
   */
   public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            CList otherList = (CList)otherObject;
            if (size( ) != otherList.size( ))
                return false;
            Node position = tail;
            Node otherPosition = otherList.tail;
            while (position != null)
            {
                if (!(position.data.equals(otherPosition.data)))
                    return false;
                position = position.link;
                otherPosition = otherPosition.link;
            }
            return true; //no mismatch was not found
        }
    }

}