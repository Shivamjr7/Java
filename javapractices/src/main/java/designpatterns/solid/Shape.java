package designpatterns.solid;

public interface Shape {

    int area();

    /**
     * This violates the interface seggregation principle
     * Not all shapes has volume
     * solution : to shift it to a more generic interface and shapes which has volume
     * will implement that
     */

    //    double volume();
}
