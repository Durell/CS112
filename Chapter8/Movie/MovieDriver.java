// Driver class to test Movie and derived classes
public class MovieDriver
{

  public static void main (String[] args)
  {

    // Create a movie
    Movie c = new Comedy("Zombieland", "R", 2211);
    Movie a = new Action("Star Wars", "PG-13", 1111);
    Movie d = new Drama("Shawshank Redemption", "R", 1221);
    Movie t = new Action("Star Wars", "PG-13", 1111);
    int days = 3;

    // Processing: test methods
    double f = c.calculateFees(days);

    //Output results
    System.out.println("> Let's see the toString() method from a comedy:\n" + c);
    System.out.println("> Now let's see our action movie's info:\n" + a);
    System.out.println("> Finally, let's see our drama movie's info:\n" + d);
    System.out.println("> If a comedy is 3 days late, the fee will be:\n" + f);
    System.out.println("> Are Star Wars and Star Wars the same movie?\n" + a.equals(t));
    System.out.println("> Are Zombieland and Star Wars the same movie?\n" + c.equals(t));
  
  } // ! end of main()

} // ! end of class MovieDriver