package java8.practice;

import java.util.*;

public class LambdaExample {

    public static void main(String[] args) {

        // Lambdas


        // 1 : starting a new thread with lambda

        System.out.println("Thread with lambda");
        new Thread(()->{
            for(int i =0;i<5;i++)
            {
                System.out.println("Hello :"+ i);
            }
        }).start();
        System.out.println("-------------------");


        // 2: comparator with lambda


        List<String> list = new ArrayList<>();
        list.add("Shivam");
        list.add("Abhinav");
        list.add("Asif");



        Collections.sort(list,(s1,s2)-> s1.compareTo(s2));

        System.out.println(list);
    }

}
