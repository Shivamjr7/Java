package java8.optional;

import java.util.Optional;

public class OptionalTest2 {

    public static void main(String[] args) {

        // Test 1
        System.out.println(ofNullableTest1().get());

        // Test 2
        System.out.println(ofNullabletest2().isPresent());
        // Test 3

        System.out.println(ofTest().get());
        // Test 4
        System.out.println(ofTest2().get());


    }

    public static  Optional<String> ofNullableTest1(){
        return Optional.ofNullable("Value");
    }

    public static Optional<String> ofNullabletest2(){
        return Optional.ofNullable(null);
    }

    public static Optional<String> ofTest(){
        return Optional.of("Valid Value");
    }

    public static  Optional<String> ofTest2(){
        return Optional.of(null);
    }
}
