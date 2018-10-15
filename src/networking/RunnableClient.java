package networking;

import java.io.DataOutputStream;
import java.net.Socket;

public class RunnableClient implements Runnable {
    @Override
    public void run() {
        try {
            Socket socket = new Socket("localhost",6666);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("Hello from client");
            dataOutputStream.flush();
            dataOutputStream.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("*************************************");
            System.out.println("Error --> " + e);
            System.out.println("*************************************");
        }
    }
}
