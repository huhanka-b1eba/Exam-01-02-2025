package org.example;

public class EvenElevator extends Elevator {
    public EvenElevator(ElevatorState elevatorState) {
        super(elevatorState);
    }

    @Override
    public ElevatorState state() {
        return null;
    }
}
