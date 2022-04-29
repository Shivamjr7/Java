package java8.streams;

import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {

		
		/**
		 * This will sort the stream and find first and present 
		 * findFirst returns a Optional
		 * ifPresent takes consumer argument
		 */
		Stream.of("Messi", "Ronaldo", "Kaka", "Rooney").
		sorted().
		findFirst().
		ifPresent(System.out::println);

		
		
	
	}

}
