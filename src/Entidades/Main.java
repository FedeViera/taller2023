package Entidades;

import Grafica.Login_ventana;

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
        
        //Mostrar Admin
        /*Administrador admin = new Administrador();
        admin.setVisible(true);
        admin.setLocationRelativeTo(null);*/
   
        
    }
    
}
