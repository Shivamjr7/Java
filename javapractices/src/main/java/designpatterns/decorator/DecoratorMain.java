package designpatterns.decorator;

public class DecoratorMain {

    public static void main(String[] args) {

        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        Shape redCircle = new RedColorDecorator(circle);
        Shape blackRectangle = new BlackColorDecorator(rectangle);

        redCircle.draw();
        blackRectangle.draw();

    }
}
