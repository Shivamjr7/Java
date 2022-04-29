package java8.streams;

import java.util.stream.IntStream;

public class InsStreamRange {

	public static void main(String[] args) {

		//range includes start but not end
		IntStream.range(0, 10).forEach(System.out::println);
	
		System.out.println("Skipping a number");
		
		//IntStream with skip
		// This will skip n numbers from the start
	
		IntStream.range(1, 10).skip(1).forEach(System.out::println);

		// sum operation - terminal operation
		
		int sum = IntStream.range(1, 10).sum();
		System.out.println(sum);
		
	}

}
