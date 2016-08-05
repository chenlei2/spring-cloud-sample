package org.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableBinding(Source.class)
public class App implements FooService {

	@Value("${foo}")
	String name = "World";
	@Autowired
	Source mc;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	
	public String home() {
		mc.output().send(MessageBuilder.withPayload("hello world").build());
		return "Hello " + name;
	}
	
}
