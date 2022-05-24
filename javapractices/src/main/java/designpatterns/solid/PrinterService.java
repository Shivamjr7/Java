package designpatterns.solid;

import java.awt.geom.Area;
import java.util.List;

public class PrinterService {


     /**
      * Breaking the dependency inversion principle and
      * Open closed principle
      */
    // AreaCalculator areaCalculator = new AreaCalculator()
     private final IAreaCalculator areaCalculator;

     PrinterService(IAreaCalculator areaCalculator)
     {
          this.areaCalculator= areaCalculator;
     }

     public String printSumInJson(List<Shape> shapes)
     {
     return "{ sum : "+ areaCalculator.sum(shapes) +" }";
     }



}
