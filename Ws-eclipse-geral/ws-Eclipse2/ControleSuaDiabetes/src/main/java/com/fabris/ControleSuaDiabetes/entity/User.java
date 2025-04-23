package com.fabris.ControleSuaDiabetes.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "user_Table")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@NotEmpty(message = "Nome não pode ser vazio")

	private String nome;

	@NotEmpty(message = "Email não pode ser vazio")
	private String email;

	@CPF(message = "CPF inválido")
	@NotEmpty(message = "CPF não pode ser vazio")
	private String CPF;

	public User() {
		super();
	}

	public User(String nome, String email, String CPF) {
		super();
		this.nome = nome;
		this.email = email;
		this.CPF = CPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public UUID getId() {
		return id;
	}

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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}

}
