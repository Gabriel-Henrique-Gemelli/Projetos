package com.gemas.Curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemas.Curso.entities.Category;
import com.gemas.Curso.entities.Pedido;
import com.gemas.Curso.entities.Product;
import com.gemas.Curso.repositories.CategoryRepository;
import com.gemas.Curso.repositories.PedidoRepository;
import com.gemas.Curso.repositories.ProductRepository;
import com.gemas.Curso.repositories.UserRepositorie;

@Service
public class productService {

	@Autowired
	private ProductRepository Repository;
	
	public List<Product> findAll(){
		return Repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = Repository.findById(id);
		return obj.get();
		
	}
}
