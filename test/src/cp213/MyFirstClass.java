/**
 *
 */
package cp213;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;

public class MyFirstClass {
    public static void main(String[] args) {
	System.out.println("This is now working");
	System.out.println("This now working again");

	byte myAge = 22;
	int herAge = myAge - 4;

	System.out.println("");
	System.out.println("Her Age: " + herAge);

	float price = 1.99F;
	int quantity = 2;

	System.out.println(price * quantity);

	boolean isValid = false;
	System.out.println(isValid);

	Date now = new Date();
	System.out.println(now);

	char[] arr = new char[5];

	arr[0] = '1';
	arr[1] = '2';
	arr[2] = '3';

	System.out.println("");
	System.out.println(arr);

	System.out.println(Arrays.toString(arr));
	System.out.println("");
	System.out.println("");

	boolean[] newArr = { true, false, true };
	System.out.println(Arrays.toString(newArr));
	System.out.println(newArr.length);

	int[][] ray = { { 1, 3 }, { 2, 4 } };

	System.out.println(Arrays.deepToString(ray));

	String x = "1";
	Float y = Float.parseFloat(x);
	System.out.println(y);

	String k = NumberFormat.getPercentInstance().format(.01);
	System.out.println(k);
    }

}
