package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsMatchExample {

    public static void main(String[] args) {


        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9, 8));

        System.out.println("all match for x> 0 is : "+ allMatch(integerList));
        System.out.println("any match for x> 4 is : "+ anyMatch(integerList));
        System.out.println("none match for x < 1 is : "+ noneMatch(integerList));

    }

    static boolean allMatch(List<Integer> integerList) {
        return
                integerList.stream().
                        allMatch(x -> x > 0);
    }

    static boolean anyMatch(List<Integer> integerList) {

        return
                integerList.stream().
                        anyMatch(x -> x > 4);
    }

    static boolean noneMatch(List<Integer> integerList) {

        return
                integerList.stream().
                        noneMatch(x -> x < 1);
    }
}
