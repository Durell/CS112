public class Comedy extends Movie
{

  /**
  * Default Constructor; 
  */
  public Comedy()
  {
    super();
    setLateFee(2.5);
  }

  public Comedy(String t, String r, int id)
  {
    super(t, r, id, 2.5);
  }

} // ! end of class Comedy