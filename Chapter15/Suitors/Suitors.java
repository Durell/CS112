/*
Chapter No. 15 - Project 1 (Page 893)
File Name:          Suitors.java
Programmer:         Durell Smith
Date Last Modified: April x, 2016

Problem Statement:

FROM BOOK:
In an ancient land, the beautiful princess Eve had many suitors. She decided on the
following procedure to determine which suitor she would marry. First, all of the suitors
would be lined up one after the other and assigned numbers. The first suitor would
be number 1, the second number 2, and so on up to the last suitor, number n . Starting
at the suitor in the first position, she would then count three suitors down the line
(because of the three letters in her name), and the third suitor would be eliminated
from winning her hand and removed from the line. Eve would then continue, counting
three more suitors, and eliminate every third suitor. When she reached the end of
the line, she would continue counting from the beginning.
For example, if there were six suitors, the elimination process would proceed
as follows:
123456 Initial list of suitors; start counting from 1.
12456 Suitor 3 eliminated; continue counting from 4.
1245 Suitor 6 eliminated; continue counting from 1.
125 Suitor 4 eliminated; continue counting from 5.
15 Suitor 2 eliminated; continue counting from 5.
1 Suitor 5 eliminated; 1 is the lucky winner.
Write a program that creates a circular linked list of nodes to determine which position
you should stand in to marry the princess if there are n suitors. Your program
should simulate the elimination process by deleting the node that corresponds to
the suitor that is eliminated for each step in the process.

*/

public class Suitors
{

  public static void main(String[] args)
  {
    CList l = new CList();
  	int i = 7;
    System.out.println(l.size());
  	l.add("" + i);
  	i--;
    System.out.println(l.size());
  	l.add(String.valueOf(i));
  	i--;
  	l.add(String.valueOf(i));
  	i--;
  	l.add(String.valueOf(i));
  	i--;
  	l.add(String.valueOf(i));
  	i--;
  	l.add(String.valueOf(i));
  	i--;
  	l.add(String.valueOf(i));
  	System.out.println(l.size());
    CList.CIterator it = l.iterator();
    while (l.size() > 1)
    {
      it.next();
      it.next();
      it.next();
      it.delete();
    }
    System.out.print("The winner is: ");
    l.outputList();
  }
}