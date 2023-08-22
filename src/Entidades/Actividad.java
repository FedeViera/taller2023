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
    
    
}
