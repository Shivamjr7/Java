package java8.defaults;

public class MultipleInheritance  implements  A , B{

    public static void main(String[] args) {

        MultipleInheritance obj = new MultipleInheritance();
        obj.helloworld();

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
    static void staticMethod(){
        System.out.println("interface A static method");
    }
}

interface B{
    default  void helloworld()
    {
        System.out.println("Hello world from :"+ B.class);
    }

    static void staticMethod(){
        System.out.println("interface A static method");
    }
}