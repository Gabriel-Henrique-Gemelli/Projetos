package com.Gemas.Memorizador.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_anime")
public class anime implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nome;
	private String autor;
	private LocalDate dataCriaçao;
	private int nota;
	public anime() {
		super();
	}
	public anime(String nome, String autor, LocalDate dataCriaçao, int nota) {
		super();
		this.nome = nome;
		this.autor = autor;
		this.dataCriaçao = dataCriaçao;
		this.nota = nota;
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public LocalDate getDataCriaçao() {
		return dataCriaçao;
	}
	public void setDataCriaçao(LocalDate dataCriaçao) {
		this.dataCriaçao = dataCriaçao;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
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
		anime other = (anime) obj;
		return Objects.equals(id, other.id);
	}
	
}
