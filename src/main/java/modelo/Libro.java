/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ESTUDIANTE
 */
public class Libro {
    
    private final String isbn;
    private final String titulo;
    private Autor autor;       
    private Categoria categoria;
    private boolean disponible;

    public Libro(String isbn, String titulo, Autor autor, Categoria categoria) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.disponible = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void prestar() {
        disponible = false;
    }

    public void devolver() {
        disponible = true;
    }

}
