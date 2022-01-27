package threads;

import util.CommonUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {


    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(4);


        service.submit(new ServiceClass(latch));
        service.submit(new ServiceClass(latch));
        service.submit(new ServiceClass(latch));


        //until all 3 threads says countdown code will not execute beyond this
        latch.await();

        System.out.println("Main thread resumed");


    }
}


class ServiceClass implements Runnable {


    private CountDownLatch latch;

    ServiceClass(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {


        System.out.println("Thread : " + Thread.currentThread().getName() + " started");
        CommonUtil.delay(5000);
        System.out.println("Thread : " + Thread.currentThread().getName() + " completed");
        latch.countDown();
    }
}

