package java8;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {


    public static void main(String[] args) {


        /**
         * Takes 2 arguments and returns void
         */
        BiConsumer<String, String> biConsumer = (s1, s2) -> {
            System.out.println((s1 + " " + s2).toUpperCase());
        };

        biConsumer.accept("a", "bientot");


        List<String> names = new ArrayList<>(Arrays.asList("shivam", "asif", "abhinav", "gaurav"));


        /**
         * for each takes a biconsumer as well
         */
        names.forEach(name -> biConsumer.accept(name, name));

    }
}
