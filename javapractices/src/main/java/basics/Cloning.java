package basics;

import java.util.ArrayList;
import java.util.List;

public class Cloning  implements  Cloneable{


    int id;
    String name;
    Reference ref ;
    List<String> list = new ArrayList<>();

    Cloning(int id , String name , Reference ref )
    {
        this.id = id;
        this.name = name;
        this.ref = ref ;
    }

    public static void main(String[] args) throws  CloneNotSupportedException {



        Cloning objA = new Cloning(1, "Shivam", new Reference("ref"));
        Cloning objb = (Cloning) objA.clone();

        //different objects
        System.out.println(objA);
        System.out.println(objb);

        objA.name = "Van de Beek";
        objb.ref = new Reference("Hello");
        System.out.println(objA.ref);
        System.out.println(objb.ref);


    }
}


class Reference{
    String ref ;

    Reference(String ref )
    {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return "Reference{" +
                "ref='" + ref + '\'' +
                '}';
    }
}