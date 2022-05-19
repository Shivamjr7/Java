package designpatterns.command;

public class FanOffCommand implements ICommand {

    Fan fan;

    FanOffCommand(Fan fan) {
        this.fan = fan;

    }

    @Override
    public void execute() {
        fan.fanOff();
    }
}
