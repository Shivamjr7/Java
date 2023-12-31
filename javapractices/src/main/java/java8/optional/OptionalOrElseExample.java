package java8.optional;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * In case of OrElse it will always execute the orElse
 * In case of OrElseGet it will only execute if the first is empty 
 */
public class OptionalOrElseExample {


    public static void main(String[] args) {

//        String str1 = "check";
//        System.out.println(orElse(str1));
//        System.out.println(orElse(null));
//
//
//        System.out.println(orElseGet("hello"));
//        System.out.println(orElseGet(null));

        String str3  = Optional.of("check").orElse(getMethod());
        String str4 = Optional.ofNullable("check").orElse(getMethod());

        System.out.println(str3);
        System.out.println(str4);

        System.out.println("Start of orElseget ....");
        String str5 = Optional.of("check").orElseGet(()->getMethod());
        System.out.println(str5);
    }

    public static String getMethod(){
        System.out.println("start of method ....");

        System.out.println("end of method ....");

        return "check2";
    }
    public static  String orElse(String str){
        return  Optional.ofNullable(str).orElse("this");
    }

    public static String orElseGet(String str){
        return  Optional.ofNullable(str).orElseGet(()->{
            String x = "ertret";
            x = x.toUpperCase();
            return x;
        });
    }
}