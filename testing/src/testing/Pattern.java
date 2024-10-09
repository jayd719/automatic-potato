/**
 *
 */
package testing;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 */
public class Pattern {

    /**
     * @param args
     */
    public static void rectangle() {
	// TODO Auto-generated method stub
	Scanner scan = new Scanner(System.in);

	System.out.print("Enter Number Of Rows Of Rectangle: ");
	int rows = scan.nextInt();

	System.out.print("Enter Number of Columns: ");
	int cols = scan.nextInt();
	System.out.println("");

	for (int i = 0; i < rows; i++) {
	    for (int j = 0; j < cols; j++) {
		System.out.print("*");
	    }
	    System.out.println("");
	}
    }

    public static void hollowrectangle() {
	Scanner scan = new Scanner(System.in);

	System.out.print("Enter Number Of Rows Of Rectangle: ");
	int rows = scan.nextInt();

	System.out.print("Enter Number of Columns: ");
	int cols = scan.nextInt();
	System.out.println("");

	for (int i = 0; i < rows; i++) {
	    for (int j = 0; j < cols; j++) {
		if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
		    System.out.print("*");
		} else {
		    System.out.print(" ");
		}
	    }
	    System.out.println("");
	}

    }

    public static void halfpyramid() {

	Scanner scan = new Scanner(System.in);

	System.out.print("Enter Number Of Rows Of Pyramid: ");
	int rows = scan.nextInt();

	System.out.println("");

	for (int i = 1; i <= rows; i++) {
	    System.out.println("*".repeat(i));
	}
    }

    public static void halfpyramidreverse() {

	Scanner scan = new Scanner(System.in);

	System.out.print("Enter Number Of Rows Of Pyramid: ");
	int rows = scan.nextInt();

	System.out.println("");

	for (int i = 0; i <= rows; i++) {
	    System.out.println("*".repeat(rows - i));
	}
    }

    public static void pyramid180() {
	Scanner scan = new Scanner(System.in);

	System.out.print("Enter Number Of Rows Of Pyramid: ");
	int rows = scan.nextInt();

	System.out.println("");

	int i = 1;
	while (i <= rows) {
	    int j = 1;
	    while (j <= rows) {
		if (j == rows || i == rows || j > rows - i) {
		    System.out.print("*");
		} else {
		    System.out.print(" ");
		}
		j++;
	    }
	    System.out.println("");
	    i++;
	}

    }

    public static void numbers() {
	Scanner scan = new Scanner(System.in);

	System.out.print("Enter Number Of Rows Of Pyramid: ");
	int rows = scan.nextInt();

	System.out.println("");

	int i = 1;

	while (i <= rows) {
	    for (int j = 1; j <= i; j++) {
		System.out.print(j + " ");
	    }
	    System.out.println("");
	    i++;
	}

    }

    public static void numbersinverted() {

	Scanner scan = new Scanner(System.in);

	System.out.print("Enter Number Of Rows Of Pyramid: ");
	int rows = scan.nextInt();

	System.out.println("");

	int i = 1;

	while (rows > 0) {
	    int j = 1;
	    do {
		System.out.print(j + " ");
		j++;
	    } while (j <= rows);
	    rows--;
	    System.out.println("");
	}

    }

    public static void multipattern() {

	Scanner scan = new Scanner(System.in);

	System.out.print("Enter Number Of Rows Of Pyramid: ");
	int rows = scan.nextInt();

	System.out.println("");

	int i = 1;
	int k = 1;
	while (i <= rows) {
	    for (int j = 1; j <= i; j++) {
		System.out.print(k + " ");
		k++;
	    }
	    System.out.println("");
	    i++;
	}

    }

    public static void zeroOneTriangle() {
	Scanner scan = new Scanner(System.in);

	System.out.print("Enter Number Of Rows Of Pyramid: ");
	int rows = scan.nextInt();

	System.out.println("");

	int i = 1;

	while (i <= rows) {
	    int j = 1;
	    while (j < i) {
		if ((i + j) % 2 == 0) {
		    System.out.print(0);

		} else {
		    System.out.print(1);

		}

		j++;
	    }
	    System.out.println("");
	    i++;
	}

    }

    public static void butterfly() {
	Scanner scan = new Scanner(System.in);

	System.out.print("Enter Number Of Rows Of Pyramid: ");
	int rows = scan.nextInt();

	System.out.println("");

	int i = 1;
	while (i <= rows) {
	    System.out.print("* ".repeat(i) + "  ".repeat(rows * 2 - (i + i)) + "* ".repeat(i));
	    System.out.println();
	    i++;
	}
	i = rows;
	while (i > 0) {
	    System.out.print("* ".repeat(i) + "  ".repeat(rows * 2 - (i + i)) + "* ".repeat(i));
	    System.out.println();
	    i--;
	}
    }

    public static void rhombus() {
	int n = 5;
	for (int i = 1; i <= n; i++) {
	    System.out.println(" ".repeat(n - i) + "*".repeat(n));
	}

    }

    public static void palinpattern() {
	int n = 9;

	int i = 1;

	while (i <= n) {
	    System.out.print(" ".repeat(n - i));
	    int j = i;
	    while (j > 0) {
		System.out.print(j);
		j--;
	    }
	    j = 2;
	    while (j <= i) {
		System.out.print(j);
		j++;
	    }
	    System.out.println();
	    i++;
	}

    }

    public static void diamond() {
	int n = 4;

	int i = 1;
	while (i <= n) {
	    System.out.println(" ".repeat(n - i) + "* ".repeat((i * 2) - 1));
	    i++;
	}
	i = n;
	while (n > 0) {
	    System.out.println(" ".repeat(i - n) + "*".repeat((n * 2) - 1));
	    n--;
	}

    }

    public static void listTest() {

	ArrayList<Integer> list = new ArrayList<Integer>();

	list.add(2);
	list.add(3);
	System.out.println(list);
	System.out.println();

	System.out.println("Aftera adding on ");
	list.add(1, 1);

	System.out.println(list);

	System.out.println("");
	list.set(0, 5);

	System.out.println(list);
    }

}
