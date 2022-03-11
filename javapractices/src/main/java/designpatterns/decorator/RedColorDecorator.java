package designpatterns.decorator;

public class RedColorDecorator extends ShapeDectorator {

    public RedColorDecorator(Shape shape) {
        super(shape);
    }


    @Override
    public void draw() {
        super.draw();
        setRedColor();

    }


    void setRedColor() {
        System.out.println("Adding red color...");
    }
}
