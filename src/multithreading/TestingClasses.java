package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestingClasses {
    public static void TestClasses(){

//        TestDaemonThread daemonThread = new TestDaemonThread();
//        daemonThread.setDaemon(true);
//        daemonThread.start();
//
//        UsingThread usingThread = new UsingThread();
//        usingThread.setPriority(Thread.MIN_PRIORITY); // MIN_PRIORITY = 1
//        usingThread.start();
//
//        UsingRunnable usingRunnable = new UsingRunnable();
//        Thread thread = new Thread(usingRunnable);
//        thread.setPriority(Thread.MAX_PRIORITY); // MAX_PRIORITY = 10
//        thread.start();

        // Thread pool
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        for (int i=0; i < 100; i++) {
//            executorService.execute(new WorkerThread(""+i));
//        }
//
//        executorService.shutdown();
//        while (!executorService.isTerminated()){}
//        System.out.println("Finished all thread");

        // Thread Group

//        ThreadGroup threadGroup = new ThreadGroup("Parent Threadgroup");
//
//        UsingRunnable runnable = new UsingRunnable();
//
//        Thread thread1 = new Thread(threadGroup, runnable, "one");
//        thread1.start();
//        Thread thread2 = new Thread(threadGroup, runnable, "two");
//        thread2.start();
//        Thread thread3 = new Thread(threadGroup, runnable, "three");
//        thread3.start();
//
//        System.out.println("ThteadGroup Name -> " + threadGroup.getName());
//        threadGroup.list();

        // Shutdown Hook
//        Runtime runtime = Runtime.getRuntime();
////        runtime.addShutdownHook(new UsingThread());
//        runtime.addShutdownHook(new Thread(){
//              public void run(){
//                  System.out.println("shut down hook task completed..");
//              }
//          }
//        );
//
//        System.out.println("Now main sleeping... press ctrl+c to exit");
//        try{
//            Thread.sleep(3000);
//        }catch (Exception e) {}

        // Multitasking With anonymous Thread Class
//        Thread t1 = new Thread(){
//          public void run(){
//              System.out.println("Anonymous thread 1 running...");
//          }
//        };
//        Thread t2 = new Thread(){
//          public void run(){
//              System.out.println("Anonymous thread 2 running...");
//          }
//        };
//        t1.start();
//        t2.start();

        // Multitasking With anonymous Runnable
//        Runnable r1=new Runnable(){
//            public void run(){
//                System.out.println("task one");
//            }
//        };
//
//        Runnable r2=new Runnable(){
//            public void run(){
//                System.out.println("task two");
//            }
//        };
//
//        Thread t3=new Thread(r1);
//        Thread t4=new Thread(r2);
//
//        t3.start();
//        t4.start();

        // Using Callable
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futureList = new ArrayList<>();
        for (int i=0; i < 100; i++) {
            futureList.add(executorService.submit(new UsingCallable()));
        }

        futureList.forEach(future -> {
            try {
                Integer integer = future.get();
                System.out.println(integer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
        System.out.println("Finished all thread");

    }
}
