package app;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Simple RSA decrypt and encrypt
 * @author EF2
 * @version 1.0
 * @since 07.05.2021
 *
 */
public class RSA 
{
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) 
	{
		KeyPairGenerator generator = null;
		try 
		{
			generator = KeyPairGenerator.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
		generator.initialize(2048);
		KeyPair pair = generator.generateKeyPair();
		PrivateKey privateKey = pair.getPrivate();
		PublicKey publicKey = pair.getPublic();	
		
		try
		{
			byte[] code = enc("Hallo", publicKey);
			System.out.println("Verschlüsselt: " + Base64.getEncoder().encodeToString(code));
			System.out.println("Entschlüsselt: " + dec(code, privateKey));
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Encryption
	 * @param msg message to encrypt
	 * @param publicKey
	 * @return encrypted message
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] enc(String msg, PublicKey publicKey) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
	{
		Cipher encryptCipher = Cipher.getInstance("RSA");
		encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] secretMessageBytes = msg.getBytes(StandardCharsets.UTF_8);
		byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);
		return encryptedMessageBytes;
	}
	
	/**
	 * Decryption
	 * @param msg message to decrypt
	 * @param privateKey
	 * @return dectypted message
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	private static String dec(byte[] msg, PrivateKey privateKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException 
	{
		Cipher decryptCipher = Cipher.getInstance("RSA");
		decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] decryptedMessageBytes = decryptCipher.doFinal(msg);
		String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);
		return decryptedMessage;
	}
}
