package com.gemas.Curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemas.Curso.entities.User;
import com.gemas.Curso.repositories.UserRepositorie;

@Service
public class UserService {

	@Autowired
	private UserRepositorie Repository;
	
	public List<User> findAll(){
		return Repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = Repository.findById(id);
		return obj.get();
		
	}
}
