package designpatterns.state;

public class OpenGateState implements  GateState{



    OpenGateState state = new OpenGateState();

    @Override
    public void enter() {

    }

    @Override
    public void pay() {

    }

    @Override
    public void payOk() {

    }

    @Override
    public void updateState(Gate gate) {
        gate.changeState(state);
    }
}
