package designpatterns.command;

public class FanOnCommand implements ICommand {


    Fan fan;

    FanOnCommand(Fan fan) {
        this.fan = fan;

    }

    @Override
    public void execute() {
        fan.fanOn();
    }
}
