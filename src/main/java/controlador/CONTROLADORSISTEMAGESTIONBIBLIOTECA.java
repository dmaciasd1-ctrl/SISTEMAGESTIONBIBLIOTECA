/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Autor;
import modelo.Biblioteca;
import modelo.Categoria;
import modelo.Libro;

/**
 *
 * @author ESTUDIANTE
 */
public class CONTROLADORSISTEMAGESTIONBIBLIOTECA {
    private Biblioteca biblioteca;

    public CONTROLADORSISTEMAGESTIONBIBLIOTECA(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void crearAutor(int id, String nombre, String pais, int año_nacimiento) {
        biblioteca.agregarAutor(new Autor(id, nombre, pais, año_nacimiento));
    }

    public void crearCategoria(int id, String nombre) {
        biblioteca.agregarCategoria(new Categoria(id, nombre));
    }

    public void crearLibro(String isbn, String titulo, int indexAutor, int indexCategoria) {
        Autor autor = biblioteca.getAutores().get(indexAutor);
        Categoria categoria = biblioteca.getCategorias().get(indexCategoria);

        Libro libro = new Libro(isbn, titulo, autor, categoria);
        biblioteca.agregarLibro(libro);
        categoria.agregarLibro(libro);
    }

    public void prestarLibro(int indexLibro, String usuario) {
        Libro libro = biblioteca.getLibros().get(indexLibro);
        if (libro.isDisponible()) {
            biblioteca.agregarPrestamo(new Prestamo(libro, usuario));
        }
    }
}
