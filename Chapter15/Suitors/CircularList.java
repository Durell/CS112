/*
Chapter No. 15 - Project 6 (Page 895)
File Name:          LinkedList3.java
Programmer:         Durell Smith
Date Last Modified: April x, 2016

Problem Statement:

FROM BOOK:
Write an addSorted method for the generic linked list from Display 15.8(p.818)
such that the method adds a new node in the correct location so that the list 
remains in sorted order. Note that this will require that the type parameter T 
extend the Comparable interface. Write a suitable test program.

*/

// imports

public class CircularList<T>
{
    private class Node<T>
    {
        private T data;
        private Node<T> link;

        public Node( )
        {
             data = null;
             link = null;
        }

        public Node(T newData, Node<T> linkValue)
        {
            data = newData;
            link = linkValue;
        }
     }//End of Node<T> inner class

     public class CircularIterator
     {
        private Node<T> position, previous;

        public CircularIterator()
        {
            position = tail;
            previous = null;
        }

        public void restart()
        {
            position = tail;
            previous = null;
        }

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

    private Node<T> tail;

    public CircularList( )
    {
        tail = null;
    }

    public CircularIterator iterator()
    {
        return new CircularIterator();
    }

    /**
     Adds a node at the start of the list with the specified data.
     The added node will be the first node in the list.
    */
    public void add(T itemData)
    {
        Node<T> newNode = new Node();
        newNode.data = itemData;
        if (tail == null)
        {
            tail = newNode;
            tail.link = tail;
        }
        else
        {
            newNode.link = tail.link;
            tail.link = newNode;
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
            tail.link = tail.link.link;
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
        if (tail == null)
            return count;
        count++;
        Node<T> position = tail.link;
        while (position != tail)
        {
            count++;
            position = position.link;
        }
        return count;
    }

    public boolean contains(T item)
    {
        return (find(item) != null);
    }

    /**
     Finds the first node containing the target item, and returns a
     reference to that node. If target is not in the list, null is returned.
    */
    private Node<T> find(T target)
    {
        Node<T> position = tail.link;
        T itemAtPosition;
        while (position != tail)
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
    public T findData(T target)
    {
        return find(target).data;
    }

    public void outputList( )
    {
        Node<T> position = tail.link;
        while (position != tail)
        {
            System.out.println(position.data);
            position = position.link;
        }
        System.out.println(position.data);
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
            CircularList<T> otherList = (CircularList<T>)otherObject;
            if (size( ) != otherList.size( ))
                return false;
            Node<T> position = tail;
            Node<T> otherPosition = otherList.tail;
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