package designpatterns.decorator.tree;

public class DecoratorMain {


    public static void main(String[] args) {

        ChristmasTree tree = new TreeTopper(new BubbleLights(new ChristmasTreeImpl()));
        System.out.println(tree.decorate());
    }

}
