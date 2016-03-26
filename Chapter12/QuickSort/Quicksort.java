/*
Chapter No. 12 - Project 8
File Name:          QuickSort.java
Programmer:         Durell Smith
Date Last Modified: March x, 2016

Problem Statement:

6. Recode the QuickSort class implementation by adding two efficiency improvements
to the method sort : (1) Eliminate the calls to join , because it accomplishes
nothing. (2) Add code for the special case of an array of exactly two elements and
make the general case apply to arrays of three or more elements.

7. Redo the QuickSort class so that it chooses the splitting point as follows: The
splitting point is the middle (in size) of the first element, the last element, and an
element at approximately the middle of the array. This will make a very uneven
split less likely.

8. Redo the QuickSort class to have the modifications given for Programming
Projects 12.6 and 12.7.

*/

// imports

public class QuickSort
{
	/***
	Precondition: Interval a[begin] through a[end] of a have elements.
	Postcondition: The values in the interval have
	 been rearranged so that a[begin] <= a[begin+1] <= . . . <=
	 a[end].
	*/
	public static void sort( double[] a, int begin, int end)
	{
		if ((end - begin) >= 1)
		{
			int splitPoint = split(a, begin, end);
			sort(a, begin, splitPoint);
			sort(a, splitPoint + 1, end);
		}//else sorting one (or fewer) elements so do nothing.
	}

	private static int split( double [] a, int begin, int end)
	{
		double[] temp;
		int size = (end - begin + 1);
		temp = new double [size];
		double splitValue = a[begin];
		int up = 0;
		int down = size - 1;

		//Note that a[begin] = splitValue is skipped.
		for ( int i = begin + 1; i <= end; i++)
		{
			if (a[i] <= splitValue)
			{
				temp[up] = a[i];
				up++;
			}
			else
			{
				temp[down] = a[i];
				down--;
			}
		}
		//0 < = up = down < size
		temp[up] = a[begin]; //Positions the split value
		//temp[i] <= splitValue for i < up
		// temp[up] = splitValue
		// temp[i] > splitValue for i > up
		for ( int i = 0; i < size; i++)
			a[begin + i] = temp[i];
		return (begin + up);
	}
}
