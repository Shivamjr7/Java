package java8.streams;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>(Arrays.asList(1,4,5,6,7,8,9,10,10));

        int max = findMax(integerList);
        System.out.println("max : "+ max);


        Optional<Integer> maxOptional = findMaxOptional(new ArrayList<>());

        if(maxOptional.isPresent()) {
            System.out.println("max : " + maxOptional.get());
        }
        else {
            System.out.println("Input list is empty ");
        }
    }


    public static int findMax(List<Integer> integerList)
    {
        return
                integerList.stream()
                .reduce(0,(a,b)-> a> b? a:b);
    }


    public static Optional<Integer> findMaxOptional(List<Integer> integerList)
    {
        return
                integerList.stream()
                        .reduce((a,b)-> a> b? a:b);
    }
}
