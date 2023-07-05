/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Agustin Tuduri
 */
public class Usuario
{
    private int id_usurio;
    private String nom_usuario;
    private String cont_usuario;

    public int getId_usurio() {
        return id_usurio;
    }

    public String getNom_usuario() {
        return nom_usuario;
    }

    public String getCont_usuario() {
        return cont_usuario;
    }

    public Usuario(int id_usurio, String nom_usuario, String cont_usuario) {
        this.id_usurio = id_usurio;
        this.nom_usuario = nom_usuario;
        this.cont_usuario = cont_usuario;
    }    
}
