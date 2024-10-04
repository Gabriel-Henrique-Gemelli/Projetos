package com.Projetos.Memorizador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projetos.Memorizador.Entitis.Livro;
import com.Projetos.Memorizador.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public List<Livro> findAll() {
		return repository.findAll();
	}
	
	public Livro findById(Long id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.get();
		
	}
}
