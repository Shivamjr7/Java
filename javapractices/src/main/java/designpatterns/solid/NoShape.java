package designpatterns.solid;

public class NoShape implements Shape{

    /**
     * This is a violation of the Liskov Substitution Principle
     * Subclass should be able to be replaced by parent class without
     * affecting the functionalities
     */

    @Override
    public int area() {
        throw new RuntimeException("No area since no shape");
    }
}
