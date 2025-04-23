package com.Gemas.restful_web_service.Entitys;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "User-properties")
//@JsonIgnoreProperties("Nome do idiota de merda")
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@Size(min = 2, message = "Nome deve ter mais do que pelo menos 2 caracteres")
	@JsonProperty("Nome do idiota de merda")
	private String name;

	@Past(message = "Datas devem ser no passado")
	@JsonProperty("Data de nascimento do otario")
	private LocalDate birthDate;

	public User() {
		super();
	}

	public User(Long id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
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

}
