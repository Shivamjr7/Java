package exceptions;

import java.io.IOException;

public class SwallowingException {

    public static void main(String[] args) {
        System.out.println(new SwallowingException().swallowMethod());

        new SwallowingException().throwfromFinally();// will give Nullpointer as thrown from finally
    }


    //returning from finally will cause this exception to be swallowed
    int swallowMethod() {
        try {
            throw new IOException();
        } finally {
            return 1;
        }
    }


    void throwfromFinally() {

        try {
            throw new IOException();
        } catch (IOException e) {
            throw new IllegalAccessException(); // this will be eaten up by finally
        } finally {
            throw new NullPointerException();
        }
    }
}
