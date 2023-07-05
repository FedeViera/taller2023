/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Agustin Tuduri
 */
public class Docente extends Usuario
{

    private String asignatura;  

    
    public Docente(String asignatura, int id_usurio, String nom_usuario, String cont_usuario) {
        super(id_usurio, nom_usuario, cont_usuario);
        

        this.asignatura = asignatura;
    }


    public String getAsignatura() {
        return asignatura;
    }
    
}
