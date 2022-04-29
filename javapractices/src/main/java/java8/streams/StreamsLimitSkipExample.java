package java8.streams;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>(Arrays.asList(6,7,8,9,10));


        // limit functionality
        Optional<Integer> limitResult = limit(integerList);
        if(limitResult.isPresent()) {
            System.out.println("limit result : "+ limitResult.get());
        }
        else {
            System.out.println("Input is empty");
        }


        //skip functionality

        Optional<Integer> skipResult = skip(integerList);
        if(skipResult.isPresent()) {
            System.out.println("skip result : "+ skipResult.get());
        }
        else {
            System.out.println("Input is empty");
        }

    }


    static Optional<Integer> limit(List<Integer> integerList)
    {

        return
                integerList.stream()
                        // 6,7,8,9,10
                .limit(3)
                        // 6,7,8
                .reduce((a,b)->a+b);
    }

    static Optional<Integer> skip(List<Integer> integerList)
    {

        return
                integerList.stream()
                        // 6,7,8,9,10
                        .skip(3)
                        // 9,10
                        .reduce((a,b)->a+b);
    }

}
