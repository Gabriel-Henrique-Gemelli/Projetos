package com.Gemas.restful_web_service.Entitys;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.Servlet;

@RestController
@RequestMapping("/users")
public class UserResources {

	private UserDaoService service;
	
	public UserResources(UserDaoService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	
	@GetMapping("/{id}")
	public User retrieveUser(@PathVariable int id){
		return service.findOne(id);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User saveduser =  service.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId()).toUri();
		return ResponseEntity.created(location  ).build();
	}
	
	
}
