package java9.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java9streams {

    public static void main(String[] args) {


        // take while

        int [] studentsGrade = {10,9,8,1,3};
//
        Arrays.stream(studentsGrade)
                .takeWhile(grade -> grade > 2)
                .forEach(System.out::println);

        System.out.println("drop while new ...");


        int [] studentsGradeNew = {1,2,3,4,5,6,7,8,9,10};
        // drop while
        Arrays.stream(studentsGradeNew)
                .dropWhile(grade -> grade < 8)
                .forEach(System.out::println);

    }

}
