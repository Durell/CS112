public class Action extends Movie
{

  /**
  * Default Constructor; 
  */
  public Action()
  {
    super();
    setLateFee(3);
  }

  public Action(String t, String r, int id)
  {
    super(t, r, id, 3);
  }
  
} // ! end of class Action