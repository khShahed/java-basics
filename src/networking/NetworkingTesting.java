package networking;

public class NetworkingTesting {
    public static void NetworkingTest(){
        Thread server = new Thread(new RunnableServer());
        server.start();

        Thread client = new Thread(new RunnableClient());
        client.start();
    }
}
