package com.Gemas.restful_web_service.HelloWorld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Rest API

@RestController
public class HelloWorldController {
	
	private MessageSource message;
	
	

	public HelloWorldController(MessageSource message) {
		super();
		this.message = message;
	}

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
	
	@GetMapping("/Hello_world_internationalized")
	public String helloWorldInternationalized() { // serve para pegar uma variavel digitada no navegador
		Locale locale = LocaleContextHolder.getLocale();
		return message.getMessage("good.morning.message", null, "Default Message", locale);
	}
	
}
