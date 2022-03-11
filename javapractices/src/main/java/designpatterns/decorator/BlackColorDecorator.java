package designpatterns.decorator;

public class BlackColorDecorator extends ShapeDectorator {
    public BlackColorDecorator(Shape shape) {
        super(shape);
    }


    @Override
    public void draw() {
        super.draw();
        setBlackcolor();
    }


    void setBlackcolor() {

        System.out.println("Adding black color...");
    }
}
