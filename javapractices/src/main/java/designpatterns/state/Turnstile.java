//package designpatterns.state;
//
//public class Turnstile implements  Gate{
//
//    GateState gateState;
//
//    Turnstile()
//    {
//        this.gateState = new ClosedGateState(this);
//    }
//
//    @Override
//    public void enter() {
//
//        this.gateState.enter();
//    }
//
//    @Override
//    public void pay() {
//
//        this.gateState.pay();
//    }
//
//    @Override
//    public void payOk() {
//
//        this.gateState.payOk();
//    }
//
//
//
//    public void changeState(GateState state)
//    {
//        this.gateState = state;
//    }
//
//
//}
