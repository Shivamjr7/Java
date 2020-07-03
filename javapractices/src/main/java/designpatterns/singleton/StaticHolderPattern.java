package designpatterns.singleton;

public class StaticHolderPattern {

	private StaticHolderPattern() {

	}

	private static class Holder {
		static final StaticHolderPattern instance = new StaticHolderPattern();
	}

	public static StaticHolderPattern getInstance() {
		return Holder.instance;
	}

}
