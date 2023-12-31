package java8;

import java.util.function.Consumer;

public class    LambdaLocalVariable {


    int instance_var =5;
    static int static_var=9;
    public static void main(String[] args) {


        int local = 4;

        Consumer<Integer> consumer = (i) -> {
            System.out.println(local);
            new LambdaLocalVariable().instance_var++; //allowed for instance variables
            static_var=9;
            //local++;  not allowed for local variables
            System.out.println(i);
        };


        static_var=10;
        //  local = 6; not allowed to be changed

    }
}
