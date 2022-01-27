package threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    private ReentrantReadWriteLock.ReadLock writelock = lock.readLock();


    private List<String> users = new ArrayList<>(
            Arrays.asList("Shivam", "Asif", "Abhinav", "Gaurav"));

    public static void main(String[] args) {

        ReadWriteLock obj = new ReadWriteLock();

        Thread t1 = new Thread(() -> obj.readResource());
        Thread t2 = new Thread(() -> obj.readResource());
        Thread t3 = new Thread(() -> obj.readResource());
        Thread t4 = new Thread(() -> obj.writeResource());
        Thread t5 = new Thread(() -> obj.writeResource());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }


    void readResource() {

        readLock.lock();
        try {
            System.out.println("Reading users in thread " + Thread.currentThread().getName());

            System.out.println(users);
        } finally {
            readLock.unlock();
        }

    }

    void writeResource()
    {
        writelock.lock();

        try
        {
            System.out.println("Writing users in thread " + Thread.currentThread().getName());
            users.add("Shrikant");
        }
        finally {
            writelock.unlock();
        }

    }
}
