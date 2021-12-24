package exceptions;


import java.io.IOException;

/**
 * Case	                            try   catch 	finally	bottom
 * try throws no exception	          y	    -        	y	  y
 * try throws a handled exception	  y	    y 	        y	  y
 * try throws an unhandled exception  y	    -	        y	  -
 */
public class FlowControl {


    public static void main(String[] args) {


        System.out.println("try throws no exception");
        method();
        System.out.println("-------------------------");
        System.out.println("try throws a handled exception");
        method2();
        System.out.println("-------------------------");
        System.out.println("try throws an unhandled exception ");
        method3();
        System.out.println("-------------------------");
    }


    static void method() {

        try {
            System.out.println("try block");
        } catch (Exception e) {
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");
        }

        System.out.println("Final code...");
    }

    static void method2() {

        try {
            System.out.println("try block");
            throw new IOException();
        } catch (Exception e) {
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");
        }

        System.out.println("Final code ...");
    }


    static void method3() {
        try {
            System.out.println("try block");
            String str = null;
            str.startsWith("a");

        } finally {
            System.out.println("finally block");
        }

        System.out.println("Final code ...");
    }

}
