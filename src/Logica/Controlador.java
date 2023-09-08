package Logica;

import Persistencia.Persistencia_SQL;
import Entidades.Usuario;
import Grafica.Login_ventana;
import Grafica.Administrador_ventana;
import Grafica.Adscripto_ventana;
import Grafica.Docente_ventana;
import javax.swing.JTextField;


public class Controlador {
    
    
    public boolean validarUsuario(Usuario usuario) {
        Login_ventana login = new Login_ventana();       
        String nombreUsuario = login.getNombreUsuario();
        String contraseniaUsuario = login.getContraseniaUsuario();
        String cargoUsuario=null;
        String apellidoUsuario=null;        

        //Instancia de Persistencia_SQL
        Persistencia_SQL persistencia = new Persistencia_SQL();

        Usuario usuarioObtenido = persistencia.obtenerUsuarioYContrasenia(nombreUsuario, contraseniaUsuario, cargoUsuario, nombreUsuario, apellidoUsuario);;
        if (usuarioObtenido != null && nombreUsuario.equals(usuarioObtenido.getUsuario()) && contraseniaUsuario.equals(usuarioObtenido.getContrasenia())) {
            return true;
        } else {
            return false;
        }
    }
    
    
    
    
    public void obtenerCargo(Usuario usuario){
        
    }

 
}
