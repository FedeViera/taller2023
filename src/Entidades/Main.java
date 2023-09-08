package Entidades;

import Grafica.Login_ventana;
import Logica.Controlador;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //COMENTARIO
        //Mostrar Login
        Conexion cx=new Conexion();
        cx.conectarMySQL();
       
        Login_ventana login = new Login_ventana();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        /// sdjaskfjks
        
        Usuario usu = new Usuario();
        usu.setApellido("pepe");
        usu.setCedula(44444444);
        usu.setCargo("Administrador");
        usu.setContrasenia("sdassa");
        usu.setNombre("juan");
        usu.setUsuario("agustin");
        
        Controlador cont = new Controlador();
        cont.validarUsuario(usu);
       
       
        
        
        //Mostrar Admin
        /*Administrador admin = new Administrador();
        admin.setVisible(true);
        admin.setLocationRelativeTo(null);*/
   
        
    }
    
}
