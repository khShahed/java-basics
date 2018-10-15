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
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//            String message = (String) dataInputStream.readUTF();
//            System.out.println("Server -- Message -> " + message);
//            serverSocket.close();

            String messageFromClient = "", reply;
            while (!messageFromClient.equals("stop")) {
                messageFromClient = dataInputStream.readUTF();
                System.out.println("Server -- Message from client -> " + messageFromClient);

                System.out.println("Server: ");
                reply = bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();
            }
            System.out.println("*** Closing Server ***");
            dataInputStream.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println("*************************************");
            System.out.println("Error --> " + e);
            System.out.println("*************************************");
        }
    }
}
