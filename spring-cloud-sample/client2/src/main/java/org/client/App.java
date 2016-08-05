package org.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableFeignClients
@EnableBinding(Sink.class)
public class App {

	@Autowired
	private FooService fooService;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@RequestMapping("/")
	public String home1() {
		return fooService.home()+"--------------->client";
	}
	
	@StreamListener(Sink.INPUT)
	public void listent(String name){
		System.out.println(name);
	}
}
