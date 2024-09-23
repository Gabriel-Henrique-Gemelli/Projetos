package com.GabrielGemelli.Memorizador_api.DTOs;

public class LivroDTO {
    private String titulo;
    private String autor;
    private String imageUrl;
    private int qntpaginas;
    private int nota;
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
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public int getQntpaginas() {
        return qntpaginas;
    }
    public void setQntpaginas(int qntpaginas) {
        this.qntpaginas = qntpaginas;
    }
    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }
    
}
