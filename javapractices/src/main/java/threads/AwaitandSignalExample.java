package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitandSignalExample {


    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public static void main(String[] args) {


        AwaitandSignalExample obj = new AwaitandSignalExample();
        Thread t1 = new Thread(()->obj.method1());
        Thread t2 = new Thread(()-> obj.method2());

        t1.start();
        t2.start();
    }

    public void method1() {
        lock.lock();
        try {
            condition.await();
            System.out.println("After await");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void method2() {
        lock.lock();
        System.out.println("Signalling thread now ");
        condition.signal();
        lock.unlock();
    }


}
