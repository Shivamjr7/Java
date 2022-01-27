package threads;

import util.CommonUtil;

public class RaceConditionExample {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(getRunnable(counter, "Thread1 final count :"));
        Thread thread2 = new Thread(getRunnable(counter, "Thread2 final count :"));

        thread1.start();
        thread2.start();

    }


    private static Runnable getRunnable(Counter counter , String message)
    {
        return ()->{


            for(int i = 0; i <1000;i++)
            {
                counter.incAndget();
            }
            System.out.println(message + counter.get());
        };
    }
}


class Counter{
    private long count =0;


    public long incAndget()
    {
        this.count++;
        return this.count;
    }

    public long get()
    {
        return this.count;
    }
}