package com.Projetos.Memorizador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projetos.Memorizador.Entitis.User;
import com.Projetos.Memorizador.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();

	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("User not found: " + id);
		}

	}

	public void updateData(User entity, User obj) {
		if (obj.getName() != null) {
			entity.setName(obj.getName());
		} 
		else if (obj.getPassword() != null) {
			entity.setPassword(obj.getPassword());
		} 
		else if (obj.getAnime() != null) {
			entity.setAnime(obj.getAnime());
		} 
		else if (obj.getJogo() != null) {
			entity.setJogo(obj.getJogo());
		} 
		else if (obj.getLivro() != null) {
			entity.setLivro(obj.getLivro());
		} 
		else if (obj.getSerie() != null) {
			entity.setSerie(obj.getSerie());
		}

	}
}
