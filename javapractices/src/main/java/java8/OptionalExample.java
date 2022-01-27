package java8;

import jdk.jfr.DataAmount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalExample {


    public static void main(String[] args) {


        Optional<String> optionalS = optionalStringOfNullable();
        System.out.println(optionalS.isPresent() +" "+optionalS.get());


        Optional<String> optionalS1 = Optional.ofNullable(null);
        Optional<String> optionalS2 = Optional.of(null); // this will throw NPE  , always execpt valid values

        Optional<String> optionalS3 =Optional.empty();// returns an empty object
        optionalS3.get(); // will throw NoSuchElementException




    }


   static  Optional<String> optionalStringOfNullable()
    {
        return Optional.ofNullable("Hello");
    }



}

