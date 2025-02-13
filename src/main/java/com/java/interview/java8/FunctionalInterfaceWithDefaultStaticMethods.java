package com.java.interview.java8;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

@FunctionalInterface
public interface FunctionalInterfaceWithDefaultStaticMethods {

    int operate(int a, int b);

    default void add(int a, int b) {
        System.out.println("add : " + (a + b));
    }

    default void sub(int a, int b) {
        System.out.println("Sub : " + (a - b));
    }

    static void mul(int a, int b) {
        System.out.println("Mul : " + (a * b));
    }
}

class Calculate {
    public static void main(String[] args) {
        FunctionalInterfaceWithDefaultStaticMethods divide = (a, b) -> a / b;
        System.out.println(divide.operate(10, 2));
        divide.add(2, 3);
        divide.sub(10, 5);
        FunctionalInterfaceWithDefaultStaticMethods.mul(2, 3);
    }
}
