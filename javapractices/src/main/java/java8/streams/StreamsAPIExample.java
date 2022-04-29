package java8.streams;

import java.util.Random;
import java.util.stream.Stream;

public class StreamsAPIExample {

    public static void main(String[] args) {
        // of
        Stream<String> streams  = Stream.of("Shivam");

        //iterate
        Stream.iterate(1,a-> a+2)
        .limit(10).forEach(System.out::println);

        //generate
        Stream.generate(new Random()::nextInt)
        .limit(5).forEach(System.out::println);

    }
}
