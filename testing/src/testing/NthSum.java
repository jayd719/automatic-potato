package testing;

import java.util.Scanner;

/**
 * calculates the sum of first n natural numbers
 *
 */
public class NthSum {

    /**
     * @param args
     */
    public static void main(String args[]) {

	Scanner scan = new Scanner(System.in);

	System.out.print("Enter Nth Number:");
	int nthNumber = scan.nextInt();

	int sum = 0;
	int i = 1;
	do {
	    sum += i;
	    i++;
	} while (i <= nthNumber);

	System.out.println("Sum Of " + nthNumber + "= " + sum);
	scan.close();
    }

}
