package java8.streams;

import java.util.stream.IntStream;


public class IntStreamExample {

	public static void main(String[] args) {
		
		
		//IntStream with arrays
		int []arr= {3,1,3,4,5,6,7,9};
		
		int min = IntStream.of(arr).min().getAsInt(); // with empty array throws an exception
		int max = IntStream.of(arr).max().getAsInt(); // with empty array throws and exception
		
		System.out.println(min +" "+max);

		IntStream.of(arr).min().ifPresent(minnew ->System.out.println(minnew));
		
		
		System.out.println(IntStream.of(arr).average());
		System.out.println(IntStream.of(arr).count());
		System.out.println(IntStream.of(arr).distinct());
		
		
		IntStream.of(arr)
		.distinct()
		.sorted()
		.limit(3)
		.forEach(System.out::println);
		
	}

}
