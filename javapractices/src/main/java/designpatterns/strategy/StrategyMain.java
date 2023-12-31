package designpatterns.strategy;

public class StrategyMain {


    public static void main(String[] args) {

        Duck simpleDuck = new SimpleDuck();
        simpleDuck.setFlyBehaviour(new SimpleFlyBehaviour());
        simpleDuck.setQuackBehaviour(new LoudQuack());
        simpleDuck.fly();
        simpleDuck.quack();

        Duck rubberDuck = new RubberDuck();
        rubberDuck.setFlyBehaviour(new NoFlyBehaviour());
        rubberDuck.setQuackBehaviour(new NoQuack());
        rubberDuck.fly();
        rubberDuck.quack();


    }
}
