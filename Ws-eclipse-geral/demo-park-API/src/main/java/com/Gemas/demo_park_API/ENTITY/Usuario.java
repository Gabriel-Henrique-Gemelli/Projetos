package com.Gemas.demo_park_API.ENTITY;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.Gemas.demo_park_API.ENUM.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome", nullable = false, length = 100)
	private String nome;

	@Column(name = "email", nullable = false, length = 100, unique = true)
	private String email;

	@Column(name = "senha", nullable = false, length = 200)
	private String senha;

	@Column(name = "role", nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private Role role = Role.CLIENTE;

	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao;

	@Column(name = "data_modificacao")
	private LocalDateTime dataModificacao;

	@Column(name = "criado_por")
	private String criadoPor;

	@Column(name = "modificado_por")
	private String modificadoPor;

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

}
