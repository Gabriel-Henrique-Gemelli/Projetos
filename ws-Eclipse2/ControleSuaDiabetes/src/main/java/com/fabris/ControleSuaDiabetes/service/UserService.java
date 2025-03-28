package com.fabris.ControleSuaDiabetes.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabris.ControleSuaDiabetes.entity.User;
import com.fabris.ControleSuaDiabetes.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	 public List<User> findAll() {
	        return repository.findAll();
	    }

	    public Optional<User> findById(UUID id) {
	        return repository.findById(id);
	    }

	    public User save(User user) {
	        return repository.save(user);
	    }

	    public void deleteById(UUID id) {
	    	repository.deleteById(id);
	    }
}
