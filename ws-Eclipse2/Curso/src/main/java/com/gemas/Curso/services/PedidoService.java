package com.gemas.Curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemas.Curso.entities.Pedido;
import com.gemas.Curso.repositories.PedidoRepository;
import com.gemas.Curso.repositories.UserRepositorie;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository Repository;
	
	public List<Pedido> findAll(){
		return Repository.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj = Repository.findById(id);
		return obj.get();
		
	}
}
