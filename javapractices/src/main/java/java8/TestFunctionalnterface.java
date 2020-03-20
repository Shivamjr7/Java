package java8;

public class TestFunctionalnterface {

	public static void main(String[] args) {

		FI cal = (a, b) -> {
			return a + b;
		};
		cal.add(2, 3);

		// already existing FI

		//creating a runnable using lambda
		Runnable runnnable = () -> {
			for (int i = 0; i < 5; i++)
				;
		};

		//starting a thread using runnable
		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName());
			}
				;
		}).start();
	}

}

@FunctionalInterface
interface FI {
	public int add(int a, int b);

	// can add object class methods
	@Override
	boolean equals(Object obj);

	// can add default methods as well
	default void hello() {
		System.out.println("Hello there !");
	}

	// can add static methods as well
	static int sub(int a, int b) {
		return -1;
	}
}