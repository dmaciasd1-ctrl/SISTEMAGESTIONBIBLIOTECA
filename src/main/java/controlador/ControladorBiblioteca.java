/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalDate;
import modelo.Autor;
import modelo.Biblioteca;
import modelo.Categoria;
import modelo.Libro;
import modelo.Prestamo;
import vista.VistaBiblioteca;

/**
 *
 * @author GIGAUSER
 */
public class ControladorBiblioteca {
    private Biblioteca biblioteca;
    private VistaBiblioteca vista;

    public ControladorBiblioteca() {
        biblioteca = new Biblioteca();
        vista = new VistaBiblioteca();
    }

    public void iniciar() {
            int opcion;

    do {
        opcion = vista.mostrarMenu();

        switch (opcion) {

            case 1:
                String nombreCat = vista.pedirTexto("Nombre categoria:");
                biblioteca.agregarCategoria(new Categoria(nombreCat));
                break;

            case 2: 
                String nombre = vista.pedirTexto("Nombre autor:");
                String pais = vista.pedirTexto("País:");
                int anio = Integer.parseInt(vista.pedirTexto("Anio:"));
                biblioteca.agregarAutor(new Autor(nombre, pais, anio));
                break;

            case 3:
                String titulo = vista.pedirTexto("Titulo:");
                String isbn = vista.pedirTexto("ISBN:");

                String nombreAutor = vista.pedirTexto("Autor:");
                Autor autor = biblioteca.buscarAutor(nombreAutor);

                String nombreCategoria = vista.pedirTexto("Categoria:");
                Categoria categoria = biblioteca.buscarCategoria(nombreCategoria);

                if (autor == null) {
                    System.out.println("Autor no existe");

                } else if (categoria == null) {
                    System.out.println("Categoria no existe");

                } else {
                    Libro libro = new Libro(isbn, titulo, autor, categoria);
                    categoria.agregarLibro(libro);
                    System.out.println("Libro agregado correctamente");
                }
                break;

            case 4: 
                String libroPrestamo = vista.pedirTexto("Libro:");
                Libro l = biblioteca.buscarLibro(libroPrestamo);

                if (l == null) {
                    System.out.println("Libro no existe");

                } else if (!l.isDisponible()) {
                    System.out.println("Libro ya está prestado");

                } else {
                    String usuario = vista.pedirTexto("Usuario:");
                    String fechaTexto = vista.pedirTexto("Fecha préstamo (YYYY-MM-DD):");

                    try {
                        LocalDate fecha = LocalDate.parse(fechaTexto);

                        l.prestar();
                        biblioteca.agregarPrestamo(new Prestamo(l, usuario, fecha));

                        System.out.println("Préstamo realizado");

                    } catch (Exception e) {
                        System.out.println("Formato de fecha inválido");
                    }
                }
                break;
            case 5:
                String libroDev = vista.pedirTexto("Libro a devolver:");
                Libro ld = biblioteca.buscarLibro(libroDev);

                if (ld != null) {

                    Prestamo prestamo = biblioteca.buscarPrestamoActivo(ld);

                    if (prestamo != null) {

                        String fechaDevTexto = vista.pedirTexto("Fecha devolución (YYYY-MM-DD):");

                        try {
                            LocalDate fechaDev = LocalDate.parse(fechaDevTexto);

                            prestamo.devolverLibro(fechaDev);

                            System.out.println("Libro devuelto");

                            double multa = prestamo.calcularMulta();
                            if (multa > 0) {
                                System.out.println("Multa: " + multa);
                            }

                        } catch (Exception e) {
                            System.out.println("Formato de fecha inválido");
                        }

                    } else {
                        System.out.println("Ese libro no está prestado");
                    }

                } else {
                    System.out.println("Libro no existe");
                }
                break;
            case 6:
                for (Categoria cat : biblioteca.getCategorias()) {
                    for (Libro lib : cat.getLibros()) {
                        if (lib.isDisponible()) {
                            System.out.println(lib.getTitulo());
                        }
                    }
                }
                break;

            case 7: 
                String autorBuscar = vista.pedirTexto("Autor:");
                Autor a = biblioteca.buscarAutor(autorBuscar);

                if (a != null) {
                    System.out.println("ID: " + a.getId());
                    System.out.println("Nombre: " + a.getNombre());
                    System.out.println("Pais: " + a.getPais());
                    System.out.println("Anio Nacimiento: " +a.getAño_nacimiento());
                }
                break;

            case 8:
                String catBuscar = vista.pedirTexto("Categoria:");
                Categoria categoriaBuscada = biblioteca.buscarCategoria(catBuscar);

                if (categoriaBuscada != null) {
                    for (Libro lib : categoriaBuscada.getLibros()) {
                        System.out.println(lib.getTitulo());
                    }
                }
                break;

            case 9:
                System.out.println("- Total de multas -");
                biblioteca.mostrarDeudores();
                break;

            case 10:
                int totalLibros = 0;
                for (Categoria cat : biblioteca.getCategorias()) {
                    totalLibros += cat.getLibros().size();
                }

                System.out.println("Total autores: " + biblioteca.getAutores().size());
                System.out.println("Total libros: " + totalLibros);
                System.out.println("Total prestamos: " + biblioteca.getPrestamos().size());
                break;

            case 11:
                System.out.println("Saliendo...");
                break;
        }

    } while (opcion != 11);
    }
}
