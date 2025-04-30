package com.Gemas.demo_park_API.WEB.DTO;

import lombok.Data;

@Data
public class UsuarioSenhaDTO {

	private String senhaAtual;
	private String novaSenha;
	private String confirmarSenha;
}
