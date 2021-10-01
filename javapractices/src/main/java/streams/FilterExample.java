package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterExample {

    /**
     * Filter operation to filter elements from the stream
     */


    public static void main(String[] args) {

        String [] names = {"Shivam","Asif","Abhinav","Gaurav","Shrikant","Bhupendra"};

        List<String> friends = Arrays.asList(names);


       List<String> bandMembers =  friends.stream().filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        Predicate<String> func = (x)-> x.length()>6;

        List<String> longNames = friends.stream()
                                 .filter(func)
                                 .collect(Collectors.toList());


        System.out.println("Band Members :"+bandMembers);
        System.out.println("Long Names :"+longNames);
    }


}
