package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class EvenOddSemaphore {

	public static void main(String[] args) {
		SharedPrinterNew sp = new SharedPrinterNew();
		// Starting two threads
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new EvenNumProducerNew(sp, 10));
		executor.execute(new OddNumProducerNew(sp, 10));
		executor.shutdown();
	}
}

// Shared class used by both threads
class SharedPrinterNew {
	boolean evenFlag = false;
	// 2 semaphores
	Semaphore semEven = new Semaphore(0);
	Semaphore semOdd = new Semaphore(1);

	// Method for printing even numbers
	public void printEvenNum(int num) {
		try {
			semEven.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num);
		semOdd.release();
	}

	// Method for printing odd numbers
	public void printOddNum(int num) {
		try {
			semOdd.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num);
		semEven.release();

	}
}

// Thread Class generating Even numbers
class EvenNumProducerNew implements Runnable {
	SharedPrinterNew sp; 
	int index;

	EvenNumProducerNew(SharedPrinterNew sp, int index) {
		this.sp = sp;
		this.index = index;
	}

	@Override
	public void run() {
		for (int i = 2; i <= index; i = i + 2) {
			sp.printEvenNum(i);
		}
	}
}

// Thread Class generating Odd numbers
class OddNumProducerNew implements Runnable {
	SharedPrinterNew sp;
	int index;

	OddNumProducerNew(SharedPrinterNew sp, int index) {
		this.sp = sp;
		this.index = index;
	}

	@Override
	public void run() {
		for (int i = 1; i <= index; i = i + 2) {
			sp.printOddNum(i);
		}
	}
}
