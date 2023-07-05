/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Sidorf
 */
public class Estudiante 
{
    private int id_estudiante;
    private String nombre;

    public int getId_estudiante() {
        return id_estudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public Estudiante(int id_estudiante, String nombre) {
        this.id_estudiante = id_estudiante;
        this.nombre = nombre;
    }
    
}
