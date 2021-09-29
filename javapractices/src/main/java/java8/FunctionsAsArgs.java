package java8;

import java.util.function.Function;

/**
 * We can pass functions as args as well
 * Just check what is the arg type and based on that we can pass our impl
 */
public class FunctionsAsArgs {

    public static void main(String[] args) {

    System.out.println(func((x)->x+10));
    System.out.println(func(FunctionsAsArgs::methodOne));
    }



    static Integer methodOne(Integer x)
    {
        return x*3;
    }

    static Integer func(Function<Integer, Integer> myFunc)
    {
        return myFunc.apply(10);
    }
}
