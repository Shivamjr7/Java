package java8.defaults;

public class MultipleInheritance  implements  A , B{

    public static void main(String[] args) {

    }

    @Override
    public void helloworld() {
        A.super.helloworld();
    }
}


interface A{
    default void helloworld()
    {
        System.out.println("Hello world from : "+ A.class);
    }
}

interface B{
    default  void helloworld()
    {
        System.out.println("Hello world from :"+ B.class);
    }
}