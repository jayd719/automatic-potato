package cp213;

/**
 * @author Your name and id here
 * @version 2023-05-23
 */
public class Strings {
    // Constants
    public static final String VOWELS = "aeiouAEIOU";
    public static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Determines if string is a "palindrome": a word, verse, or sentence (such as
     * "Able was I ere I saw Elba") that reads the same backward or forward. Ignores
     * case, spaces, digits, and punctuation in the string parameter s.
     *
     * @param string a string
     * @return true if string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(final String string) {
	boolean isPalin = true;
	int i = 0;
	String working = "";
	while (i < string.length()) {
	    if (Character.isLetter(string.charAt(i)) == true) {
		working += (string.charAt(i));
	    }
	    i += 1;
	}
	working = working.toLowerCase();
	int n = working.length() - 1;
	i = 0;
	while ((i < n) && isPalin == true) {
	    if (working.charAt(i) != working.charAt(n)) {
		isPalin = false;
	    }
	    i += 1;
	    n -= 1;

	}
	return isPalin;
    }

    /**
     * Determines if name is a valid Java variable name. Variables names must start
     * with a letter or an underscore, but cannot be an underscore alone. The rest
     * of the variable name may consist of letters, numbers and underscores.
     *
     * @param name a string to test as a Java variable name
     * @return true if name is a valid Java variable name, false otherwise
     */
    public static boolean isValid(final String name) {

	boolean isValid = true;
	if ((Character.isDigit(name.charAt(0)) == true) || (name.length() == 1) && (name.charAt(0) == '_')) {
	    isValid = false;
	}

	return isValid;
    }

    /**
     * Converts a word to Pig Latin. The conversion is:
     * <ul>
     * <li>if a word begins with a vowel, add "way" to the end of the word.</li>
     * <li>if the word begins with consonants, move the leading consonants to the
     * end of the word and add "ay" to the end of that. "y" is treated as a
     * consonant if it is the first character in the word, and as a vowel for
     * anywhere else in the word.</li>
     * </ul>
     * Preserve the case of the word - i.e. if the first character of word is
     * upper-case, then the new first character should also be upper case.
     *
     * @param word The string to convert to Pig Latin
     * @return the Pig Latin version of word
     */
    public static String pigLatin(String word) {

	if (VOWELS.indexOf(word.charAt(0)) != -1) {
	    word = word + "way";
	} else {
	    if (ALPHA.indexOf(word.charAt(0)) != -1) {

		word = (word.substring(1, 2).toUpperCase()) + (word.substring(2) + word.charAt(0) + "ay").toLowerCase();

	    } else {
		word = (word.substring(1) + word.charAt(0) + "ay").toLowerCase();
	    }

	}
	return word;
    }

}
