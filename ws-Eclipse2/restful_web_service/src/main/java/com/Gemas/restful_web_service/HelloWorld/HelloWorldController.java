package com.Gemas.restful_web_service.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Rest API

@RestController
public class HelloWorldController {

	@GetMapping("/Hello_world")
	public String helloWorld() {
		return "Hello world";
	}
	
	@GetMapping("/Hello_world_bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello world");
	}
	@GetMapping("/Hello_world_bean/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) { // serve para pegar uma variavel digitada no navegador
		return new HelloWorldBean(String.format("Hello world", name) + " " + name);
	}
}
