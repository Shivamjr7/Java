package inheritance;

public class CovariantReturnType extends SuperClass {

	public static void main(String[] args) {

	}

	/**
	 * covariant return type
	 */
	@Override
	int sample() {
		byte a = 1;
		return a;
	}

	SuperClass method() {
		return new CovariantReturnType();
	}
}

class SuperClass {

	int sample() {
		return 1;
	}

	SuperClass method() {
		return new SuperClass();
	}
}