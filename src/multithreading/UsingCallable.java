package multithreading;

import java.util.Random;
import java.util.concurrent.Callable;

public class UsingCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Random random = new Random();
        Thread.sleep(random.nextInt(1000));
        return random.nextInt(1000);
    }
}
