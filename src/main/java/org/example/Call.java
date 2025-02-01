package org.example;


class Call implements CallElevator {
    @Override
    public void call(CallType type, int needFloor) {
        System.out.println("Вызов " + type + " лифта на этаж " + needFloor);
    }
}