package com.java.interview.employee;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import static java.lang.System.*;

/**
 *    Question: I have a interface service, and it has one abstract method,
 *    now this interface is implemented by two different  classes,
 *    now in controller how can I call only first class using dependency injection using constructor?
 *
 * @Primary  // Marks this as the default implementation
 * @Service
 * public class FirstServiceImpl implements MyService {
 *     @Override
 *     public void performService() {
 *         System.out.println("Executing FirstServiceImpl (Primary)");
 *     }
 * }
 */

@Primary
@Service("secondService")  // Naming the bean explicitly
public class MySecondServiceImpl implements MyService{
    @Override
    public void performService() {
        out.println("Inside second service implementation class! ");
    }
}
