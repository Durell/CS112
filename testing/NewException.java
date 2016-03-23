import java.util.InputMismatchException;
public class NewException extends InputMismatchException
{
  public NewException()
  {
    super("I'm new at this...");
  }
}
