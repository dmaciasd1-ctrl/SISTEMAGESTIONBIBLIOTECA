/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author ESTUDIANTE
 */
public class Biblioteca {
    private ArrayList<Categoria> categorias = new ArrayList<>();
    private ArrayList<Autor> autores = new ArrayList<>();
    private ArrayList<Prestamo> prestamos = new ArrayList<>();

    public Biblioteca() {
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
    
    public void agregarAutor(Autor autor) {
        autores.add(autor);
    }

    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }


}
