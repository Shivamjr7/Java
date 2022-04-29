package java8.streams.terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsJoiningExample {


    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Shivam","Asif","Abhinav","Gaurav"));

        System.out.println(joining(names));
        System.out.println(joiningwithDelimiter(names));
        System.out.println(joiningwithDelimiterPrefixandSuffix(names));
    }


    static String joining(List<String> names)
    {
        return
                names.stream()
                .collect(Collectors.joining());
    }


    static String joiningwithDelimiter(List<String> names)
    {
        return
                names.stream()
                        .collect(Collectors.joining("-"));
    }
    static String joiningwithDelimiterPrefixandSuffix(List<String> names)
    {
        return
                names.stream()
                        .collect(Collectors.joining("-","(",")"));
    }
}
