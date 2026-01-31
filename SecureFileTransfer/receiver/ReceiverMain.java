package SecureFileTransfer.receiver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import SecureFileTransfer.crypto.AESUtil;

public class ReceiverMain {

    private static final String SECRET_KEY = "aliiakbarkhan";

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Receiver waiting...");

        Socket socket = serverSocket.accept();
        DataInputStream in = new DataInputStream(socket.getInputStream());

        int length = in.readInt();
        byte[] encryptedData = new byte[length];
        in.readFully(encryptedData);

        byte[] decryptedData = AESUtil.decrypt(encryptedData, SECRET_KEY);

        FileOutputStream fos = new FileOutputStream("received.txt");
        fos.write(decryptedData);

        fos.close();
        socket.close();
        serverSocket.close();

        System.out.println("File decrypted and saved.");
    }
}
