package testing;

public class FinSeq {

    public static void Fibnumbers(int nthNumber) {
	int number1 = 0;
	int number2 = 1;
	int i = 0;
	int sum = 0;
	while (i < nthNumber) {
	    System.out.println("#" + i + " Number is: " + number1);
	    sum = number1 + number2;
	    number1 = number2;
	    number2 = sum;

	    ++i;
	}
    }

    public static void calculateNthNumber(int nthNumber) {

	try {
	    if (nthNumber == 0) {
		System.out.println("0 Number: 0");
	    } else if (nthNumber == 1) {
		System.out.println("1 Number: 1");
	    } else {
		Fibnumbers(nthNumber);
	    }
	} catch (Exception e) {
	    System.out.println("Invalid Number");
	}
    }
}
