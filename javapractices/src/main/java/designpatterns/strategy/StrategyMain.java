package designpatterns.strategy;

public class StrategyMain {


    public static void main(String[] args) {

        Duck simpleDuck = new SimpleDuck();
        simpleDuck.setFlyBehaviour(new SimpleFlyBehaviour());
        simpleDuck.fly();

        Duck rubberDuck = new RubberDuck();
        rubberDuck.setFlyBehaviour(new NoFlyBehaviour());
        rubberDuck.fly();


    }
}
