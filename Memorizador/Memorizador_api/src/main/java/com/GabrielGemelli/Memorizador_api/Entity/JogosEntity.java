package com.GabrielGemelli.Memorizador_api.Entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Jogos")
public class JogosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID UUID;
    
    private String titulo;
    private String autor;
    private int nota;
    private int duracao;
    private String imageUrl;


    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
