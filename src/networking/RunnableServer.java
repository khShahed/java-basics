package networking;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class RunnableServer implements Runnable {
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            String message = (String) dataInputStream.readUTF();
            System.out.println("Server -- Message -> " + message);
            serverSocket.close();
        } catch (Exception e) {
            System.out.println("*************************************");
            System.out.println("Error --> " + e);
            System.out.println("*************************************");
        }
    }
}
