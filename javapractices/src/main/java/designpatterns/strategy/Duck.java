package designpatterns.strategy;

public class Duck {

    //use composition rather than inheritance
    IFlyBehaviour iFlyBehaviour;

    /**
     * Like the fly behaviour we can have different behaviour for different ducks
     * In this way a duck can have different behaviour and can pick up the behaviour it wants
     */

    public void setFlyBehaviour(IFlyBehaviour flyBehaviour)
    {
        this.iFlyBehaviour = flyBehaviour;
    }


    void fly()
    {
        this.iFlyBehaviour.fly();
    }

}
