package java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DebugStreamsExample {


    public static void main(String[] args) {

        List<String> names = new ArrayList<String>(){
            {
                add("shivam");
                add("mehandi");
                add("asif");
                add("abhinav");
                add("deeksha");
                add("shrikant");
                add("anshita");
                add("bhupendra");
                add("leena");
            }
        };


        names.stream()
                .filter((name)-> name.startsWith("a"))
                .peek(System.out::println)
                .map(String::toUpperCase)
                .peek((name)->System.out.println("After filtering :"+ name))
                .collect(Collectors.toList());

    }
}
