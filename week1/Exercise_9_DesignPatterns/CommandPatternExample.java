package com.Bharani.week1.Ex9;

public class CommandPatternExample {
    public static void main(String[] args) {
        // Create a receiver object
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        // Create command objects
        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);
        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);

        // Create an invoker object
        RemoteControl remoteControl = new RemoteControl();

        // Set and execute commands
        remoteControl.setCommand(livingRoomLightOn);
        remoteControl.pressButton();

        remoteControl.setCommand(livingRoomLightOff);
        remoteControl.pressButton();

        remoteControl.setCommand(kitchenLightOn);
        remoteControl.pressButton();

        remoteControl.setCommand(kitchenLightOff);
        remoteControl.pressButton();
    }
}
