package java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {


    public static void main(String[] args) {

        Student.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)//converts  stream of list of strings to stream of strings
                .collect(Collectors.toList());
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