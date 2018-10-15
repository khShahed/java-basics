package multithreading;

import java.util.Random;

public class UsingThread extends Thread {
    public void run(){
        System.out.println("UsingThread thread is running...");
        System.out.println("Thread Name -> " + Thread.currentThread().getName());
        Random random = new Random();
        int waitingTime = 0;
        for (int i=1; i <= 10; i++) {
            waitingTime = random.nextInt(100);
            try {
                Thread.sleep(waitingTime);
            } catch (Exception e){

            }
            System.out.println(i + " -> \t\t UsingThread  -> " + waitingTime);
        }
    }
}
