package designpatterns.solid;

import java.util.List;

public class SolidMain {


    public static void main(String[] args) {

        IAreaCalculator areaCalculator = new AreaCalculator();
        PrinterService printerService = new PrinterService(areaCalculator);
        Shape circle = new Circle();
        Shape square = new Square();
        List<Shape> shapes = List.of(circle, square);
        int sum = areaCalculator.sum(shapes);
        System.out.println(printerService.printSumInJson(shapes));

    }
}
