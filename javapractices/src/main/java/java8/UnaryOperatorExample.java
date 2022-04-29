package java8;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {


    /**
     * If the input and output are of same type
     * use UnaryOperator instead of Function
     * @param args
     */


    static UnaryOperator<String> unaryOperator = (s)-> s.toUpperCase();
    public static void main(String[] args) {

        String res  = unaryOperator.apply("shivam");
        System.out.println(res);

    }
}
