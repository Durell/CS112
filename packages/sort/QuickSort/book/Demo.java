public class Demo
{
	public static void main(String[] args)
	{
		double[]b = {7.7, 12.2, 89, 12, 5.5, 13, 10, 7, 22};
		System.out.println("Array contents before sorting:");
		int i;
		for (i = 0; i < b.length; i++)
			System.out.print(b[i] + " ");
		System.out.println();
		QuickSort.sort(b, 0, b.length-1);
		System.out.println("Sorted array values:");
		for (i = 0; i < b.length; i++)
			System.out.print(b[i] + " ");
		System.out.println();
	} // end main
 }