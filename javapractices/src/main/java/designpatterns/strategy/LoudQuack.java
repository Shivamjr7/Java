package designpatterns.strategy;

public class LoudQuack implements IQuackBehaviour{

    @Override
    public void quack() {
        System.out.println("Loud Quack");
    }
}
