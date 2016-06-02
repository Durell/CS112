import java.util.Scanner;
import java.util.Random; // use to generate 50 random numbers for testing purposes

public class BubbleSortComparable
{

    // Sort method
    public static void sort(Comparable[] a)
    {
        Comparable swap = a[0];
        for (int i = 0; i < a.length - 1; i++)
        {
            for (int j = 0; j < a.length - 1; j++)
            {
                if (a[j].compareTo(a[j+1]) > 0)
                {
                    swap = a[j];
                    a[j] = a[j+1];
                    a[j+1] = swap;
                }
            }
        }

    }
}
