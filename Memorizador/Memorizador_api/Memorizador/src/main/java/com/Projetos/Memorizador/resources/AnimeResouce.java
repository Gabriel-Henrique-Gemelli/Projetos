package com.Projetos.Memorizador.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projetos.Memorizador.Entitis.Animes;
import com.Projetos.Memorizador.services.AnimeService;

@RestController
@RequestMapping(value = "/anime")
public class AnimeResouce {

	@Autowired
	private AnimeService service;

	@GetMapping
	public ResponseEntity<List<Animes>> findAll() {
		List<Animes> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Animes> findById(@PathVariable Long id) {
		Animes obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
