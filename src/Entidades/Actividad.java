package Entidades;

import java.sql.Date;

public class Actividad 
{
    private int id_actividad;
    private int id_estudiante;
    private String tipo;
    private String descripcion;
    private float calificacion;
    private Date fecha;

    public Actividad() {
    }

    public Actividad(int id_actividad, int id_estudiante, String tipo, String descripcion, float calificacion, Date fecha) {
        this.id_actividad = id_actividad;
        this.id_estudiante = id_estudiante;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.fecha = fecha;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    
    
    

    
    
    
}
