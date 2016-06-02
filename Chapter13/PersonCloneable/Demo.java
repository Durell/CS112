public class Demo
{
	public static void main(String[] args)
	{
		Person dad = new Person("Tom");
		System.out.println("Created first person.");
		Person dadCopy = dad.clone();
		System.out.println("Copied first person, so now should have two of same:");
		System.out.println(dad);
		System.out.println(dadCopy);
		System.out.println("Now we'll confirm it's a deep copy");
		System.out.println("Changing the second name and displaying both again:");
		dadCopy.setName("Derek");
		System.out.println(dad);
		System.out.println(dadCopy);
	}
}