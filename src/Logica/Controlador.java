package Logica;

import Persistencia.Persistencia_SQL;
import Entidades.Usuario;
import Grafica.Login_ventana;
import javax.swing.JTextField;


public class Controlador {
    
    
    public boolean validarUsuario(Usuario usuario) {
        Login_ventana login = new Login_ventana();       
        String nombreUsuario = login.getNombreUsuario();
        String contraseniaUsuario = login.getContraseniaUsuario();

        // Crear una instancia de Persistencia_SQL
        Persistencia_SQL persistencia = new Persistencia_SQL();

        Usuario usuarioObtenido = persistencia.obtenerUsuarioYContrasenia(nombreUsuario, contraseniaUsuario);

        if (usuarioObtenido != null && nombreUsuario.equals(usuarioObtenido.getUsuario()) && contraseniaUsuario.equals(usuarioObtenido.getContrasenia())) {
            return true;
        } else {
            return false;
    }
}
    
    public void abrirVentana(Usuario usuario){
        
    }
}
