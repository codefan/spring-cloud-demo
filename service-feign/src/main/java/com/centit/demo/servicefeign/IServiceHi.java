package com.centit.demo.servicefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SERVER-HI",fallback = DefaultServiceHi.class)
public interface IServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    Greeting sayHiFromClientOne(@RequestParam(value = "name") String name);
}
