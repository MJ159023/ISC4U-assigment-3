/*
 * The program runs Sylvesters numbers.
 *
 * @author  Michael Bruneau
 * @version 1.0
 * @since   2020-11-30
 */

// setup
import java.util.Scanner;

public final class Main {
    // constants
    /**
     * Sylvester number a(0) is always 2.
     */
    private static final int SYLVESTER_NUMBER_ZERO = 2;


    /**
     * This function generates sylvester's numbers.
     * It takes number sylvester nummber needed using previous input from user
     * It then uses sylvester formula to calcualte the next number
     * It then prints out the out the previous calculating before recusrsing
     *
     * @param runTimes
     * @param sylvesterNumber
     * @return function again
     */
    public static int sylvesterNumberGenerator(final int runTimes,
                    final int sylvesterNumber) {
        // variables
        int nextSylvesterNumber = sylvesterNumber;

        if (runTimes == 0) {
            System.out.println(sylvesterNumber + ".");
            return sylvesterNumber;
        } else {
            nextSylvesterNumber = nextSylvesterNumber * nextSylvesterNumber
                    - nextSylvesterNumber + 1;
            System.out.println(sylvesterNumber + ",");
            return sylvesterNumberGenerator(runTimes - 1, nextSylvesterNumber);
        }
    }

     /**
     * Private constructor to prevent instantiation.
     * Throw an excpetion IllegalState Exception
     * if this is ever called
     *
     * @throws IllegalStateException if this is ever called
     *
    */
    private Main() {
        throw new IllegalStateException("Cannot be instantiated.");
    }

    /**
     * Runs main.
     *
     * @param args
     */
    public static void main(final String[] args) {
        // variables
        Scanner userInput = new Scanner(System.in);
        String numberOfSylvesterNumbers;
        boolean loop = true;

        while (loop) {
            // gets input
            System.out.print("Input number of sylvester numbers you want"
                        + " outputed after a(0): ");
            numberOfSylvesterNumbers = userInput.nextLine();

            // makes sure input is valid
            try {
                // tries to convert input to integer
                int loopTimes = Integer.parseInt(
                             numberOfSylvesterNumbers);

                // checks if number selected is above or equal to zero
                if (loopTimes >= 0) {
                    // sets loop to false if input is valid and uses method
                    loop = false;
                    sylvesterNumberGenerator(loopTimes, SYLVESTER_NUMBER_ZERO);
                } else {
                    // error message
                    System.out.println("\nInvalid input. Number must be equal "
                                    + "to or larger than zero.");
                }

            } catch (NumberFormatException e) {
                // error message
                System.out.println("\nInvalid input.");
            }
        }
        userInput.close();
    }
}

