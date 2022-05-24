package designpatterns.solid;

import java.util.List;

public class AreaCalculator implements IAreaCalculator {


    public int sum(List<Shape> shapes) {

        //calculate sum of area of the shapes
        int sum = 0;
        for (Shape shape : shapes) {

            //TODO : this code violates the open closed principle
            //TODO : In case tomorrow there is an extra shape , we need to add if block

            /**
             if(shape instanceof Circle)
             {
             //calculate circle's area
             // sum + = circle's area;
             }
             if(shape instanceof  Square)
             {
             //calculate square's area
             // sum+= square's area
             }**/

            //Right way to do
            sum += shape.area();
        }
        return sum;
    }


    // TODO Here we are breaking SRP as a class should have only one responsibilty
    // TODO Here AreaCalculator is responsible for calculating sum and also printing it in different formats
    /** public String printSumInJson(List<Shape> shapes)
     {
     return "{ sum : "+ sum(shapes)+"}";
     }**/
}
