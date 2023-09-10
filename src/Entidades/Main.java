package Entidades;

import Grafica.Login_ventana;
import Logica.Controlador;
import Grafica.Administrador_ventana;
import Entidades.GestorUsuarios;


public class Main {


    public static void main(String[] args) {
       
        
        //COMENTARIO
        //Mostrar Login
        Conexion cx=new Conexion();
        cx.conectarMySQL();
       
        Login_ventana login = new Login_ventana();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        
        
        GestorDocentes gestionarDocentes = new GestorDocentes();
        gestionarDocentes.cargarDocentesDesdeBD();
        gestionarDocentes.mostrarDocentes();
        
        GestorAdministradores gestionarAdministradores = new GestorAdministradores();
        gestionarAdministradores.cargarAdministradoresDesdeBD();
        gestionarAdministradores.mostrarAdministradores();
       
        GestorAdscriptos gestionarAdscriptos = new GestorAdscriptos();
        gestionarAdscriptos.cargarAdscriptosDesdeBD();
        gestionarAdscriptos.mostrarAdscriptos();
        
        
  
       
       
        
        
        //Mostrar Admin
        /*Administrador admin = new Administrador();
        admin.setVisible(true);
        admin.setLocationRelativeTo(null);*/
   
        
    }
    
}
