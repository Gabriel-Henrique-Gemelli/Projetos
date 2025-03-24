package com.Gemas.restful_web_service.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest API

@RestController
public class HelloWorldController {

	@GetMapping("/Hello_world")
	public String helloWorld() {
		return "Hello world";
	}
}
