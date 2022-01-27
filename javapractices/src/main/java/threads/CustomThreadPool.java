package threads;

import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {

    private final int poolsize;

    WorkerThread[] workers;
    private final LinkedBlockingQueue<Runnable> queue;

    CustomThreadPool(int nThreads) {
        this.poolsize = nThreads;
        queue = new LinkedBlockingQueue<Runnable>();
        workers = new WorkerThread[poolsize];
        for (int i = 0; i < poolsize; i++) {
            workers[i] = new WorkerThread();
            workers[i].start();
        }
    }

    public void execute(Runnable task) {
        synchronized (queue) {
            queue.add(task);
            queue.notify();
        }
    }

    public void shutdown() {
        System.out.println("Shutting down thread pool");
        for (int i = 0; i < poolsize; i++) {
            workers[i] = null;
        }
    }

    class WorkerThread extends Thread {
        Runnable task;

        @Override
        public void run() {


            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    task = (Runnable) queue.poll();

                    task.run();
                }
            }


        }
    }
}

