package org.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("foo")
public interface FooService {
	
	@RequestMapping("/")
	public String home();

}
