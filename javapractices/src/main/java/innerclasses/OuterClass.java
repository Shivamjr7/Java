package innerclasses;

public class OuterClass {

    private int counter = 10;

    void innerMethod(){
        System.out.println("Outer class method..");
    }
    private void testMethod1(){
        System.out.println("Test method 1...");
    }

    static void testMethod2(){
        System.out.println("Test method 2..");
    }

    class InnerCLassEx{
        private  int counter = 11;

        void innerMethod(){
            System.out.println("Inner class method..");
        }
//        private static int checkStaticAllowed = 10; // cannot have this because inner class is associated with object of outer class
    }

    public static void main(String[] args) {
        OuterClass.InnerCLassEx innerCLassEx = new OuterClass().new InnerCLassEx();
        System.out.println(innerCLassEx.counter); // inner class : 11

        innerCLassEx.innerMethod();

    }
}
