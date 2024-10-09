package cp213;

import java.util.Scanner;

/**
 * Class to demonstrate the use of Scanner with a keyboard and File objects.
 *
 * @author Jashandeep Singh 169018282
 * @version 2022-09-15
 */
public class ScannerTest {

    /**
     * Count lines in the scanned file.
     *
     * @param source Scanner to process
     * @return number of lines in scanned file
     */
    public static int countLines(final Scanner source) {
	int count = 0;
	while (source.hasNextLine()) {
	    count += 1;
	    source.nextLine();
	}
	return count;
    }

    /**
     * Count tokens in the scanned object.
     *
     * @param source Scanner to process
     * @return number of tokens in scanned object
     */
    public static int countTokens(final Scanner source) {
	int tokens = 0;

	while (source.hasNext()) {
	    tokens += 1;
	    source.next();
	}

	return tokens;
    }

    /**
     * Ask for and total integers from the keyboard.
     *
     * @param source Scanner to process
     * @return total of positive integers entered from keyboard
     */
    public static int readNumbers(final Scanner keyboard) {
	int total = 0;

	boolean run_ = true;

	while (run_ == true) {
	    if (keyboard.hasNextInt() == true) {
		total += keyboard.nextInt();
	    } else {
		if (("q").equalsIgnoreCase(keyboard.next())) {
		    run_ = false;
		} else {
		    System.out.println("is not an integer or 'q'.");
		}
	    }
	}

	return total;
    }

}
