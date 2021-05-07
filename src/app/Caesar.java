package app;
/**
 * Caesar encryption and decryption class
 * 
 * @version 1.0
 * @author pi890
 * @since 07.05.2021
 */

public class Caesar {

	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(babel("ÄÖÜäöü "));
	}

	/**
	 * Caesar encryption
	 * 
	 * @param in  String to encrypt
	 * @param key Offset
	 * @return encrypted String
	 */
	public static String enc(String in, int key) {
		String out = "";
		for (int i = 0; i < in.length(); i++) 
		{
			out = out + (char) ((in.charAt(i) + key - 65) % 26 + 65);
		}
		return out;
	}
	
	public static String babel(String in)
	{
		in = in.replace("Ä", "ae");
		in = in.replace("Ö", "oe");
		in = in.replace("Ü", "ue");
		
		return in;	
	}

	/**
	 * 
	 * @param in  String to decrypt
	 * @param key offset
	 * @return decrypted key
	 */
	public static String dec(String in, int key) {
		String out = "";
		for (int i = 0; i < in.length(); i++) {
			if ((int) in.charAt(i) - key < 65) {
				out = out + (char) (90 - (64 - ((int) in.charAt(i) - key)));
			} else {
				out = out + (char) ((int) in.charAt(i) - key);
			}
		}
		return out;
	}
}