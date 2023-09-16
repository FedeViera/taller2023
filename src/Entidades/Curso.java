package Entidades;

public class Curso
{
    private String id_curso;
    private String asignatura;

    public Curso(String id_curso, String asignatura) {
        this.id_curso = id_curso;
        this.asignatura = asignatura;
    }

    public String getId_curso() {
        return id_curso;
    }

    public void setId_curso(String id_curso) {
        this.id_curso = id_curso;
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
