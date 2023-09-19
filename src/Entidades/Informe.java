package Entidades;

public class Informe 
{
    private int id_informe;
    private String descripcion;
    private String fecha;

    public int getId_informe() {
        return id_informe;
    }

    public void setId_informe(int id_informe) {
        this.id_informe = id_informe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Informe() {
    }

    public Informe(int id_informe, String descripcion, String fecha) {
        this.id_informe = id_informe;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
    
    

    
    
    
}
