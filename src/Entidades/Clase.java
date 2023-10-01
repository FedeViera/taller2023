package Entidades;

import java.sql.Date;

public class Clase 
{
    private int id_clase;
    private Date fecha;
    private String desarrollo;
    private int id_curso;

    public Clase() {
    }

    public Clase(int id_clase, Date fecha, String desarrollo, int id_curso) {
        this.id_clase = id_clase;
        this.fecha = fecha;
        this.desarrollo = desarrollo;
        this.id_curso = id_curso;
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDesarrollo() {
        return desarrollo;
    }

    public void setDesarrollo(String desarrollo) {
        this.desarrollo = desarrollo;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    

    

    
    
    
}
