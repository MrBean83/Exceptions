/**
 * Created by Henroid83 on 4/3/15.
 */
public class InvalidContinueCode extends Exception
{
    InvalidContinueCode(String message)
    {
        super(message);
    }

    public String toString()
    {
        return "\nThis is not a valid code to continue the program.\n";
    }
}
