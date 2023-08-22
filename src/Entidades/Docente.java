package Entidades;

public class Docente extends Usuario
{
    private int grado;
    private String asignatura;

    public Docente(int grado, String asignatura, int cedula, String nombre, String apellido, String usuario, String contrasenia, String cargo) {
        super(cedula, nombre, apellido, usuario, contrasenia, cargo);
        this.grado = grado;
        this.asignatura = asignatura;
    }
    
    
}
