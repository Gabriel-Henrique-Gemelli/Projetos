package com.Gabriel.henrique.gemelli.financeiro.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Gabriel.henrique.gemelli.financeiro.entity.Gastos;
import com.Gabriel.henrique.gemelli.financeiro.repository.GastosRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GastosService {

	private final GastosRepository repository;

	@Transactional
	public Gastos save(Gastos gasto) {
		return repository.save(gasto);
	}

	public List<Gastos> GetAll() {
		
		return repository.findAll();
	}
}
