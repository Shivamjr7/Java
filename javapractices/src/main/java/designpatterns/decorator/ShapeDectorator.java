package designpatterns.decorator;

public abstract class ShapeDectorator implements Shape{

    Shape shape;
    public ShapeDectorator(Shape shape)
    {
        this.shape = shape;
    }


    @Override
    public void draw() {
        shape.draw();
    }
}
