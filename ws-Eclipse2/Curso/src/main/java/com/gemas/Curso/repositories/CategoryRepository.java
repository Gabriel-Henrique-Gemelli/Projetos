package com.gemas.Curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gemas.Curso.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
