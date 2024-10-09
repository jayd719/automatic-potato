
public class FibNumber {
    private int fibNumber;
    private String binaryVal;
    private int bits;

    FibNumber(final int fibNum) {

	this.fibNumber = fibNum;
	toBinary(fibNumber);
    }

    public String auxRev(String string1) {
	System.out.println("dd");
	String returnVal = "";
	if (!string1.isEmpty()) {
	    int n = string1.length();
	    returnVal = string1.substring(n - 2) + string1.substring(0, n - 2);
	}

	return returnVal;

    }

    public String rev(final String binary) {
	String revString = "";
	int n = binary.length() - 1;
	while (n >= 0) {
	    revString += binary.charAt(n);
	    --n;
	}

	return revString;

    }

    public void toBinary(int n) {

	String binary = "";
	if (n == 0) {
	    binary += "0";
	} else {
	    while (n > 0) {
		if (n % 2 == 0) {
		    binary += "0";
		} else {
		    binary += "1";

		}
		n = n / 2;
	    }

	}
	this.binaryVal = this.rev(binary);
	this.bits = this.binaryVal.length();
    }

    public String getBinaryVal() {
	return this.binaryVal;
    }

    public int getNumber() {
	return this.fibNumber;
    }

}
