/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Sidorf
 */
public class Docente extends Usuario
{
     private String asignatura;  

    public Docente(String asignatura, int id_usuario, String cargo, String nombre_usuario, String contrasenia_usuario) {
        super(id_usuario, cargo, nombre_usuario, contrasenia_usuario);
        this.asignatura = asignatura;
    }

    public String getAsignatura() 
    {
        return asignatura;
    }
    
}
