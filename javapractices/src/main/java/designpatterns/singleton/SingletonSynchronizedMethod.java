package designpatterns.singleton;

public class SingletonSynchronizedMethod {

	private static SingletonSynchronizedMethod instance = null;

	private SingletonSynchronizedMethod() {

	}

	public static synchronized SingletonSynchronizedMethod getInstance() {
		if (instance == null) {
			instance = new SingletonSynchronizedMethod();
		}

		return instance;
	}
}
