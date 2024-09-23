package com.GabrielGemelli.Memorizador_api.Entity;


import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Anime")
public class AnimesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID UUID;
    
    private String titulo;
    private int QntEp;
    private String Autor;
    private String imageUrl;
    private int nota;

    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getQntEp() {
        return QntEp;
    }
    public void setQntEp(int qntEp) {
        QntEp = qntEp;
    }
    public String getAutor() {
        return Autor;
    }
    public void setAutor(String autor) {
        Autor = autor;
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
