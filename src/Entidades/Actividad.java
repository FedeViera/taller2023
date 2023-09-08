package Entidades;

public class Actividad 
{
    private int id_actividad;
    private String nombre;
    private String descripcion;
    private int cedula_docente;

    public Actividad(int id_actividad, String nombre, String descripcion, int cedula_docente) {
        this.id_actividad = id_actividad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cedula_docente = cedula_docente;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCedula_docente(int cedula_docente) {
        this.cedula_docente = cedula_docente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCedula_docente() {
        return cedula_docente;
    }
    
    
}
