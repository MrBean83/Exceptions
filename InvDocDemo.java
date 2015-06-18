/**
 * Created by Henry Nichols on 4/3/15.
 */
import java.util.Scanner;
import java.util.*;

public class InvDocDemo
{
    final static char U = 'U', C = 'C', P = 'P';
    static int stopCode = 2;

    static Scanner scan = new Scanner(System.in);
    static InvalidDocumentCodeException problem = new InvalidDocumentCodeException("Business document designation must begin with either U, C, or P.");

    // This is a recursive method designed to catch each InputMismatchException object and determine whether the user wants to continue program execution.
    static int stopCodeLoop() {
        try
        {
            stopCode = scan.nextInt();
        }
        catch(InputMismatchException exc)
        {
            stopCode = 2;
            scan.nextLine();
            System.out.println("\nThat was not an integer.");
            System.out.println("Please enter 1 for yes or 0 for no: ");
            stopCodeLoop();
        }

        return stopCode;
    }

    // Create an exception object and possibly throw it.
    public static void main(String args[]) // throws InvalidDocumentCodeException
    {
        do {
            char firstChar, secondChar;
            String docCode;

            System.out.println("\nEnter a two-character designation for a business document: ");
            docCode = scan.next();

            while (docCode.length() != 2) {
                System.out.println("\nThe business document code must be two characters long.");
                System.out.println("Please enter a valid business code designation:");
                docCode = scan.next();
            }

            firstChar = docCode.charAt(0); // primarily-used variable for first character of business code
            secondChar = docCode.charAt(1); // unused variable for second character of business code

            try {
                if (firstChar == U || firstChar == C || firstChar == P)
                    System.out.println("\nCongratulations! This is a valid business document code.\n");
                else
                    throw problem;
            } catch (InvalidDocumentCodeException invDoc) {
                // catch the exception
                System.out.println(invDoc);
            }

            System.out.println("Would you like to enter a different document code?");
            System.out.println("Please enter 1 for yes or 0 for no: ");

            stopCodeLoop();

            while(stopCode != 1 && stopCode != 0) {
                System.out.println("\nThat is an invalid selection.");
                System.out.println("Please enter 1 for yes or 0 for no: ");
                stopCodeLoop();
            }

        }   while (stopCode != 0);

        System.out.println("\nThank you for using this program. Goodbye!");
    }
}
