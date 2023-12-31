package designpatterns.state;

public interface GateState {


    void enter();
    void pay();
    void payOk();

    void updateState(Gate gate);
}
