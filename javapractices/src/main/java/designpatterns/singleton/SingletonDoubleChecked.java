package designpatterns.singleton;

public class SingletonDoubleChecked {

	private static volatile SingletonDoubleChecked instance = null;

	private SingletonDoubleChecked() {

	}

	public static SingletonDoubleChecked getInstance() {
		if (instance == null) {
			synchronized (SingletonDoubleChecked.class) {
				if (instance == null) {
					instance = new SingletonDoubleChecked();
				}
			}
		}
		return instance;
	}

}
