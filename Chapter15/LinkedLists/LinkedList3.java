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
import java.util.Random;

public class LinkedList3 <T extends Comparable>
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

        public Node(T newData)
        {
             data = newData;
             link = null;
        }

        public Node(T newData, Node<T> linkValue)
        {
            data = newData;
            link = linkValue;
        }
     }//End of Node<T> inner class

    private Node<T> head;

    public LinkedList3( )
    {
        head = null;
    }

    /**
     Adds a node at the start of the list with the specified data.
     The added node will be the first node in the list.
    */
    public void addToStart(T itemData)
    {
        head = new Node<T>(itemData, head);
    }

    public void addSorted(T itemData)
    {
        boolean added = false;
        if(head == null)
        {
            addToStart(itemData);
            added = true;
        }
        Node<T> position = head;
        Node<T> previous = null;
        while (!added)
        {
            if (position.data.compareTo(itemData) == 1)
            {
                previous = position;
                position = position.link;
            }
            else if ((position.data.compareTo(itemData) < 1) && (previous == null))
            {
                Node<T> temp = new Node(itemData, head);
                head = temp;
                added = true;
            }
            else
            {
                Node<T> temp = new Node(itemData);
                temp.link = previous.link;
                previous.link = temp;
                added = true;
            }
        }
    }

    /**
     Removes the head node and returns true if the list contains at least
     one node. Returns false if the list is empty.
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
        Node<T> position = head.link;
        while (position != head)
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
        Node<T> position = head;
        T itemAtPosition;
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
    public T findData(T target)
    {
        return find(target).data;
    }

    public void outputList( )
    {
        Node<T> position = head;
        while (position != null)
        {
            System.out.println(position.data);
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
            LinkedList3<T> otherList = (LinkedList3<T>)otherObject;
            if (size( ) != otherList.size( ))
                return false;
            Node<T> position = head;
            Node<T> otherPosition = otherList.head;
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

    public static void main(String[] args)
    {
        LinkedList3 l = new LinkedList3();
        /*
        Random ran = new Random();
        for (int i = 0; i < 20; i++)
        {
            int input = ((ran.nextInt(1000) - 300) * 2);
            Item n = new Item(input);
            l.addSorted(n);
        }
        */
        Random ran = new Random();
            int input = ((ran.nextInt(1000) - 300) * 2);
            System.out.println(input);
        Item n1 = new Item(5);
        Item n3 = new Item(7);
        Item n2 = new Item(input);
        System.out.println("compareTo() output: " + n1.compareTo(n2));
        l.addSorted(n1);
        l.addSorted(n2);
        l.addSorted(n3);
        l.outputList();
    }

}