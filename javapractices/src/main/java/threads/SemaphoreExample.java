package threads;

import util.CommonUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class SemaphoreExample {


    public static void main(String[] args) {

        Semaphore lock = new Semaphore(3);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i =0;i<10;i++)
        {
            executorService.execute(new ApiCall(lock));
        }


    }


    static class ApiCall implements Runnable {
        Semaphore semaphore;

        ApiCall(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {


            //will allow max 2 threads to enter

            semaphore.acquireUninterruptibly(2);
            System.out.println(Thread.currentThread().getName() + " making api call");


            //simulate api call
            CommonUtil.delay(1000);
            semaphore.release(2);

            System.out.println(Thread.currentThread().getName() + " releasing resources");
        }
    }

}
