package com.centit.demo.servicehi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceHiApplication {
	//org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration
	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	public SayHello home(@RequestParam String name) {
		SayHello greeting = new SayHello();
		greeting.setUserName(name);
		greeting.setGreetingWords("hello");
		greeting.setFromPort(Integer.valueOf(port));
		greeting.setGreetingTime(new Date());
		return greeting;
	}

}
