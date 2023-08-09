package Entidades;
import Persistencia.Usuario_SQL;

public class Usuario
{
    private int cedula;
    private String cargo;
    private String nombre_usuario;
    private String contrasenia_usuario;

    public Usuario() {
    }

    
    
    public int getId_usuario() {
        return cedula;
    }

    public void setId_usuario(int id_usuario) {
        this.cedula = id_usuario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasenia_usuario() {
        return contrasenia_usuario;
    }

    public void setContrasenia_usuario(String contrasenia_usuario) {
        this.contrasenia_usuario = contrasenia_usuario;
    }

    public Usuario(int id_usuario, String cargo, String nombre_usuario, String contrasenia_usuario) {
        this.cedula = id_usuario;
        this.cargo = cargo;
        this.nombre_usuario = nombre_usuario;
        this.contrasenia_usuario = contrasenia_usuario;
    }

}
