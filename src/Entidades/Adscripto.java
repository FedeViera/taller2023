package Entidades;

public class Adscripto extends Usuario
{ 
    private String grado;
    private String turno;

    public Adscripto(String grado, String turno, int cedula, String nombre, String apellido, String usuario, String contrasenia, String cargo) {
        super(cedula, nombre, apellido, usuario, contrasenia, cargo);
        this.grado = grado;
        this.turno = turno;
    }
   
    
}
