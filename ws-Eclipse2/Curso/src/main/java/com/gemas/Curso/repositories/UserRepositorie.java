package com.gemas.Curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gemas.Curso.entities.User;

public interface UserRepositorie extends JpaRepository<User, Long>{
	
}
