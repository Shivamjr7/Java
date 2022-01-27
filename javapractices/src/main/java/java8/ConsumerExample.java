package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {

        /**
         * Consumer takes an input and returns void
         * foreach takes a consumer
         */
        Consumer<String> stringConsumer = (s)->System.out.println(s.toUpperCase());

        stringConsumer.accept("hello");


        /**
         * consumer chaining
         */


        List<String> names = new ArrayList<>(Arrays.asList("shivam","asif","abhinav","gaurav"));

        Consumer<String> printNames = (student)->System.out.println(student);
        Consumer<String> changeToUppercase = (student)-> {
            System.out.println(student.toUpperCase());

        };

        names.forEach(printNames.andThen(changeToUppercase));



    }
}
