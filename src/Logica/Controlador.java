package Logica;

import Persistencia.Persistencia_SQL;
import Entidades.Usuario;
import javax.swing.JTextField;


public class Controlador {

//VALIDAR USUARIO
    public boolean validarUsuario(String usuario, String contrasenia) {
        // Instancia de Persistencia_SQL
        Persistencia_SQL persistencia = new Persistencia_SQL();

        Usuario usuarioObtenido = persistencia.mapearUsuario(usuario, contrasenia);

        if (usuarioObtenido != null && usuario.equals(usuarioObtenido.getUsuario()) && contrasenia.equals(usuarioObtenido.getContrasenia())) {
            return true;
        } else {
            return false;
        }
    }
   
    
    
//OBTENER CARGO
    public String obtenerCargo(String usuario, String contrasenia) {
        String cargo = null;
        Persistencia_SQL persistencia = new Persistencia_SQL();
        Usuario cargoUsuario = persistencia.mapearUsuario(usuario, contrasenia);

        if (cargoUsuario != null) {
            cargo = cargoUsuario.getCargo();
        }

        return cargo;
    }


//OBTENER NOMBRE Y APELLIDO    
    public String obtenerNombreyApellido(String usuario, String contrasenia) {
        String nombreApellido = null;
        Persistencia_SQL persistencia = new Persistencia_SQL();
        Usuario cargoUsuario = persistencia.mapearUsuario(usuario, contrasenia);

        if (cargoUsuario != null) {
            // Combina el nombre y el apellido en una sola cadena
            nombreApellido = cargoUsuario.getNombre() + " " + cargoUsuario.getApellido();
        }

        return nombreApellido;
    }


 
}
