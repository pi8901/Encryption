package app;

/**
 * Vigenere encryption class
 * 
 * @version 1.0
 * @author pi8901
 * @since 21.05.2021
 */

public class Vigenere {

	public static void main(String[] args) {
		System.out.println(encrypt("PROGRAMMIEREN", "ABC"));
	}

	/**
	 * Vigenere encryption method
	 * @param word Word to encrypt
	 * @param key Encryption key
	 * @return Encrypted word
	 */
	public static String encrypt(String word, String key) {
		Caesar c = new Caesar();
		String fittedKey = matchKey(word.length(), key);
		String out = "";
		for (int i = 0; i < word.length(); i++) {
			out = out + c.enc(word.charAt(i) + "", ((int) fittedKey.charAt(i) - 64));
		}
		return out;
	}

	/**
	 * Matches key length with word length
	 * @param len Length of word to encrypt
	 * @param key Encryption key
	 * @return New Encryption key
	 */
	public static String matchKey(int len, String key) {
		String out = "";
		for (int i = 0; i < len ; i++) {
			out = out + key.charAt(i % key.length());
		}
		return out;
	}
}
