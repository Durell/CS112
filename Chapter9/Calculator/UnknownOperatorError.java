public class UnknownOperatorError extends Exception
{
	public UnknownOperatorError()
	{
		super("Unknown Operator Error!");
	}

	public UnknownOperatorError(char i)
	{
		super(i + " is an unknown operation.");
	}
}