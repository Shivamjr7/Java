package java8.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class FunctionalInterfaceExample {


    public static void main(String[] args) {

        // consumer example


        List<String> list = new ArrayList<>();

        list.add("Shivam");
        Consumer<String> consumer = (input)-> {
            System.out.println(input);
        };

        Consumer<String> consumer2 = (i)-> System.out.println("hello world" + i);

        list.forEach(consumer2.andThen(consumer));

        // Biconsumer

        BiConsumer<String , Integer> biConsumer = (s1,i1)->{


        };
        Map<String, Integer> map = new HashMap<>();
        map.forEach(biConsumer);

        consumer.andThen(consumer2).accept("mehandi");
    }
}
