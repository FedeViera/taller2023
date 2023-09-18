package Entidades;

public class Curso
{
    private int id_curso;
    private String claseYgrupo;
    private String asignatura;

    public Curso() {
    }

    public Curso(int id_curso, String claseYgrupo, String asignatura) {
        this.id_curso = id_curso;
        this.claseYgrupo = claseYgrupo;
        this.asignatura = asignatura;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getClaseYgrupo() {
        return claseYgrupo;
    }

    public void setClaseYgrupo(String claseYgrupo) {
        this.claseYgrupo = claseYgrupo;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    
    
    
    
    
    
}
