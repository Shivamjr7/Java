package exceptions;

public class ReturnExample {


    static String method() {
        try {
            return "try";
        } finally {
            return "finally";
        }
    }

    static String method2() {

        try {
            int i = 1 / 0;
            return "try";
        } catch (ArithmeticException e) {
            return "catch";
        } finally {
            return "finally";
        }

    }

    static String method3() {
        String str = "";

        try {
            str = "try";
            int i = 1 / 0;

        } catch (ArithmeticException e) {

            str = "catch";
        } finally {
            str = "finally";
        }
        return str;
    }

    public static void main(String[] args) {
        //when return is written in both try and finally
        System.out.println(method()); // output : finally

        //when return in in all blocks and there is a exception
        System.out.println(method2()); //output : finally


        System.out.println(method3());

    }
}
