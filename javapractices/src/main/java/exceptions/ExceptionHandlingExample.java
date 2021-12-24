package exceptions;

public class ExceptionHandlingExample {

    public static void main(String[] args) {


        try {
            //this code will throw exception
            int i = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Close all your resources");
        }


    }
}
