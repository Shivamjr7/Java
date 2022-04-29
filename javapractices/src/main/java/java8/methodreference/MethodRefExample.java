package java8.methodreference;

import java.util.function.Function;

public class MethodRefExample {

    public static void main(String[] args) {


        Function<String, String> toUpperCaseMethoref = String::toUpperCase;

        System.out.println(toUpperCaseMethoref.apply("shivam"));
    }
}
