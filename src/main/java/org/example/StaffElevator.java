package org.example;

public class StaffElevator extends Elevator {
    public StaffElevator(ElevatorState elevatorState) {
        super(elevatorState);
    }

    @Override
    public ElevatorState state() {
        return null;
    }
}
