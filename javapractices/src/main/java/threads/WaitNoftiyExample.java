package threads;

public class WaitNoftiyExample {


    private static Object sharedObject = new Object();
    private static volatile boolean readFlag = false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Reader(sharedObject, readFlag));
        Thread thread2 = new Thread(new Writer(sharedObject, readFlag));
        thread1.start();
        thread2.start();
    }

}

class Reader implements Runnable {
    Object obj;
    boolean readFlag;

    Reader(Object obj, boolean readFlag) {
        this.obj = obj;
        this.readFlag = readFlag;
    }

    @Override
    public void run() {
        //reading
        synchronized (obj) {
            try {
                //should be called in a while loop to avoid spurious wake up
                if (!readFlag) {
                    System.out.println("Reader thread triggered first , have to wait");
                    obj.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("Reading now ....");
            }
            System.out.println("Reading completed ....");
            obj.notify();

        }
    }
}

class Writer implements Runnable {


    Object obj;
    boolean writeFlag;

    Writer(Object obj, boolean writeFlg) {
        this.obj = obj;
        this.writeFlag = writeFlg;
    }

    @Override
    public void run() {

        synchronized (obj) {

            // should
            if (!writeFlag) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Writer thread is writing");
                }
            }
            writeFlag = true;
            System.out.println("Notifying reader thread to read now");
            obj.notify();

        }


    }
}