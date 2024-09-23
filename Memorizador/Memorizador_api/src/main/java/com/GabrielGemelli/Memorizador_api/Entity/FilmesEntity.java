package com.GabrielGemelli.Memorizador_api.Entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tb_Filme")
public class FilmesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID UUID;
    
    private int duracao;
    private String titulo;
    private int nota;
    private String imageUrl;
    private String autor;

    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public UUID getUUID() {
        return UUID;
    }
    public void setUUID(UUID uUID) {
        UUID = uUID;
    }
    

}
