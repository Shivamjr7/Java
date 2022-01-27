package threads;

import util.CommonUtil;

import java.util.concurrent.*;

public class CyclicBarrierExample {

    public static void main(String[] args) {


        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService service = Executors.newFixedThreadPool(4);


        service.submit(new ServiceClassNew(barrier));
        service.submit(new ServiceClassNew(barrier));
        service.submit(new ServiceClassNew(barrier));

        System.out.println("Main thread resumed");
    }
}


class ServiceClassNew implements Runnable {


    private CyclicBarrier barrier;

    ServiceClassNew(CyclicBarrier barrier) {
        this.barrier   = barrier;
    }

    @Override
    public void run()  {


        System.out.println("Thread : " + Thread.currentThread().getName() + " started");
        CommonUtil.delay(5000);

        try {
            //after all threads have come to this point , they will be able to resume
            barrier.await();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Thread : " + Thread.currentThread().getName() + " completed");

    }
}