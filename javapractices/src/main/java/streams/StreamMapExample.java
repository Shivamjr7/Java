package streams;

import java.util.Arrays;

public class StreamMapExample {

	public static void main(String[] args) {

		
		Arrays.stream(new int[] {1,2,3,4}).map(item -> item + 2).forEach(System.out::println);
		
		Arrays.stream(new int[] {1,2,3,4}).map(item -> item + 2).average().ifPresent(System.out::println);

		
		
	}

}
