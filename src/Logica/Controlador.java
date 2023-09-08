package Logica;

import Persistencia.Persistencia_SQL;
import Entidades.Usuario;
import Grafica.Login_ventana;
import javax.swing.JTextField;


public class Controlador {
    
    
    public void validarUsuario(Usuario usuario) {
        Login_ventana login = new Login_ventana();       
        String nombreUsuario = login.getNombreUsuario();
        String contraseniaUsuario = login.getContraseniaUsuario();
        
        System.out.println(nombreUsuario);
        System.out.println(contraseniaUsuario);
        
        /*Usuario usuarioObtenido = obtenerUsuarioYContrasenia(nombreUsuario, contraseniaUsuario);
       
        if (usuarioObtenido != null && nombreUsuario.equals(usuarioObtenido.getUsuario()) && contraseniaUsuario.equals(usuarioObtenido.getContrasenia())) {
            return true;
        } else {
            return false;
        }*/
    }
    
    public void abrirVentana(Usuario usuario){
        
    }
}
