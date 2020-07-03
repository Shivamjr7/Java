package threads;

public class DeadLockThreads {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Thread1());
		Thread t2 = new Thread(new Thread2());
		
		t1.start();
		t2.start();

	}

}

class Thread1 implements Runnable {
	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName() + " is running now");
		synchronized (String.class) {
			
			System.out.println("Acquiring String lock -->" + Thread.currentThread().getName());
			for (int i = 0; i < 5; i++) {
				System.out.println("i --> " + i);
			}

			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (Object.class) {
				System.out.println("Acquiring Object lock -->" + Thread.currentThread().getName());
			}
		}
	}

}

class Thread2 implements Runnable {
	@Override
	public void run() {

		synchronized (Object.class) {
			System.out.println("Acquiring Object lock -->" + Thread.currentThread().getName());

			for (int i = 0; i < 5; i++) {
				System.out.println("j --> " + i);
			}

			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized(String.class)
			{
				System.out.println("Acquiring String lock -->" + Thread.currentThread().getName());
			}
		}

	}
}