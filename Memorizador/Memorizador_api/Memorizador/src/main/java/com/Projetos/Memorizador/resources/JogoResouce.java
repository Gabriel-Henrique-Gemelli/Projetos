package com.Projetos.Memorizador.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projetos.Memorizador.Entitis.jogo;
import com.Projetos.Memorizador.services.JogoService;

@RestController
@RequestMapping(value = "/jogo")
public class JogoResouce {
	
	@Autowired
	private JogoService service;
	
	@GetMapping
	public ResponseEntity<List<jogo>> findAll() {
		List<jogo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<jogo> findById(@PathVariable Long id) {
		jogo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
