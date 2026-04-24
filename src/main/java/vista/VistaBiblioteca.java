/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.Scanner;

/**
 *
 * @author GIGAUSER
 */
public class VistaBiblioteca {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("===== SISTEMA DE GESTION BIBLIOTECA =====");
        System.out.println("1. Crear nueva Categoria");
        System.out.println("2. Agregar nuevo Autor");
        System.out.println("3. Agregar nuevo Libro");
        System.out.println("4. Realizar Prestamo");
        System.out.println("5. Devolver Libro Prestado");
        System.out.println("6. Ver Libros Disponibles");
        System.out.println("7. Ver Detalles de Autor");
        System.out.println("8. Ver Libros de una Categoria");
        System.out.println("9. Ver Multas Acumuladas");
        System.out.println("10. Ver Estadisticas");
        System.out.println("11. Salir");

        System.out.print("Seleccione una opcion: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        return opcion;
    }

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje + " ");
        return sc.nextLine();
    }
}
