/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Sidorf
 */
public class Docentes extends Usuario
{
     private String asignatura;  

    
    public Docentes( int id_usurio, String nom_usuario, String cont_usuario, String asignatura) {
        super(id_usurio, nom_usuario, cont_usuario);
        

        this.asignatura = asignatura;
    }


    public String getAsignatura() 
    {
        return asignatura;
    }
    
}
