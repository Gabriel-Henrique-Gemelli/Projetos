package com.Gemas.restful_web_service.Entitys;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Gemas.restful_web_service.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jpa/users")
public class UserJpaResources {

    private UserRepository Repository;
	private UserDaoService service;

	public UserJpaResources(UserDaoService service, UserRepository Repository) {
		this.service = service;
		this.Repository = Repository;
	}

	@GetMapping
	public List<User> retrieveAllUsers() {
		return Repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable Long id){
		Optional<User> obj = Repository.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}

	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User saveduser = service.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
