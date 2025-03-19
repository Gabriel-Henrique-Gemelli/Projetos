package com.gemas.Curso.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gemas.Curso.entities.Category;
import com.gemas.Curso.entities.Order;
import com.gemas.Curso.entities.Product;
import com.gemas.Curso.entities.User;
import com.gemas.Curso.services.CategoryService;
import com.gemas.Curso.services.OrderService;
import com.gemas.Curso.services.productService;

@RestController
@RequestMapping(value = "/products")
public class ProductResources {
	@Autowired
	private productService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list =service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
