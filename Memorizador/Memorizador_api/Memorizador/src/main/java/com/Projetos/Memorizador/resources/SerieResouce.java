package com.Projetos.Memorizador.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projetos.Memorizador.Entitis.Serie;
import com.Projetos.Memorizador.services.SerieService;

@RestController
@RequestMapping(value = "/serie")
public class SerieResouce {
	
	@Autowired
	private SerieService service;
	
	@GetMapping
	public ResponseEntity<List<Serie>> findAll() {
		List<Serie> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Serie> findById(@PathVariable Long id) {
		Serie obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
