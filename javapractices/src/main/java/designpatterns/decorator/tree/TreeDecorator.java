package designpatterns.decorator.tree;

public abstract class TreeDecorator implements  ChristmasTree{

    ChristmasTree tree;

    public TreeDecorator(ChristmasTree tree) {
        this.tree = tree;
    }

    @Override
    public String decorate() {
        return tree.decorate();
    }
}
