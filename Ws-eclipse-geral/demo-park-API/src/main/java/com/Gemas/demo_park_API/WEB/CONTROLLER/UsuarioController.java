package com.Gemas.demo_park_API.WEB.CONTROLLER;

import java.net.URI;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.Gemas.demo_park_API.ENTITY.Usuario;
import com.Gemas.demo_park_API.WEB.DTO.DTOUsuarioEMensagemErro;
import com.Gemas.demo_park_API.WEB.DTO.UsuarioCreateDTO;
import com.Gemas.demo_park_API.WEB.DTO.UsuarioResponseDTO;
import com.Gemas.demo_park_API.WEB.DTO.UsuarioSenhaDTO;
import com.Gemas.demo_park_API.WEB.DTO.MAPPER.UsuarioMapper;
import com.Gemas.demo_park_API.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	private final UsuarioService usuarioService;
	ModelMapper modelMapper = new ModelMapper();

	@PostMapping
	public ResponseEntity<DTOUsuarioEMensagemErro> create(@RequestBody UsuarioCreateDTO usuario,
			UriComponentsBuilder uriBuilder) {
		try {
			Usuario User = usuarioService.salvar(UsuarioMapper.toUsuario(usuario));
			URI uri = uriBuilder.path("/api/usuario/{id}").buildAndExpand(User.getId()).toUri();
			UsuarioResponseDTO usuarioResponse = UsuarioMapper.toDTO(User);
			DTOUsuarioEMensagemErro response = new DTOUsuarioEMensagemErro(usuarioResponse,
					"Usuário criado com sucesso!");
			return ResponseEntity.created(uri).body(response);
		} catch (Exception e) {
			e.printStackTrace();
			DTOUsuarioEMensagemErro errorResponse = new DTOUsuarioEMensagemErro(null,
					"Erro ao criar usuário: " + e.getMessage());
			return ResponseEntity.badRequest().body(errorResponse);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<DTOUsuarioEMensagemErro> findById(@PathVariable Long id) {
		try {

			Usuario usuario = usuarioService.findById(id);
			UsuarioResponseDTO usuarioResponse = UsuarioMapper.toDTO(usuario);
			DTOUsuarioEMensagemErro response = new DTOUsuarioEMensagemErro(usuarioResponse,
					"Usuário encontrado com sucesso!");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			DTOUsuarioEMensagemErro errorResponse = new DTOUsuarioEMensagemErro(null,
					"Erro ao buscar usuário: " + e.getMessage());
			return ResponseEntity.badRequest().body(errorResponse);
		}

	}

	@GetMapping()
	public ResponseEntity<List<UsuarioResponseDTO>> getAll() {
		List<Usuario> Users = usuarioService.findAll();
		return ResponseEntity.ok(UsuarioMapper.toDTOList(Users));
	}

	// patch e parcial e put e uma alteraçao total do objeto

	@PatchMapping("/{id}")
	public ResponseEntity<Void> UpdatePassword(@RequestBody UsuarioSenhaDTO usuarioDTO, @PathVariable Long id) {
		Usuario user = usuarioService.EditarSenha(id, usuarioDTO.getSenhaAtual(),usuarioDTO.getNovaSenha(), usuarioDTO.getConfirmarSenha());
		return ResponseEntity.noContent().build();
	}
}
