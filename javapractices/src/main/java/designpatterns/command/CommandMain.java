package designpatterns.command;

public class CommandMain {


    public static void main(String[] args) {


        //create a light remote control

        Light light = new Light(); //receiver 1
        Fan fan = new Fan(); //receiver 2


        RemoteControl lightRemote = new RemoteControl(
                new LightOnCommand(light), new LightOffCommand(light)
        );


        lightRemote.pressOn();
        lightRemote.pressOff();

        RemoteControl fanRemote = new RemoteControl(
                new FanOnCommand(fan), new FanOffCommand(fan)
        );

        fanRemote.pressOn();
        fanRemote.pressOff();
    }
}
