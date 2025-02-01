package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class ElevatorSystem {
    private final Elevator[] elevators;
    private final Random random;

    public ElevatorSystem() {
        elevators = new Elevator[7];
        for (int i = 0; i < 3; i++) {
            elevators[i * 2] = new EvenElevator(ElevatorState.STAND);
            elevators[i * 2 + 1] = new OddElevator(ElevatorState.STAND);
        }
        elevators[6] = new StaffElevator(ElevatorState.STAND);
        random = new Random();
    }

    public void processCall(CallType type, int floor) throws Exception {
        for (Elevator elevator : elevators) {
            if (elevator.state == ElevatorState.STAND) {
                elevator.setDestination(floor);
                return;
            }
        }
        throw new RuntimeException("All elevators are busy. Call type: " + type + ", Floor: " + floor);
    }

    public Elevator[] getElevators() {
        return elevators;
    }

    public void runSimulation() {
        for (int i = 0; i < 10000; i++) {
            if (i % 20 == 0) {
                try {
                    int floor = random.nextInt(20) + 2;
                    CallType type = CallType.values()[random.nextInt(CallType.values().length)];
                    processCall(type, floor);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            for (Elevator elevator : elevators) {
                elevator.updateElevatorStatus(elevator);
            }
        }
    }
}