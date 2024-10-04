package com.Projetos.Memorizador.Entitis;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_jogo")
public class jogo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer TempJogo;
	private Integer nota;
	private String img;
	@ManyToMany(mappedBy = "jogo")
	private Set<User> usuarios = new HashSet<>();
	
	public jogo() {
		
	}
	
	public jogo(Long id, String nome, Integer tempJogo, Integer nota, String img, Set<User> usuarios) {
		super();
		this.id = id;
		this.nome = nome;
		TempJogo = tempJogo;
		this.nota = nota;
		this.img = img;
		this.usuarios = usuarios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTempJogo() {
		return TempJogo;
	}

	public void setTempJogo(Integer tempJogo) {
		TempJogo = tempJogo;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Set<User> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<User> usuarios) {
		this.usuarios = usuarios;
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
		jogo other = (jogo) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
