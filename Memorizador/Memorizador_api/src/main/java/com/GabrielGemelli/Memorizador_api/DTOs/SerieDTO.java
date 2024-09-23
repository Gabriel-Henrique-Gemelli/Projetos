package com.GabrielGemelli.Memorizador_api.DTOs;

public class SerieDTO {
    private int qntEp;
    private String titulo;
    private String autor;
    private int nota;
    private String imageUrl;
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public int getQntEp() {
        return qntEp;
    }
    public void setQntEp(int qntEp) {
        this.qntEp = qntEp;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
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

    

}
