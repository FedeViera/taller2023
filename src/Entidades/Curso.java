package Entidades;

public class Curso
{
    private int id_curso;
    private String asignatura;

    public Curso(int id_curso, String asignatura) {
        this.id_curso = id_curso;
        this.asignatura = asignatura;
    }

    public int getId_curso() {
        return id_curso;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
    
    
    
}
