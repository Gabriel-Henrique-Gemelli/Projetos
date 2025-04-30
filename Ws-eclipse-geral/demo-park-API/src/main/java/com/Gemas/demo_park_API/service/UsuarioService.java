package com.Gemas.demo_park_API.service;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.Gemas.demo_park_API.ENTITY.Usuario;
import com.Gemas.demo_park_API.REPOSITORY.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	@Transactional
	public Usuario salvar(Usuario usuario) {
		// Salvar o usuário no banco de dados
		return usuarioRepository.save(usuario);
	}

	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		// Buscar o usuário pelo ID
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Usuário não encontrado"));
	}

	@Transactional
	public Usuario EditarSenha(Long id, String senhaAtual, String novaSenha, String confirmarSenha) {
		Usuario usuario = findById(id);

		if (usuario != null) {

			if (usuario.getSenha().equals(senhaAtual)) {
				if (novaSenha.equals(confirmarSenha)) {
					usuario.setSenha(novaSenha);
				} else {
					throw new ResponseStatusException(HttpStatusCode.valueOf(400), "As senhas não coincidem");
				}

			} else {
				throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Senha atual incorreta");
			}

			return usuario;
		} else {
			throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Usuário não encontrado");
		}

	}

	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

}
