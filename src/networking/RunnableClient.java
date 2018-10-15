package networking;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class RunnableClient implements Runnable {
    @Override
    public void run() {
        try {
            Socket socket = new Socket("localhost",6666);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//            dataOutputStream.writeUTF("Hello from client");
//            dataOutputStream.flush();
//            dataOutputStream.close();
//            socket.close();

            String messageFromServer, replay = "";
            while (!replay.equals("stop")) {
                System.out.println("Client: ");
                replay = bufferedReader.readLine();
                dataOutputStream.writeUTF(replay);
                dataOutputStream.flush();

                messageFromServer = dataInputStream.readUTF();
                System.out.println("Client -- Message from Server -> " + messageFromServer);
            }
            System.out.println("### Closing Client ###");
            dataOutputStream.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("*************************************");
            System.out.println("Error --> " + e);
            System.out.println("*************************************");
        }
    }
}
