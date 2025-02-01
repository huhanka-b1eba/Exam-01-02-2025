package org.example;

public class OddElevator extends Elevator {

    public OddElevator(ElevatorState elevatorState) {
        super(elevatorState);
    }

    @Override
    public ElevatorState state() {
        return null;
    }
}
