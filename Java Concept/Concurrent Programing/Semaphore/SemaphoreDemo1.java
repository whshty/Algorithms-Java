import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


public class SemaphoreDemo1 {
    public static void main(String[] args) {
        // Thread pool
        ExecutorService exec = Executors.newCachedThreadPool();
        // 5 Thread at the same time
        final Semaphore semp = new Semaphore(5);
        for( int index = 0 ; index < 20 ; index++){
            final int No = index;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        semp.acquire();
                        System.out.println("Access: " + No);
                        Thread.sleep((long) (Math.random() * 10000));
                        semp.release();
                        System.out.println("The number of available permits is " + semp.availablePermits());
                    } catch ( InterruptedException e ){
                        e.printStackTrace();
                    }

                }
            };
            exec.execute(run);
        }
        // exit thread poll
        exec.shutdown();
    }
}
