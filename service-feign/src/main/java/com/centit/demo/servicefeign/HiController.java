package com.centit.demo.servicefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    IServiceHi serviceHi;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public Greeting sayHi(@RequestParam String name){
        return serviceHi.sayHiFromClientOne(name);
    }
}
