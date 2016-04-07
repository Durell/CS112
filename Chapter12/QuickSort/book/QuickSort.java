/***
Class that realizes the divide-and-conquer sorting pattern and
uses the quick sort algorithm.
*/
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
		if ((end - begin) > 1)
		{
			int splitPoint = split(a, begin, end);
			sort(a, begin, splitPoint);
			sort(a, (splitPoint + 1), end);
		}
		else if ((end-begin) == 1)
		{
			/*  Debugging:
			System.out.println("running base case");
			*/
			if(a[begin] > a[end])
			{
				double swap = a[end];
				a[end] = a[begin];
				a[begin] = swap;
			}
		}
	}

	private static int split( double [] a, int begin, int end)
	{
		double[] temp;
		int size = (end - begin + 1);
		temp = new double [size];
		double splitValue = ((a[begin] + a[end] + a[size/2]) / 3);
		/**  for Debugging purposes:
		System.out.println("splitValue = " + splitValue);
		System.out.println("begin = " + begin);
		System.out.println("end = " + end);
		*/
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