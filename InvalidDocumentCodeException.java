/**
 * Created by Henry Nichols on 4/3/15.
 */
//
// Represent an exceptional situation in which a business document designation begins with an improper code.
//
public class InvalidDocumentCodeException extends Exception
{
    InvalidDocumentCodeException(String message)
    {
        super(message);
    }

    public String toString()
    {
        return "\nSorry, this is not a valid business document designation.\n";
    }
}
