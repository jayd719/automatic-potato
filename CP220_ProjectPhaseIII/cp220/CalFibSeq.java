
/**
 *
 */

import java.util.LinkedList;

/**
 *
 */
@SuppressWarnings("serial")
public class CalFibSeq extends LinkedList<FibNumber> {

    CalFibSeq() {
	int i = 0;
	while (i < 10) {
	    this.add(new FibNumber(i));
	    i++;
	}

    }

}
