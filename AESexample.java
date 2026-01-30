import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class AESexample {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        //input from keyboard
        Scanner scn = new Scanner(System.in);
        String plainText = scn.nextLine();

        //generate iur key for an algorithm

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");

        keyGenerator.init(256); //keysize

        //secret key
        SecretKey secretKey = keyGenerator.generateKey();

        //AES cipher instance
        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        //Start encyprithion
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

        //encode this encyprtion data in base64 format for more readability
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

        System.out.println("Encrypted text using (AES) " + encryptedText);

        //let's decode as well
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        //decrypt the encoded text
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));

        //convert the decrypted bytes back to plaintext

        String plainTextDecoded = new String(decryptedBytes);
        System.out.println("DECRYPTED TEXT USING AES IS : "+plainTextDecoded);
        scn.close();
    }
}
