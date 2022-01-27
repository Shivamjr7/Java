package threads;

import java.util.concurrent.*;

public class CallableExample implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {

        System.out.println("Running in thread : " + Thread.currentThread().getName());
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            count++;
        }
        return count;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CallableExample tasktorunInParallel = new CallableExample();

        Future<Integer> placeHolder = executorService.submit(tasktorunInParallel);

        //blocking call
        int count = placeHolder.get();

        System.out.println("count : " + count);

    }
}
