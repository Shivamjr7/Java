package streams;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Different types os collector and their example
 */
public class CollectorExample {

    public static void main(String[] args) {

        String [] names ={"Shivam","Abhinav","Asif","Gaurav","Shrikant","Bhupendra"};


        List<String> friends = Arrays.asList(names);


        //collecting to list

        List<String> bandMembers =  friends.stream().
                                        filter(x-> x.startsWith("A")).
                                        collect(Collectors.toList());


        //joining

       String friendsString  = friends.stream()
                .collect(Collectors.joining(":"));


       // count
        Long  wordLength = friends.stream().collect(Collectors.counting());


        // grouping by
        Map<Integer, List<String>> wordMap  = friends.stream().
                collect(Collectors.groupingBy(
                (word) -> word.length()
        ));


        Map<Boolean , List<String>> wordsMap = friends.stream().collect(Collectors.partitioningBy(
                (x) -> x.length()>5
        ));

        System.out.println(bandMembers);
        System.out.println(wordLength);
        System.out.println(wordMap);
        System.out.println(wordsMap);
    }





}
