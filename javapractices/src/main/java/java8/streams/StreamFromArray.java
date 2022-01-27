package streams;

import java.util.stream.Stream;

public class StreamFromArray {

	public static void main(String[] args) {

		String[] arr = { "Messi", "Ronaldo", "Neymar" };

		Stream.of(arr).filter(i -> i.startsWith("M") || i.startsWith("R")).
		sorted().
		forEach(System.out::println);

	}

}
