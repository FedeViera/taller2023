/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Sidorf
 */
public class Curso 
{
    private int id_grupo;
    private String docente_asignado;
    private int cantidad;

    public int getId_grupo() {
        return id_grupo;
    }

    public String getDocente_asignado() {
        return docente_asignado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Curso(int id_grupo, String docente_asignado, int cantidad) {
        this.id_grupo = id_grupo;
        this.docente_asignado = docente_asignado;
        this.cantidad = cantidad;
    }
    
}
