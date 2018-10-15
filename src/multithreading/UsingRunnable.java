package multithreading;

import java.util.Random;

public class UsingRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("UsingRunnable thread is running...");
        System.out.println("Thread Name -> " + Thread.currentThread().getName());
        Random random = new Random();
        int waitingTime = 0;
        for (int i=1; i <= 10; i++) {
            waitingTime = random.nextInt(100);
            try {
                Thread.sleep(waitingTime);
            } catch (Exception e){

            }
            System.out.println(i + " -> UsingRunnable  -> " + waitingTime);
        }
    }
}
