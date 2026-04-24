/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 *
 * @author ESTUDIANTE
 */
public class Prestamo {
    private static int contadorId = 1;
    private final int id;
    private Libro libro;
    private String usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(Libro libro, String usuario, LocalDate fechaPrestamo) {
        this.id = generarNuevoId();
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
    }
    
    private static int generarNuevoId() {
        return contadorId++;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public int getId() {
        return id;
    }

    public Libro getLibro() {
        return libro;
    }

    public String getUsuario() {
        return usuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public static void setContadorId(int contadorId) {
        Prestamo.contadorId = contadorId;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void devolverLibro(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        libro.devolver();
    }
    
    public double calcularMulta() {

        LocalDate fechaFin;

        if (fechaDevolucion == null) {
            fechaFin = LocalDate.now();
        } else {
            fechaFin = fechaDevolucion;
        }

        long dias = ChronoUnit.DAYS.between(fechaPrestamo, fechaFin);

        if (dias > 7) {
            return (dias - 7) * 1000;
        }

        return 0;
    }
    
}
