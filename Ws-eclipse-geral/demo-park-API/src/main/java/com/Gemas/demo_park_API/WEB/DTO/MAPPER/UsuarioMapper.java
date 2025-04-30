package com.Gemas.demo_park_API.WEB.DTO.MAPPER;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.Gemas.demo_park_API.ENTITY.Usuario;
import com.Gemas.demo_park_API.WEB.DTO.UsuarioCreateDTO;
import com.Gemas.demo_park_API.WEB.DTO.UsuarioResponseDTO;

public class UsuarioMapper {
	
	public static Usuario toUsuario(UsuarioCreateDTO usuarioCreateDTO) {
		return new ModelMapper().map(usuarioCreateDTO, Usuario.class);
	}
	public static UsuarioResponseDTO toDTO(Usuario usuario) {
		
		String role = usuario.getRole().name();
		PropertyMap<Usuario,UsuarioResponseDTO> props = new PropertyMap<Usuario, UsuarioResponseDTO>() {
			@Override
			protected void configure() {
				map().setRole(role);
			}
		};
		ModelMapper mapper = new ModelMapper();
		mapper.addMappings(props);
		return mapper.map(usuario, UsuarioResponseDTO.class);
	}
	
	public static List<UsuarioResponseDTO> toDTOList(List<Usuario> usuarios) {
		return usuarios.stream()
				.map(usuario -> toDTO(usuario))
				.toList();
	}

}
