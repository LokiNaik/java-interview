package com.java.interview.employee;

import org.springframework.stereotype.Service;

import static java.lang.System.*;
/**
 *  Question: I have a interface service, and it has one abstract method,
 *  now this interface is implemented by two different  classes,
 *  now in controller how can I call only first class using dependency injection using constructor?
 */

@Service("firstService")  // Naming the bean explicitly
public class MyFirstServiceImpl implements MyService{
    @Override
    public void performService() {
        out.println("Inside first service implementation class!");
    }
}
