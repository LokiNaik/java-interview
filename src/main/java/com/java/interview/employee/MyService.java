package com.java.interview.employee;

/**
 * Question: I have a interface service, and it has one abstract method,
 * now this interface is implemented by two different  classes,
 * now in controller how can I call only first class using dependency injection using constructor?
 *
 * we can use either @Qualifier or @Primary for defining the same
 *     Use @Qualifier to specify which implementation to inject
 *     public MyController(@Qualifier("firstService") MyService myService) {
 *         this.myService = myService;
 *     }
 *
 *
 */
public interface MyService {

    void performService();

}
