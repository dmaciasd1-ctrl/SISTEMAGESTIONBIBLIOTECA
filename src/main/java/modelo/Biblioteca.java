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
    
    public Autor buscarAutor(String nombre) {
        for (Autor a : autores) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                return a;
            }
        }
        return null;
    }

    public Categoria buscarCategoria(String nombre) {
        for (Categoria c : categorias) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    public Libro buscarLibro(String titulo) {
        for (Categoria c : categorias) {
            for (Libro l : c.getLibros()) {
                if (l.getTitulo().equalsIgnoreCase(titulo)) {
                    return l;
                }
            }
        }
        return null;
    }

    public void mostrarDeudores() {
        boolean hayDeuda = false;

        for (Prestamo p : prestamos) {

            // 🔥 SOLO si no ha devuelto
            if (p.getFechaDevolucion() == null) {

                double multa = p.calcularMulta();

                if (multa > 0) {
                    System.out.println("Usuario: " + p.getUsuario());
                    System.out.println("Libro: " + p.getLibro().getTitulo());
                    System.out.println("Fecha préstamo: " + p.getFechaPrestamo());
                    System.out.println("Deuda: " + multa);
                    System.out.println("----------------------");

                    hayDeuda = true;
                }
            }
        }

        if (!hayDeuda) {
            System.out.println("No hay usuarios con deuda");
        }
    }
    
    public Prestamo buscarPrestamoActivo(Libro libro) {
    for (Prestamo p : prestamos) {
        if (p.getLibro().equals(libro) && p.getFechaDevolucion() == null) {
            return p;
        }
    }
    return null;
    }

}
