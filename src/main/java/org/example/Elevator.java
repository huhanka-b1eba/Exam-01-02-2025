package org.example;

abstract class Elevator implements ElevatorStatus, Step {
    protected ElevatorState state;
    protected int currentFloor;
    protected Integer destinationFloor;

    public Elevator(ElevatorState state) {
        this.state = state;
        this.currentFloor = 1;
        this.destinationFloor = null;
    }

    public void setDestination(int floor) {
        this.destinationFloor = floor;
        if (floor > currentFloor) {
            state = ElevatorState.UP;
        } else if (floor < currentFloor) {
            state = ElevatorState.DOWN;
        }
    }

    @Override
    public void updateElevatorStatus(Elevator elevator) {
        if (elevator.state == ElevatorState.UP) {
            elevator.currentFloor++;
            if (elevator.currentFloor == elevator.destinationFloor) {
                elevator.state = ElevatorState.STAND;
            }
        } else if (elevator.state == ElevatorState.DOWN) {
            elevator.currentFloor--;
            if (elevator.currentFloor == elevator.destinationFloor) {
                elevator.state = ElevatorState.STAND;
            }
        }
    }
}