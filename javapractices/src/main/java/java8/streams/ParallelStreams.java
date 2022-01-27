package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 *  using parallel streams operate on the data in parallel
 *  threads
 */
public class ParallelStreams {





    public static void main(String[] args) {
        List<String> friends = Arrays.asList(new String []{"Asif","Abhinav","Shivam","Shrikant","Bhupendra","Gaurav","Tee Rahul"});


       List<String> upperCaseNames =  friends.parallelStream()
                .map(
                        (word)-> {
                            System.out.println("Upper casing " + word);
                            return word.toUpperCase();
                        }
                )
                .collect(Collectors.toList());

       System.out.println(upperCaseNames);
    }

}
