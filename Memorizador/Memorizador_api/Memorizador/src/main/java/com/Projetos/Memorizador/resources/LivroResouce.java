package com.Projetos.Memorizador.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projetos.Memorizador.Entitis.Livro;
import com.Projetos.Memorizador.services.LivroService;

@RestController
@RequestMapping(value = "/livro")
public class LivroResouce {
	
	@Autowired
	private LivroService service;
	
	@GetMapping
	public ResponseEntity<List<Livro>> findAll() {
		List<Livro> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Long id) {
		Livro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
