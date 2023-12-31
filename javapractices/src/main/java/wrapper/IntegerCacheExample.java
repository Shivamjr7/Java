package wrapper;

import java.util.Objects;

public class IntegerCacheExample {


    public static void main(String[] args) {


        Integer a = 1;
        Integer b = 1;

        Integer c = 128;
        Integer d = 128;


        //comparing reference
        System.out.println(a==b); //will be true as integer cache has cached values from 1 to 127
        System.out.println(c==d); //will be false


        Integer e =new Integer(1);
        System.out.println(a==e); // will be false


        System.out.println(Integer.valueOf(1)==Integer.valueOf(1)); //cached

        Objects.equals(null , null);
    }
}
