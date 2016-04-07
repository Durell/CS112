public class QuickEx
{
  public static void sort(double[] a, int begin, int end)
  {
    split(a, begin, end);
  }

  public static void split(double[] a, int begin, int end)
  {
    double splitValue = a[begin];
    double temp = 0;
    if (splitValue > a[begin + 1])
      temp = a[begin + 1];
    a[begin] = temp;
    a[begin + 1] = splitValue;
  }

  public static void main(String[] args)
  {
    double[] ar = {5, 3};
    System.out.println("before");
    for (int i = 0; i < 2; i++)
      System.out.println(ar[i]);
    sort(ar, 0, 1);
    System.out.println("after");
    for (int i = 0; i < 2; i++)
      System.out.println(ar[i]);
  }
}
