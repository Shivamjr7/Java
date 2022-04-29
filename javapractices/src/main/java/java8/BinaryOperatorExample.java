package java8;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {


    /**
     * If the input and output are of same type use binary opeartor instead of
     * BiFunction
     * @param args
     */

    static BinaryOperator<Integer> binaryOperator= (a,b)-> a*b;
    public static void main(String[] args) {


        int res = binaryOperator.apply(3,4);
        System.out.println(res);
    }

}
