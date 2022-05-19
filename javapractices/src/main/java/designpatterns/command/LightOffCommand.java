package designpatterns.command;

public class LightOffCommand implements ICommand {

    Light light;

    LightOffCommand(Light light) {
        this.light = light;

    }

    @Override
    public void execute() {
        light.off();
    }
}
