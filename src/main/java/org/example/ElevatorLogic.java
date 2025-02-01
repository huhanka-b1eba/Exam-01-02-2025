package org.example;

import java.util.Random;

public class ElevatorLogic {
    private ElevatorSystem system;

    public ElevatorLogic() {
        this.system = new ElevatorSystem();
    }

    public void runSimulation() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            if (i % 20 == 0) {
                try {
                    int floor = random.nextInt(15) + 2;
                    CallType type = CallType.values()[random.nextInt(CallType.values().length)];
                    system.processCall(type, floor); 
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            for (Elevator elevator : system.getElevators()) {
                elevator.updateElevatorStatus(elevator);
            }
        }
    }
}
