package com.Projetos.Memorizador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projetos.Memorizador.Entitis.Animes;
import com.Projetos.Memorizador.repositories.AnimeRepository;

@Service
public class AnimeService {

	@Autowired
	private AnimeRepository repository;

	public List<Animes> findAll() {
		return repository.findAll();
	}
	
	public Animes findById(Long id) {
		Optional<Animes> obj = repository.findById(id);
		return obj.get();
		
	}
}
