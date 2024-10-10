package com.Projetos.Memorizador.Entitis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;

	
	@ManyToMany
	@JoinTable(name = "usuario_anime", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "anime_id"))
	private List<Animes> anime = new ArrayList<>();

	
	@ManyToMany
	@JoinTable(name = "usuario_livro", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "livro_id"))
	private List<Livro> livro = new ArrayList<>();

	
	@ManyToMany
	@JoinTable(name = "usuario_serie", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "serie_id"))
	private List<Serie> serie = new ArrayList<>();

	
	@ManyToMany
	@JoinTable(name = "usuario_jogo", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "jogo_id"))
	private List<jogo> jogo = new ArrayList<>();

	public User() {

	}
	

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}


	public User(String name, String password, List<Animes> anime, List<Livro> livro, List<Serie> serie,
			List<jogo> jogo) {
		this.name = name;
		this.password = password;
		this.anime = anime;
		this.livro = livro;
		this.serie = serie;
		this.jogo = jogo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public List<Animes> getAnime() {
		return anime;
	}

	public List<Livro> getLivro() {
		return livro;
	}

	public List<Serie> getSerie() {
		return serie;
	}

	public List<jogo> getJogo() {
		return jogo;
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
		return id == other.id;
	}

}
