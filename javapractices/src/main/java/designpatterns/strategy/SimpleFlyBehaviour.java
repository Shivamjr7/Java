package designpatterns.strategy;

public class SimpleFlyBehaviour implements IFlyBehaviour {

    @Override
    public void fly() {
        System.out.println("Duck can fly like other birds...");
    }
}
