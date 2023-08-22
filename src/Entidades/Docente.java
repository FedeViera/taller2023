package Entidades;

public class Docente extends Usuario
{
    private int grado;
    private String especialidad;
    private String gradoAcademico;

    public Docente(int grado, String especialidad, String gradoAcademico, int cedula, String nombre, String apellido, String usuario, String contrasenia, String cargo) {
        super(cedula, nombre, apellido, usuario, contrasenia, cargo);
        this.grado = grado;
        this.especialidad = especialidad;
        this.gradoAcademico = gradoAcademico;
    }
    
    
}
