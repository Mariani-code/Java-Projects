// Author Omeed Mariani

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		//throw new RuntimeException("method not implemented");
		boolean boundary = false; 
		for (int ix =0; ix<plainText.length();ix++) {
			if(plainText.charAt(ix)>=LOWER_BOUND && plainText.charAt(ix) <= UPPER_BOUND)
				boundary=true; 
		}
		return boundary;
		// this will return true only if all the characters are within the bounds we've set from the cipher
		//Omeed Mariani
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		//throw new RuntimeException("method not implemented");
		String encryptedText=""; 
		if(stringInBounds(plainText)) {
			for (int ix=0;ix<plainText.length();ix++)
			{
				char thisChar = plainText.charAt(ix);
				int encryptedCharint = ((int)thisChar+key); 
				while (encryptedCharint > UPPER_BOUND)
				{
					encryptedCharint-=RANGE; 
				}
				encryptedText+=(char)encryptedCharint;
			}
		}
		return encryptedText; 
		// This will encrypt the string using cesar
		//Omeed Mariani
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */ 
	public static String encryptBellaso(String plainText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		String encryptedText =""; 
		int bellasoStrLength = bellasoStr.length();
		for (int ix=0; ix<plainText.length();ix++) {
			char thisChar = plainText.charAt(ix); 
			int encryptedCharint= ((int)thisChar+(int)bellasoStr.charAt(ix%bellasoStrLength)); 
			while (encryptedCharint >(int)UPPER_BOUND){
				encryptedCharint-=RANGE;
			}
			encryptedText+=(char)encryptedCharint; 
		}
		return encryptedText; 
	}
	// This will encrypt the string using bellaso cypher
	//Omeed Mariani
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		//throw new RuntimeException("method not implemented");
		String decryptedText ="";
		for (int ix=0; ix <encryptedText.length();ix++) {
			char thisChar = encryptedText.charAt(ix);
			int decryptedCharint = ((int)thisChar-key);
			while (decryptedCharint <LOWER_BOUND) {
				decryptedCharint+=RANGE; 
			}
			decryptedText+=(char)decryptedCharint; 
		}
		return decryptedText;
	}
	// This will decrypt the Cesar Cypher String
	//Omeed Mariani
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		String decryptedText ="";
		int bellasoStrLength = bellasoStr.length(); 
		for (int ix =0;ix<encryptedText.length();ix++) {
			char thisChar = encryptedText.charAt(ix);
			int decryptedCharint = ((int)thisChar-(int)bellasoStr.charAt(ix%bellasoStrLength));
			while (decryptedCharint < (int)LOWER_BOUND) {
				decryptedCharint +=RANGE;
			}
			decryptedText+=(char)decryptedCharint; 
		}
		return decryptedText; 
	}
}
// This will decrypt the Bellaso Cypher String
//Omeed Mariani

