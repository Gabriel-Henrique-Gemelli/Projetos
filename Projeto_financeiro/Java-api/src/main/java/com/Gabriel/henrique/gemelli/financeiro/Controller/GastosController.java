package com.Gabriel.henrique.gemelli.financeiro.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gabriel.henrique.gemelli.financeiro.DTO.GastoEMessage;
import com.Gabriel.henrique.gemelli.financeiro.Service.GastosService;
import com.Gabriel.henrique.gemelli.financeiro.entity.Gastos;
import com.Gabriel.henrique.gemelli.financeiro.exception.Message;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequestMapping("/gastos")
@RestController
@RequiredArgsConstructor
public class GastosController {

	private final GastosService service;
	
	@PostMapping
	public ResponseEntity<GastoEMessage<Gastos>> cadastrarGasto(@RequestBody Gastos gasto, HttpServletRequest request) {
		try {
			Gastos gastoSalvo = service.save(gasto);
			return Message.created(request, gastoSalvo);	
		} catch (Exception e) {
			return Message.badRequest(request, null, "Erro ao cadastrar gasto: " + e.getMessage());
		}
		
	}
	
	@GetMapping
	public ResponseEntity<GastoEMessage<List<Gastos>>> GetAll(HttpServletRequest request) {
		List<Gastos> gastos = service.GetAll();
		try {
			return Message.ok(request, gastos);
		} catch (Exception e) {
			return Message.badRequest(request, null, "Erro ao listar gastos: " + e.getMessage());
		}
	}
	
	
	
}
