package com.GabrielGemelli.Memorizador_api.DTOs;

public class AnimesDTO {
    private String titulo;
    private int QntEp;
    private String Autor;
    private String imageUrl;
    private int nota;

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }

    
}
