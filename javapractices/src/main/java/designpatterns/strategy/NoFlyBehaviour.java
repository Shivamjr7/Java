package designpatterns.strategy;

public class NoFlyBehaviour implements IFlyBehaviour {

    @Override
    public void fly() {
        System.out.println("This duck cannot fly..");
    }
}
