package com.java.interview.java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * This class is for Implementing FunctionalInterface.
 * Here no boilerPlate code is used.
 */
public class FunctionalInterfaceImpl {

    public static final Logger logger = LoggerFactory.getLogger(FunctionalInterfaceImpl.class);

    public static void main(String[] args) {
        FunctionalInterfaceExample square = (a, b) -> a * a; // to calculate square.
        FunctionalInterfaceExample multiplication = (a, b) -> a * b; // for multiplication
        FunctionalInterfaceExample cube = (a, b) -> a * a * a; // finding cube

        logger.info("Square is {}", square.calculate(2, 1)); // calling abstract method of interface
        logger.info("Multiplication {}", multiplication.calculate(2, 4));
        logger.info("Cube {}", cube.calculate(3, 5));
    }

    public static void example1(){
        List<String> list = Arrays.asList("Java", "JavaScript", "Python", "NodeJs", "React");
            
    }
}