package Entidades;

public class Adscripto extends Usuario
{ 
    private int grado;

    public Adscripto(int grado, int cedula, String nombre, String apellido, String usuario, String contrasenia, String cargo) {
        super(cedula, nombre, apellido, usuario, contrasenia, cargo);
        this.grado = grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public int getGrado() {
        return grado;
    }

    public Adscripto() {
    }

    
    
    
   
    
}
