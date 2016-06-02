public static void sort( double[] a, int begin, int end)
{
	if ((end — begin) >= 1)
	{
	int splitPoint = split(a, begin, end);
	sort(a, begin, splitPoint);
	sort(a, splitPoint + 1, end);
	join(a, begin, splitPoint, end);
	}//else sorting one (or fewer) elements so do nothing.
}
private static int split( double [] a, int begin, int end)
{
	double[] temp;
	int size = (end — begin + 1);
	temp = new double [size];
	double splitValue = a[begin];
	int up = 0;
	int down = size — 1;
	//Note that a[begin] = splitValue is skipped.
	for ( int i = begin + 1; i < = end; i++)
	{
		if (a[i] <= splitValue)
		{
			temp[up] = a[i];
			up++;
		}
		else
		{
			temp[down] = a[i];
			down— —;
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