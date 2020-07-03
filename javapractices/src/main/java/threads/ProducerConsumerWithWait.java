package threads;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerWithWait {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		Thread producer = new Thread(new Producer(list));
		Thread consumer = new Thread(new Consumer(list));

		producer.start();
		consumer.start();
	}

}

class Producer implements Runnable {
	List<Integer> list;
	int max = 2;

	Producer(List<Integer> list) {

		this.list = list;
	}

	@Override
	public void run() {

		for (int i = 0; i <= 10; i++) {
			try {
				produce(i);
			} catch (InterruptedException e) {
				System.out.println("Thread Interrupted");
			}
		}

	}

	void produce(int i) throws InterruptedException {
		synchronized (list) {
			while (list.size() == max) {
				System.out.println("Queue is full, producerThread is waiting for "
						+ "consumerThread to consume, sharedQueue's size= " + max);
				list.wait();
			}

			synchronized (list) {
				System.out.println("Produced " + i);
				list.add(i);
				Thread.sleep(1000);
				list.notify();
			}
		}
	}
}

class Consumer implements Runnable {

	List<Integer> list;

	Consumer(List<Integer> list) {

		this.list = list;
	}

	@Override
	public void run() {

		while (true) {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void consume() throws InterruptedException {

		synchronized (list) {
			// if sharedQuey is empty wait until producer produces.
			while (list.size() == 0) {
				System.out.println("Queue is empty, consumerThread is waiting for "
						+ "producerThread to produce, sharedQueue's size= 0");
				list.wait();
			}
		}

		synchronized (list) {
			Thread.sleep(1000);
			System.out.println("Consumed " + list.remove(0));
			list.notify();
		}
	}
}
