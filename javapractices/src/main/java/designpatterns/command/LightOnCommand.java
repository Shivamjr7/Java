package designpatterns.command;

public class LightOnCommand implements ICommand{

    Light light;
    LightOnCommand(Light light)
    {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
