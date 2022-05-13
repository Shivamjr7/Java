package designpatterns.strategy;

public class NoQuack implements IQuackBehaviour{

    @Override
    public void quack() {
        System.out.println("Duck cannot quack");
    }
}
