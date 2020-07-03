package threads;

public class CustomThreadPoolExample {

	public static void main(String[] args) {
		
		
		CustomThreadPool pool = new CustomThreadPool(5);
		
		
		for(int i =0;i<5;i++)
		{
			pool.execute(new Task());
		}

	}

	
}

class Task implements Runnable {
	public void run() {

		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName());
		}

	}

}