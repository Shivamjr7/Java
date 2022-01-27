package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecutorServiceExample {

    public static void main(String[] args) {

        ExecutorTask task = new ExecutorTask();
        //creating a fixed thread pool
        ExecutorService fixedThreadService = Executors.newFixedThreadPool(10);
        fixedThreadService.submit(task);

        ExecutorService singleThreadService = Executors.newSingleThreadExecutor();

        ExecutorService cachedservice = Executors.newCachedThreadPool();
        cachedservice.submit(task);

        ScheduledExecutorService scheduleService = Executors.newScheduledThreadPool(10);

        //task to run after after 10 seconds delay
        scheduleService.schedule(new ExecutorTask(),10, TimeUnit.SECONDS);

        // to run task after every 10 seconds
        scheduleService.scheduleAtFixedRate( new ExecutorTask(),15,10,TimeUnit.SECONDS);

        //to run after every 10 sec after previous task completes
        scheduleService.scheduleWithFixedDelay(new ExecutorTask(),15,10, TimeUnit.SECONDS);


        // this will initiate a shutdown and will not accept new tasks
        scheduleService.shutdown();
    }

}

class ExecutorTask implements  Runnable{
    @Override
    public void run() {

        IntStream.of(1,2,3,4,5,6,7,8,9,10)
                .forEach(System.out::println);

    }
}
