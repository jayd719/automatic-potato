package cp213;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Jashandeep Singh 169018282
 * @version 2023-09-18
 */
public class SerialNumber {

    /**
     * Determines if a string contains all digits.
     *
     * @param str The string to test.
     * @return true if str is all digits, false otherwise.
     */
    public static boolean allDigits(final String str) {

	boolean allDigits = true;
	int i = 0;
	while (i < str.length() && allDigits == true) {
	    if (Character.isDigit(str.charAt(i)) == false) {
		allDigits = false;
	    }
	    i += 1;
	}

	return allDigits;
    }

    /**
     * Determines if a string is a good serial number. Good serial numbers are of
     * the form 'SN/nnnn-nnn', where 'n' is a digit.
     *
     * @param sn The serial number to test.
     * @return true if the serial number is valid in form, false otherwise.
     */
    public static boolean validSn(final String sn) {

	boolean isValidSN = true;

	if (sn.length() != 11) {
	    isValidSN = false;
	    // if sn does not contain 11 characters it is not valid
	} else {
	    if (sn.charAt(2) != '/') {
		isValidSN = false;
	    } else if (sn.charAt(7) != '-') {
		isValidSN = false;
	    } else {
		String numbers = sn.substring(3, 7) + sn.substring(8);
		int i = 0;
		while (i < numbers.length() && isValidSN == true) {
		    if (Character.isDigit(numbers.charAt(i)) == false) {
			isValidSN = false;
		    }
		    i += 1;
		}

	    }
	}

	return isValidSN;
    }

    /**
     * Evaluates serial numbers from a file. Writes valid serial numbers to
     * good_sns, and invalid serial numbers to bad_sns. Each line of fileIn contains
     * a (possibly valid) serial number.
     *
     * @param fileIn  a file already open for reading
     * @param goodSns a file already open for writing
     * @param badSns  a file already open for writing
     */
    public static void validSnFile(final Scanner fileIn, final PrintStream goodSns, final PrintStream badSns) {

	return;
    }

}
