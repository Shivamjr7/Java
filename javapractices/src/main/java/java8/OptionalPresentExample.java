package java8;

import java.util.Optional;

public class OptionalPresentExample {


    public static void main(String[] args) {


        Optional<String> optional = Optional.ofNullable("Shivam");

        //isPresent : to check if the value is present

        if(optional.isPresent())
        {
            System.out.println(optional.get());
        }

        //ifPresent : if value is present , then you can do additional operation with the value
        // takes a consumer : consumer of the value coming
        optional.ifPresent(System.out::println);
    }



}
