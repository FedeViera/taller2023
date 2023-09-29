package Entidades;

import Logica.GestorAdministradores;
import Logica.GestorDocentes;
import Logica.GestorAdscriptos;
import Grafica.Login_ventana;
import Grafica.Administrador_ventana;
import Grafica.Adscripto_ventana;
import Grafica.Docente_ventana;
import Logica.GestorUsuarios;

import Persistencia.Persistencia_SQL;
import Logica.GestorAdministradores;
import Logica.GestorCursos;


public class Main {


    public static void main(String[] args) {
       
        
        //COMENTARIO
        //Mostrar Login
        Conexion cx=new Conexion();
        cx.conectarMySQL();
       /*
        Login_ventana login = new Login_ventana();
        login.setVisible(true);
        login.setLocationRelativeTo(null);*/
        
       
        Administrador_ventana adm = new Administrador_ventana();
        adm.setVisible(true);
        adm.setLocationRelativeTo(null);
        
        /*
        Adscripto_ventana ads = new Adscripto_ventana();
        ads.setVisible(true);
        ads.setLocationRelativeTo(null);*/
        
        /*
        Docente_ventana doc = new Docente_ventana();
        doc.setVisible(true);
        doc.setLocationRelativeTo(null);*/
        
        
        
        /*
        GestorAdministradores gestionarAdministradores = new GestorAdministradores();
        gestionarAdministradores.cargarAdministradoresDesdeBD();
        gestionarAdministradores.mostrarAdministradores();
        
        GestorDocentes gestionarDocentes = new GestorDocentes();
        gestionarDocentes.cargarDocentesDesdeBD();
        gestionarDocentes.mostrarDocentes();
       
        GestorAdscriptos gestionarAdscriptos = new GestorAdscriptos();
        //gestionarAdscriptos.cargarAdscriptosDesdeBD();
        //gestionarAdscriptos.mostrarAdscriptos();
        
        //Mostrar Admin
        /*Administrador admin = new Administrador();
        admin.setVisible(true);
        admin.setLocationRelativeTo(null);*/
   
        
    }
    
}
