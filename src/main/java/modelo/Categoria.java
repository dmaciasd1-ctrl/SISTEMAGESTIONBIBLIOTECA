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
public class Categoria {
    private static int contador = 1;
    private final int id;
    private final String nombre;
    private ArrayList<Libro> libros;

    public Categoria(String nombre) {
        this.id = contador++;
        this.nombre = nombre;
        this.libros = new ArrayList<>();    
    }

    public static int getContador() {
        return contador;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }
    
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
    
}
