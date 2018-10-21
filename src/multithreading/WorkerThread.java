package multithreading;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.omg.CORBA.TCKind;

public class WorkerThread implements Runnable {
    private String message;
    private static int instanceCount = 0;
    public WorkerThread(String s) {
        System.out.println("WorkerThread  -  instance no -> " + instanceCount++);
        this.message = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Start). Message -> " + this.message);
        processMessage();
        System.out.println(Thread.currentThread().getName() + " (End).");
    }

    private void processMessage(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){

        }
    }
}
