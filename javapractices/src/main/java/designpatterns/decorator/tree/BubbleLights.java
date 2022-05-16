package designpatterns.decorator.tree;

public class BubbleLights extends TreeDecorator{

    public BubbleLights(ChristmasTree tree)
    {
        super(tree);
    }
    @Override
    public String decorate() {
        return super.decorate()+ decorateWithBubbleLights();
    }

    String decorateWithBubbleLights()
    {
        return "adding bubble lights";
    }
}
