package com.java.interview.java8;

/**
 * A FunctionalInterface should have only one abstract method, but can have multiple default methods and static methods.
 * We use @FunctionalInterface annotation to make it FunctionalInterface, and It is not even mandatory to give the annotation.
 * Here in the below example we haven't used @FunctionalInterface annotation.
 * With the use of FunctionalInterface BoilerPlate code is removed.
 */
public interface FunctionalInterfaceExample {
    int calculate(int a, int b);
}

