/*
Chapter No. 14 - Project 4 (Page 799)
File Name:          MyMathClass.java
Programmer:         Durell Smith
Date Last Modified: April 25, 2016

Problem Statement:
Write a generic class, MyMathClass, with a type parameter T where T is a numeric
object type (e.g., Integer, Double, or any class that extends java.lang.Number) and
add a method to calculate the standard deviation of the values in the ArrayList.
*/

// imports
import java.util.Random; // generate values to be populated into test arrays
import java.util.ArrayList;

public class MyMathClass<T extends Number>
{

	public MyMathClass()
	{}

	public double standardDeviation(ArrayList<T> values)
	{
		double average = 0;
		double count = 0; // need count of numbers to calculate average
		double largest = 0;
		double smallest = 10000;
		for (T value : values)
		{
			/* used to confirm algorithm
			System.out.println(value);
			*/
			average += value.doubleValue();
			count++;
		}
		/* May be used to target largest and smallest if outliers need addressing
			if (value.doubleValue() > largest)
				largest = value.doubleValue();
			if (value.doubleValue() < smallest)
				smallest = value.doubleValue();
		System.out.println("Largest Value in Sample: " + largest);
		System.out.println("Smallest Value in Sample: " + smallest);
		*/
		average /= count;
		double deviation = 0;
		for (T value : values)
		{
			double temp = value.doubleValue() - average;
			temp *= temp;
			deviation += temp;
		}
		deviation /= (count - 1);
		deviation = Math.sqrt(deviation);
		return deviation;
	}

  public static void main(String[] args)
  {
  	Random ran = new Random();
  	ArrayList<Integer> intList = new ArrayList<>(50);
  	MyMathClass<Integer> testInt = new MyMathClass<>();
  	/* original numbers used to confirm formula for deviation
  	intList.add(5);
  	intList.add(33);
  	intList.add(10);
  	intList.add(12);
  	double result = testInt.standardDeviation(intList);
  	System.out.println(result);
  	*/
  	for (int i = 0; i < 50; i++)
  	{
  		int input = ((ran.nextInt(1000) - 300) * 2);
  		intList.add(input);
  	}
  	System.out.println("First ArrayList highest and lowest values");
  	double result1 = testInt.standardDeviation(intList);
  	System.out.println("Standard deviation for first ArrayList:");
  	System.out.println(result1);

  	ArrayList<Double> doubleList = new ArrayList<>(50);
  	MyMathClass<Double> testDouble = new MyMathClass<>();
  	for (int i = 0; i < 50; i++)
  	{
  		double input = (ran.nextDouble() * 200);
  		doubleList.add(input);
  	}
  	System.out.println("Second ArrayList highest and lowest values");
  	double result2 = testDouble.standardDeviation(doubleList);
  	System.out.println("Standard deviation for second ArrayList:");
  	System.out.println(result2);
  }
}