package designpatterns.command;

public class RemoteControl {


    ICommand onCommand;
    ICommand offCommand;

    RemoteControl(ICommand onCommand, ICommand offCommand)
    {
        this.onCommand = onCommand;
        this.offCommand = offCommand;
    }


    void pressOn()
    {
        onCommand.execute();
    }

    void pressOff()
    {
        offCommand.execute();
    }
}
