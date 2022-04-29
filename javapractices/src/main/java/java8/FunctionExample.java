package java8;

import java.util.function.Function;

public class FunctionExample {


    /**
     * Function takes an input and returns a output
     * Function<T,R> returns R
     */
    static Function<String, String> function = (s1)-> s1.toUpperCase();

    static Function<String,String> andThenFunc  =(s1)-> s1+"andThen";
    public static void main(String[] args) {

        System.out.println(function.apply("shivam"));

        // andthen applies the result of prev func to new function
        System.out.println(function.andThen(andThenFunc).apply("shivam"));

        //compose first gets executed and then the outer function
        System.out.println(function.compose(andThenFunc).apply("shivam"));

        String test = function.apply("test");
    }



}
