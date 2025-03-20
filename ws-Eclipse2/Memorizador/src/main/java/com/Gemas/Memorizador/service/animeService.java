package com.Gemas.Memorizador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.Gemas.Memorizador.entity.anime;
import com.Gemas.Memorizador.repository.animeRepository;
import com.Gemas.Memorizador.service.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class animeService {

	@Autowired
	private animeRepository Repository;
	
	public List<anime> findAll(){
		return Repository.findAll();
	}
	
	public anime findById(Long id) {
		Optional<anime> obj = Repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Erro ao encontrar anime com id:" + id));
		
	}
	
	public anime insert(anime obj) {
		return Repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			Repository.deleteById(id);	
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(e.getMessage());
		} catch(DataIntegrityViolationException e1) {
			throw new ResourceNotFoundException(e1.getMessage());
		}
		
		
	}
	
	public anime update(Long id,anime obj) {
		try {
			anime entity = Repository.getReferenceById(id);
			updateData(entity,obj);
			return Repository.save(entity);	
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(e.getMessage());
		}
	}
	
	private void updateData(anime entity,anime obj) {
		entity.setNome(obj.getNome());
		entity.setNota(obj.getNota());
		entity.setAutor(obj.getAutor());
		entity.setDataCriaçao(obj.getDataCriaçao());
		
	}
}
