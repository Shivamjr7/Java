package designpatterns.decorator.tree;

public class TreeTopper extends TreeDecorator{

    public TreeTopper(ChristmasTree tree)
    {
        super(tree);
    }
    @Override
    public String decorate() {
        return super.decorate() + decorateWithTreeTopper();
    }

    String decorateWithTreeTopper()
    {
       return " adding Tree Topper";
    }
}
