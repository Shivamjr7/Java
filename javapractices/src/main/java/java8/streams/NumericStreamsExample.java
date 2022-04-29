package java8.streams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamsExample {


    public static void main(String[] args) {

        System.out.println(IntStream.rangeClosed(1,6).sum());
        System.out.println(IntStream.range(1,6).sum());


        OptionalInt maxoptionalInt = IntStream.rangeClosed(1,50).max();
        System.out.println(maxoptionalInt.isPresent() ? maxoptionalInt.getAsInt(): 0);

        OptionalInt min = IntStream.rangeClosed(1,50).min();
        System.out.println(min.isPresent()? min.getAsInt():0);

        OptionalLong maxLong = LongStream.rangeClosed(1,50).max();
        System.out.println(maxLong.isPresent()?maxLong.getAsLong():0);

        OptionalDouble optionalDouble = IntStream.rangeClosed(1,50).average();
        System.out.println(optionalDouble.isPresent()? optionalDouble.getAsDouble():0);
    }
}
