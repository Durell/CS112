public class SSNLengthException extends Exception
{
	public SSNLengthException()
	{
		super("Social Security Length Exception");
	}

	public SSNLengthException(String s)
	{
		super(s);
	}
}