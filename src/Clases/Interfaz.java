/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package Clases;

import Grafica.Login;

/**
 *
 * @author SDFA
 */
public class Interfaz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //COMENTARIO
        //Mostrar Login
        Conexion cx=new Conexion();
        cx.conectarMySQL();
       
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        /// sdjaskfjks
        
        //Mostrar Admin
        /*Administrador admin = new Administrador();
        admin.setVisible(true);
        admin.setLocationRelativeTo(null);*/
   
        
    }
    
}
