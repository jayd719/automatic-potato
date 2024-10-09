package cp213;

/**
 * @author Jashandeep Singh
 * @version 2023-09-15
 */
public class Cipher {
    // Constants
    public static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int ALPHA_LENGTH = ALPHA.length();

    /**
     * Encipher a string using a shift cipher. Each letter is replaced by a letter
     * 'n' letters to the right of the original. Thus for example, all shift values
     * evenly divisible by 26 (the length of the English alphabet) replace a letter
     * with itself. Non-letters are left unchanged.
     *
     * @param s string to encipher
     * @param n the number of letters to shift
     * @return the enciphered string in all upper-case
     */
    public static String shift(final String s, final int n) {
	String cipheredText = "";
	String s1 = s.toUpperCase();
	int i = 0;
	while (i < s.length()) {
	    if (Character.isLetter(s1.charAt(i)) == true) {
		int index = -1;
		int k = 0;
		while (index == -1) {
		    if (s1.charAt(i) == ALPHA.charAt(k)) {
			index = k;
		    }
		    k += 1;
		}
		index += n;
		if (index >= 26) {
		    index = index - 26;
		}
		cipheredText += ALPHA.charAt(index);

	    } else {
		cipheredText += s1.charAt(i);
	    }

	    i += 1;
	}

	return cipheredText;
    }

    /**
     * Encipher a string using the letter positions in ciphertext. Each letter is
     * replaced by the letter in the same ordinal position in the ciphertext.
     * Non-letters are left unchanged. Ex:
     *
     * <pre>
    Alphabet:   ABCDEFGHIJKLMNOPQRSTUVWXYZ
    Ciphertext: AVIBROWNZCEFGHJKLMPQSTUXYD
     * </pre>
     *
     * A is replaced by A, B by V, C by I, D by B, E by R, and so on. Non-letters
     * are ignored.
     *
     * @param s          string to encipher
     * @param ciphertext ciphertext alphabet
     * @return the enciphered string in all upper-case
     */
    public static String substitute(final String s, final String ciphertext) {

	String cipheredText = "";
	int i = 0;
	while (i < s.length()) {
	    if (Character.isLetter(s.charAt(i)) == true) {
		int index = ALPHA.indexOf(s.charAt(i));
		cipheredText += ciphertext.charAt(index);

	    } else {
		cipheredText += s.charAt(i);
	    }
	    i += 1;

	}

	return cipheredText;
    }

}
