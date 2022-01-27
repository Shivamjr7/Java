package threads;

import util.CommonUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InterruptExample {


    public static void main(String[] args) {

        Thread t1 = new Thread(new AnotherThread());
        t1.start();

        CommonUtil.delay(1000);


        // will ask t1 thread to be stopped although t1 may or may not choose to stop
        t1.interrupt();



        CommonUtil.delay(2000);

    }
}

class AnotherThread implements Runnable
{
    @Override
    public void run() {

        for(int i =0;i<10000;i++)
        {

            if(Thread.currentThread().isInterrupted())
            {
                System.out.println("Thread interrupted");
            }

            //this method resets the interrput flag
            Thread.interrupted();
        }

    }
}
