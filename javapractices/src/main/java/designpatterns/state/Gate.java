package designpatterns.state;

public interface Gate {

    void enter();
    void pay();
    void payOk();

    void changeState(GateState state);



}
