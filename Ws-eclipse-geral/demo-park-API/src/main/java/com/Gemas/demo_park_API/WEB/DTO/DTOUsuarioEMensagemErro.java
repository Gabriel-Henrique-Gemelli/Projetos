package com.Gemas.demo_park_API.WEB.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DTOUsuarioEMensagemErro {
	private UsuarioResponseDTO usuario;
    private String mensagem;
}
