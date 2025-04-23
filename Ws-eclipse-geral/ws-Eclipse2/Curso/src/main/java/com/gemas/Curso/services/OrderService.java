package com.gemas.Curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemas.Curso.entities.Order;
import com.gemas.Curso.repositories.OrderRepository;
import com.gemas.Curso.repositories.UserRepositorie;

@Service
public class OrderService {

	@Autowired
	private OrderRepository Repository;
	
	public List<Order> findAll(){
		return Repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = Repository.findById(id);
		return obj.get();
		
	}
}