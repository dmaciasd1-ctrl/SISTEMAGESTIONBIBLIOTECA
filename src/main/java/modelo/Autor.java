/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ESTUDIANTE
 */
public class Autor {
    private static int contador = 1;
    private int id;
    private final String nombre;
    private String pais;
    private int año_nacimiento;

    public Autor(String nombre, String pais, int año_nacimiento) {
        this.id = contador++;
        this.nombre = nombre;
        this.pais = pais;
        this.año_nacimiento = año_nacimiento;
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

    public String getPais() {
        return pais;
    }

    public int getAño_nacimiento() {
        return año_nacimiento;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setAño_nacimiento(int año_nacimiento) {
        this.año_nacimiento = año_nacimiento;
    }

    
    
    
}
