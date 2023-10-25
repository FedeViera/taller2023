package Entidades;

public class UsuarioLogeo extends Usuario {
    public UsuarioLogeo() {
        // Constructor por defecto de la subclase
    }

    public UsuarioLogeo(int cedula, String nombre, String apellido, String usuario, String contrasenia, String cargo) {
        // Constructor con parámetros de la subclase
        setCedula(cedula);
        setNombre(nombre);
        setApellido(apellido);
        setUsuario(usuario);
        setContrasenia(contrasenia);
        setCargo(cargo);
    }
}

