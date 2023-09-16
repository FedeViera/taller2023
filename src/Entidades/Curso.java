package Entidades;

public class Curso
{
    private String asignatura;

    public Curso(int id_curso, String asignatura) {
        this.asignatura = asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public Curso() {
    }
    
    
    
}
