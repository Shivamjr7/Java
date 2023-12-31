package java8.streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {


    public static void main(String[] args) {

        Student.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)//converts  stream of list of strings to stream of strings
                .collect(Collectors.toList());



        Map<Integer, String> map = new HashMap<>();

        map.put(8,"Shivam");
        map.put(1943, "Mehandi");
        map.put(138,"Kiki");


        List<Integer > sortedValues = map.entrySet()
                .stream()
                .flatMap(e->Stream.of(e.getKey()))
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedValues);

    }

}


class Student {

    public List<String> getActivities() {
        return activities;
    }

    private List<String> activities;

    private String name;

    Student(String name) {
        this.name = name;
    }


    public static List<Student> getAllStudents() {

        return new ArrayList<>();
    }
}