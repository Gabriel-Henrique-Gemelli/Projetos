package com.gemas.Curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gemas.Curso.entities.Category;
import com.gemas.Curso.entities.Order;
import com.gemas.Curso.entities.Product;
import com.gemas.Curso.entities.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
