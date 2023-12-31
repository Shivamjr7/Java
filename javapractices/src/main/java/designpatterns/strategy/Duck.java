package designpatterns.strategy;

public class Duck {

    //use composition rather than inheritance
    IFlyBehaviour iFlyBehaviour;


    IQuackBehaviour iQuackBehaviour;

    /**
     * Like the fly behaviour we can have different behaviour for different ducks
     * In this way a duck can have different behaviour and can pick up the behaviour it wants
     */



    public void setFlyBehaviour(IFlyBehaviour flyBehaviour)
    {
        this.iFlyBehaviour = flyBehaviour;
    }
    public void setQuackBehaviour(IQuackBehaviour iQuackBehaviour) {
        this.iQuackBehaviour = iQuackBehaviour;
    }



    void fly()
    {
        this.iFlyBehaviour.fly();
    }

    void quack()
    {
        this.iQuackBehaviour.quack();
    }

}
