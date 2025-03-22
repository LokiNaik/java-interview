package com.java.interview.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MyCustomController {

    private MyService service;

    @Autowired // Use @Qualifier to specify which implementation to inject
    public MyCustomController( @Qualifier("firstService") MyService myService){
        this.service = myService;
    }

}
