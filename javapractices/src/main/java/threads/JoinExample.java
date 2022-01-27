package threads;

public class JoinExample {


    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(()->{
            for(int i =0;i<50;i++)
            {
                System.out.println("Running thread1 : "+i);
            }
        });

        Thread thread2 = new Thread(()->{
            for(int i =0;i<50;i++)
            {
                System.out.println("Running thread2 : "+i);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("resuming main thread....");
    }
}
