package SecureFileTransfer.sender;

import java.io.*;
import java.net.Socket;
import SecureFileTransfer.crypto.AESUtil;

public class SenderMain {

    private static final String SECRET_KEY = "aliiakbarkhan";

    public static void main(String[] args) throws Exception {

        File file = new File("test.txt");
        FileInputStream fis = new FileInputStream(file);

        byte[] fileData = fis.readAllBytes();
        fis.close();

        byte[] encryptedData = AESUtil.encrypt(fileData, SECRET_KEY);

        Socket socket = new Socket("123.123.132.12", 4000);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        out.writeInt(encryptedData.length);
        out.write(encryptedData);

        socket.close();
        System.out.println("Encrypted file sent.");
    }
}
