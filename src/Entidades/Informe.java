package Entidades;

public class Informe 
{
    private int id_informe;
    private String diagnostico;

    public Informe() {
    }

    public Informe(int id_informe, String diagnostico) {
        this.id_informe = id_informe;
        this.diagnostico = diagnostico;
    }

    public int getId_informe() {
        return id_informe;
    }

    public void setId_informe(int id_informe) {
        this.id_informe = id_informe;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    

    
    
    
}
