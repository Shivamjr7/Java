package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapExample {

    /**
     * Streams are data flowing in pipes
     * map function is used to transform the data
     * original data structure will not be mutated
     * map() will return another stream
     */


    public static void main(String[] args) {

        Integer[] integers = {1, 2, 3, 4, 5};

        List<Integer> integerList = Arrays.asList(integers);

        // Now if we want to double each element of list

        //Imperative way

        List<Integer> doubledlist = new ArrayList<>();

        for (int i = 0; i < integerList.size(); i++) {
            int newint = integerList.get(i) * 2;
            doubledlist.add(newint);

        }


        //Functional or declarative way - What we want
        //We want to double list


        List<Integer> functionalList = integerList.stream().map(ele -> ele * 2).collect(Collectors.toList());

        System.out.println(functionalList);



        //one more way

        Function<Integer,Integer> func = (x) -> x*2;
        List<Integer> newfuncList = integerList.stream().map(func).collect(Collectors.toList());
    }
}
