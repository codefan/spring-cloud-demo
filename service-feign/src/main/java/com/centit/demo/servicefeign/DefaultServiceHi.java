package com.centit.demo.servicefeign;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DefaultServiceHi implements IServiceHi {

    @Override
    public Greeting sayHiFromClientOne(String name) {
        Greeting greeting = new Greeting();
        greeting.setUserName(name);
        greeting.setGreetingWords("Errors");
        greeting.setFromPort(8765);
        greeting.setGreetingTime(new Date());
        return greeting;
    }
}
