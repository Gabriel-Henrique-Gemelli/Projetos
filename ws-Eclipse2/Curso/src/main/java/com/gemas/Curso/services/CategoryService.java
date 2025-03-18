package com.gemas.Curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemas.Curso.entities.Category;
import com.gemas.Curso.entities.Pedido;
import com.gemas.Curso.repositories.CategoryRepository;
import com.gemas.Curso.repositories.PedidoRepository;
import com.gemas.Curso.repositories.UserRepositorie;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository Repository;
	
	public List<Category> findAll(){
		return Repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = Repository.findById(id);
		return obj.get();
		
	}
}
