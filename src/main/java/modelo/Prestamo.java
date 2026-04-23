/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;
/**
 *
 * @author ESTUDIANTE
 */
public class Prestamo {
    private static int contadorId = 0;
    private final int id;
    private Libro libro;
    private String usuario;
    private LocalDate fechaSalida;
    private LocalDate fechaDevolucion;

    public Prestamo(Libro libro, String usuario) {
        this.id = generarNuevoId();
        this.libro = libro;
        this.usuario = usuario;
        this.fechaSalida = LocalDate.now();
    }
    
    private static int generarNuevoId() {
        return ++contadorId;
    }

    public int getId() {
        return id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    
}
