package com.Projetos.Memorizador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projetos.Memorizador.Entitis.Serie;
import com.Projetos.Memorizador.repositories.SerieRepository;

@Service
public class SerieService {

	@Autowired
	private SerieRepository repository;

	public List<Serie> findAll() {
		return repository.findAll();
	}
	
	public Serie findById(Long id) {
		Optional<Serie> obj = repository.findById(id);
		return obj.get();
		
	}
}
