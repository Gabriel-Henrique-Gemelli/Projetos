package com.fabris.ControleSuaDiabetes.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabris.ControleSuaDiabetes.entity.User;
import com.fabris.ControleSuaDiabetes.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

	 @Autowired
	    private UserService service;

	    @GetMapping
	    public ResponseEntity<List<User>> findAll() {
	        return ResponseEntity.ok(service.findAll());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<User> findById(@PathVariable UUID id) {
	        return service.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<User> save(@RequestBody User user) {
	        User created = service.save(user);
	        return ResponseEntity.ok(created);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable UUID id) {
	        if (service.findById(id).isPresent()) {
	        	service.deleteById(id);
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.notFound().build();
	    }
}
