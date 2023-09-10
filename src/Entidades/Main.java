package Entidades;

import Logica.GestorAdministradores;
import Logica.GestorDocentes;
import Logica.GestorAdscriptos;
import Grafica.Login_ventana;
import Logica.Controlador;
import Grafica.Administrador_ventana;
import Logica.GestorUsuarios;

import Persistencia.Persistencia_SQL;
import Logica.GestorAdministradores;


public class Main {


    public static void main(String[] args) {
       
        
        //COMENTARIO
        //Mostrar Login
        Conexion cx=new Conexion();
        cx.conectarMySQL();
       
        Login_ventana login = new Login_ventana();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        
        GestorAdministradores gestionarAdministradores = new GestorAdministradores();
        gestionarAdministradores.cargarAdministradoresDesdeBD();
        gestionarAdministradores.mostrarAdministradores();
        
        GestorDocentes gestionarDocentes = new GestorDocentes();
        gestionarDocentes.cargarDocentesDesdeBD();
        gestionarDocentes.mostrarDocentes();
       
        GestorAdscriptos gestionarAdscriptos = new GestorAdscriptos();
        gestionarAdscriptos.cargarAdscriptosDesdeBD();
        //gestionarAdscriptos.mostrarAdscriptos();
        
        
  
       
       
        
        
        //Mostrar Admin
        /*Administrador admin = new Administrador();
        admin.setVisible(true);
        admin.setLocationRelativeTo(null);*/
   
        
    }
    
}
