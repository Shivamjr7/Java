package java8;

import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {

        /**
         * BiFunction interface takes 2 arguments and returns a 3rd value
         *
         */

        BiFunction<Integer,Integer,Integer> biFunction = (x,y)->  x *y;
        BiFunction<Integer,Integer,Integer> biFunctionwithreturn = (x, y)-> {return ( x+y);};


        int multiplication=  biFunction.apply(19,19);
        int add = biFunctionwithreturn.apply(10,20);

        System.out.println("multiplication "+multiplication);
        System.out.println("addition "+add);
    }
}
