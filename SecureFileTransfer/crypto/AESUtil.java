package SecureFileTransfer.crypto;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class AESUtil {

    private static final String ALGO = "AES";

    public static byte[] encrypt(byte[] data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, getKey(key));
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.DECRYPT_MODE, getKey(key));
        return cipher.doFinal(data);
    }

    private static SecretKeySpec getKey(String key) {
        byte[] keyBytes = Arrays.copyOf(key.getBytes(), 16); // 128-bit
        return new SecretKeySpec(keyBytes, ALGO);
    }
}
