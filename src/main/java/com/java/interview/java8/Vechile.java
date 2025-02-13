package com.java.interview.java8;


public interface Vechile {
    default void start(){
        System.out.println("Car started ....");
    }
    static void service(){
        System.out.println("Time to service..");
    }
}

class Car implements Vechile{
    void drive(){
        System.out.println("Driving..");
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.drive();
        car.start(); // default method of Interface. we don't have to call using the Interface name.
        Vechile.service(); // calling static method of Interface
    }
}
