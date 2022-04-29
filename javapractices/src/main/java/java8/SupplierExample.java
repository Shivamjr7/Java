package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    static List<String> students = new ArrayList<>(Arrays.asList("Shivam","Asif","Mehandi","Abhinav","Anshita","Shrikant","Deeksha"));

    static Supplier<List<String>> supplier =()->students;

    public static void main(String[] args) {

        List<String> students = supplier.get();

    }
}
