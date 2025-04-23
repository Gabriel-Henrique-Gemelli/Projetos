package com.gemas.Curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gemas.Curso.entities.User;

@Repository
public interface UserRepositorie extends JpaRepository<User, Long>{
	
}
