import java.util.Scanner;

public class test
{

  /*
  public static boolean isInteger(String s) 
  {
    return isInteger(s,10);
  }
  
  public static boolean isInteger(String s, int radix) 
  {
    if(s.isEmpty()) return false;
    for(int i = 0; i < s.length(); i++) {
        if(i == 0 && s.charAt(i) == '-') {
            if(s.length() == 1) return false;
            else continue;
        }
        if(Character.digit(s.charAt(i),radix) < 0) return false;
    }
  }
  */
 
  public static void main(String[] args)
  {

    String hello = "Hello. world!";
    int end = hello.length() - 1;
    char a = hello.charAt(end);
    System.out.println(a);
    System.out.println(hello.replaceAll("[^a-zA-Z]", "").toLowerCase());



/*
    String s = "1234";
    System.out.println(isInteger(s, 3));

  	try
  	{
  		aMethod();
  	}
  	catch (Exception ex)
  	{
  		System.out.println("Exception handled in main");
  	}
  	doesNotThrowException();
  }
  public static void aMethod() throws Exception
  {
  	try
  	{
  		System.out.println("method ThrowException");
  		throw new Exception();
  	}
  	catch(Exception ex)
  	{
  		System.out.println("exception handled in method aMethod");
  	}
  	finally
  	{
  		System.out.println("finally executed in aMethod");
  	}
  }
  public static void doesNotThrowException()
  {
  	try
  	{
  		System.out.println("Method doesNotThrowException");
  	}
  	catch (Exception ex)
  	{
  		System.out.println(ex);
  	}
  	finally
  	{
  		System.out.println("finall in doesNotThrowException");
  	}
  	System.out.println("end of method doesNotThrowException");
    */
  }
}

