package com.Projetos.Memorizador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projetos.Memorizador.Entitis.jogo;
import com.Projetos.Memorizador.repositories.JogoRepository;

@Service
public class JogoService {

	@Autowired
	private JogoRepository repository;

	public List<jogo> findAll() {
		return repository.findAll();
	}
	
	public jogo findById(Long id) {
		Optional<jogo> obj = repository.findById(id);
		return obj.get();
		
	}
}
